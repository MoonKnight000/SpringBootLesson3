package spring.springbootlesson3.store;

import jakarta.persistence.*;

@Entity
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    Integer salary;
    @ManyToOne
    Titul titul;
    @ManyToOne
    Gender gender;
}
