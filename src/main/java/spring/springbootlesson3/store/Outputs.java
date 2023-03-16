package spring.springbootlesson3.store;

import jakarta.persistence.*;

@Entity
public class Outputs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;
    private Integer num;
    private Integer sum;
}
