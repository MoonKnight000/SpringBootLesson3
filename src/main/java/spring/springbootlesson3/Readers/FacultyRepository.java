package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springbootlesson3.Tables.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    boolean existsByNameAndUniversityId(String name, Integer universityId);

    List<Faculty> findAllByUniversityId(Integer university_id);
}
