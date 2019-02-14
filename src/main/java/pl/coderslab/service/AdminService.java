package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Admin;
import pl.coderslab.repository.AdminRepository;


@Component
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void save(Admin admin) {
        String password = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
        admin.setPassword(password);
        adminRepository.save(admin);
    }

    public Boolean login(String email, String password) {
        Admin admin = adminRepository.findOneByEmail(email);
        if (admin != null) {
            String hashed = admin.getPassword();
            if (BCrypt.checkpw(password, hashed)) {
                return true;
            }
        }
        return false;
    }
}
