package spring.springbootlesson3.Readers;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springbootlesson3.Tables.Adress;

public interface AdressRepository  extends JpaRepository<Adress,Integer> {
}
