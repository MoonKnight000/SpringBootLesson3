package spring.springbootlesson3.Tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.springbootlesson3.Tables.Adress;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    @OneToOne(optional = false)
    private Adress adress;
}
