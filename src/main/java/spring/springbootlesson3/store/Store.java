package spring.springbootlesson3.store;

import jakarta.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    Adress adress;
}
