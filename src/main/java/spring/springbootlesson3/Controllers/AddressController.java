package spring.springbootlesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springbootlesson3.Readers.AdressRepository;
import spring.springbootlesson3.Tables.Adress;
import spring.springbootlesson3.store.Factory;

import java.util.List;

@RestController
@RequestMapping()
public class AddressController {
    @Autowired
    AdressRepository adressRepository;

    @GetMapping("/all")
    public List<Adress> all() {
        return adressRepository.findAll();
    }

    @GetMapping("/byId")
    public Adress byid(@PathVariable Integer id) {
        if (!adressRepository.existsById(id)) return new Adress();
        return adressRepository.findById(id).get();
    }

    @DeleteMapping("/delete{id}")
    public String delete(@PathVariable Integer id) {
        if (!adressRepository.existsById(id)) return " id isn`t exists";
        adressRepository.deleteById(id);
        return "done";
    }

    @PostMapping("/add")
    public String add(@RequestBody Adress adress) {
        adressRepository.save(adress);
        return "saved";
    }

    @PutMapping("/update")
    public String update(@RequestBody Adress adress) {
        adressRepository.save(adress);
        return " done";

    }
}
