package spring.springbootlesson3.store;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    @ManyToOne
    Adress adress;
    @ManyToOne
    Gender gender;
    Integer balance;
    String phone_number;
}