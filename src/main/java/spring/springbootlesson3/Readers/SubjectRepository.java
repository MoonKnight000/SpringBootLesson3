package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springbootlesson3.Tables.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    boolean existsByName(String name);
//    List<Subject> findO(String type);
//    List<Subject>
}
