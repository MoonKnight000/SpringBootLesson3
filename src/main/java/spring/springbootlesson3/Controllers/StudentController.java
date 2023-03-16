package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.springbootlesson3.Readers.StudentRepository;
import spring.springbootlesson3.Tables.Student;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public Page<String> all(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);//ma`lumotlarni birinma ketin sahifa qilib chiqarish
//        Pageable pageable = (Pageable) PageRequest.of(page, 10);
        Page<String> all = studentRepository.findAll(pageable);
        return all;
    }
}