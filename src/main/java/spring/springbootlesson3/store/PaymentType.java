package spring.springbootlesson3.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PaymentType {
    @Id
    @GeneratedValue
    private Integer id;
    String type;
}
