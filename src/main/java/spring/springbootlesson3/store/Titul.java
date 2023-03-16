package spring.springbootlesson3.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Titul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;
}
