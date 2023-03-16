package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<String ,Integer> {
}
