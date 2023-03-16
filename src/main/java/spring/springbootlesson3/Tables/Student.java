package spring.springbootlesson3.Tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne//u l a n i sh
    private Adress adress;
    @ManyToMany
    private List<Subject> subjects;
    @ManyToOne
    private Group group;
}
