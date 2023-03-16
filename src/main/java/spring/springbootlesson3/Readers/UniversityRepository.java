package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springbootlesson3.Tables.University;

public interface UniversityRepository extends JpaRepository<University,Integer> {
}
