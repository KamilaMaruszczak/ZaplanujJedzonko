package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    long countByAdmin(Admin admin);
    Plan findFirstByAdminOrderByCreatedDesc(Admin admin);
    List<Plan> findAllByAdmin(Admin admin);

}
