package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springbootlesson3.Readers.SubjectRepository;
import spring.springbootlesson3.Tables.Subject;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String addSubject(@RequestBody Subject subject) {
        boolean b = subjectRepository.existsByName(subject.getName());
        if (b)
            return " bu mavjud";

        return " fan qo`shilli";
    }

    //    @RequestMapping(method = RequestMethod.GET)
//    public List<Subject> all() {
//        return subjectRepository.findAll();
//    }
    @GetMapping()
    public List<Subject> all() {
        return subjectRepository.findAll();

    }
}
