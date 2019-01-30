package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.DayName;

public interface DayNameRepository extends JpaRepository<DayName, Long> {

}
