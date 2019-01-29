package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    long countByAdmin(Admin admin); //do przetestowania czy zadziała jak już dodamy Admina
    Plan findFirstByAdminOrderByCreatedDesc(Admin admin); //jw

}
