package spring.springbootlesson3.store;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    Integer price;
    @ManyToOne
    Section section;
    private Integer number;
    private Integer residue;
    @ManyToOne
    private Factory factory;
}
