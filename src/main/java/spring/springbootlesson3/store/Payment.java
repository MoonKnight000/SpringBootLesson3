package spring.springbootlesson3.store;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long sum;
    @ManyToOne
    private Workers workers;
    @ManyToOne
    private User user;
    @ManyToOne
    private PaymentType paymentType;
}
