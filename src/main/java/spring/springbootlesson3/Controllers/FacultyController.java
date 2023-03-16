package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springbootlesson3.Readers.FacultyRepository;
import spring.springbootlesson3.Readers.UniversityRepository;
import spring.springbootlesson3.Tables.Faculty;
import spring.springbootlesson3.save_temporary.FacultyDto;

import java.util.List;

@RestController
@RequestMapping(value = "faculty")
public class FacultyController {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;

    @PostMapping
    public String add(@RequestBody FacultyDto facultyDto) {
        if (facultyRepository.existsByNameAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId()))
            return " bu mavjud";
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        if (!universityRepository.findById(facultyDto.getUniversityId()).isPresent())
            return " bu universitet mavjud emas";
        faculty.setUniversity(universityRepository.findById(facultyDto.getUniversityId()).get());
        facultyRepository.save(faculty);
        return " qo`shildi";
    }

    @GetMapping
    public List<Faculty> all() {
        return facultyRepository.findAll();
    }

    @GetMapping(value = "/byUniversity{id}")
    public List<Faculty> byUniversitet(@PathVariable Integer id) {
        return facultyRepository.findAllByUniversityId(id);

    }

    @DeleteMapping("/deleteById{id}")
    public String delete(@PathVariable Integer id) {
        if (!facultyRepository.existsById(id)) return " id isn`t exist";
        facultyRepository.deleteById(id);
        return " deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody FacultyDto dto) {
        if (!facultyRepository.existsById(dto.getId())) return "id isn`t exist";
        Faculty faculty = new Faculty();
        faculty.setId(dto.getId());
        faculty.setName(dto.getName());
        faculty.setUniversity(universityRepository.findById(dto.getId()).get());
        facultyRepository.save(faculty);
        return " updated ";
    }
}
