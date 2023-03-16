package spring.springbootlesson3.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemsSold {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Product product;
    private double value;
}
