package spring.springbootlesson3.save_temporary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private String name;
    private Integer facultyId;
}
