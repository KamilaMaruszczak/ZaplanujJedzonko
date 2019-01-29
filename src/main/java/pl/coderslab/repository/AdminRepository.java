package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneByEmail(String email);
    int countAllByEmail(String email);


}
