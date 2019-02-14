package pl.coderslab.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Admin;
import pl.coderslab.repository.AdminRepository;
import pl.coderslab.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    // rejestracja GET
    @RequestMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "registration";
    }


    // rejestracja POST
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPagePost(@Valid Admin admin, BindingResult result, Model model, @RequestParam String password2) {

        //walidacja pól
        int emails = adminRepository.countAllByEmail(admin.getEmail());
        if (result.hasErrors() || emails > 0 || !password2.equals(admin.getPassword()) ) {

            // sprawdzenie unikalności emaila
            if (emails > 0) {
                result.addError(new FieldError("admin", "email", "taki email jest już używany!"));
            }

            // sprawdzenie hasła
            if (!password2.equals(admin.getPassword())) {
                result.addError(new FieldError("admin", "password", "hasła się nie zgadzają"));
            }

            return "registration";
        }

        //zapisanie do bazy posolonego i zhashowanego hasła
        adminService.save(admin);
        return "redirect:/login";
    }

    // login GET
    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    // login POST
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPagePost(Model model, @RequestParam String email, @RequestParam String password, HttpSession session) {

        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
            Admin admin = adminRepository.findOneByEmail(email);

            if (admin == null) {
                model.addAttribute("admin", new Admin());
                model.addAttribute("errorMessage", "Nie znaleziono użytkownika z takim loginem!");
                return "login";
            } else {
                if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
                    session.setAttribute("admin", admin);
                    session.setMaxInactiveInterval(5 * 60);
                    return "redirect:/app/dashboard";
                } else {
                    model.addAttribute("admin", new Admin());
                    model.addAttribute("errorMessage", "Błędny login lub hasło!");
                    return "login";
                }
            }
        } else {
            model.addAttribute("admin", new Admin());
            model.addAttribute("errorMessage", "Podaj login i hasło!");
            return "login";
        }
    }

    // logout
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


}
