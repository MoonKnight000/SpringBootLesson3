package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springbootlesson3.Readers.FacultyRepository;
import spring.springbootlesson3.Readers.GroupRepository;
import spring.springbootlesson3.Tables.Group;
import spring.springbootlesson3.save_temporary.GroupDto;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping(value = "/byUniversityID/{universityId}")
    public List<Group> getGroupsbyUniversityId(@PathVariable Integer id) {
        return groupRepository.getGroupByUniversityId(id);
    }

    @PostMapping()
    public String add(@RequestBody GroupDto groupDto) {
        Group group = new Group();
        group.setName(groupDto.getName());
        group.setFaculty(facultyRepository.findById(groupDto.getFacultyId()).get());
        return " chotki ";
    }

    @PutMapping(value = "/group{id}")
    public String update(@PathVariable Integer id, @RequestBody GroupDto groupDto) {
        Group group = groupRepository.findById(id).get();
        group.setName(groupDto.getName());
        group.setFaculty(facultyRepository.findById(groupDto.getFacultyId()).get());
        groupRepository.save(group);
        return " update qilindi";
    }
}
