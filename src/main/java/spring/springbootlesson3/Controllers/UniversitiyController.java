package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springbootlesson3.Readers.AdressRepository;
import spring.springbootlesson3.Readers.UniversityRepository;
import spring.springbootlesson3.Tables.Adress;
import spring.springbootlesson3.Tables.University;
import spring.springbootlesson3.save_temporary.UniversityDto;

import java.util.List;
import java.util.Optional;

@RestController
public class UniversitiyController {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AdressRepository adressRepository;

    @RequestMapping(value = "/university", method = RequestMethod.GET)
    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    @RequestMapping(value = "university", method = RequestMethod.POST)
    public String addUniversity(@RequestBody UniversityDto universityDto) {
        Adress adress = new Adress();
        adress.setCity(universityDto.getCity());
        adress.setDistrict(universityDto.getDistrict());
        adress.setStreet(universityDto.getStreet());
        Adress savedAdress = adressRepository.save(adress);
        University university = new University();
        university.setAdress(savedAdress);
        university.setName(universityDto.getName());
        universityRepository.save(university);
        return "bolli";
    }

    @RequestMapping(value = "/university{id}", method = RequestMethod.PUT)
    public String Update(@PathVariable Integer id, @RequestBody UniversityDto universityDto) {
        Optional<University> byId = universityRepository.findById(id);
        if (byId.isPresent()) {//bor bo`lsa
            University university = byId.get();
            university.setName(universityDto.getName());
            university.getAdress().setCity(universityDto.getCity());
            university.getAdress().setStreet(universityDto.getStreet());
            university.getAdress().setDistrict(universityDto.getDistrict());
            universityRepository.save(university);
            adressRepository.save(university.getAdress());
        }
        return "boldi";
    }

    @RequestMapping(value = "/university{id}", method = RequestMethod.DELETE)
    public String Delete(@PathVariable Integer id) {
        universityRepository.deleteById(id);
        return "deleted";
    }
}
