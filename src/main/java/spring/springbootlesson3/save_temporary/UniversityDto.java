package spring.springbootlesson3.save_temporary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {
    String name;
    String city;
    String district;
    String street;
}
