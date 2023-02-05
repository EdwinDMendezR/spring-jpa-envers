package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.Person;
import spring.repository.PersonRepository;

@RestController
public class JRestController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public String getMessage() {
        if(repository.findById(Long.valueOf(1)).isPresent()) {
            Person person = repository.findById(Long.valueOf(1)).get();
            person.setLastName("*****");
            repository.save(person);

        } else {
            repository.save(Person
                    .builder()
                    .id(Long.getLong("2"))
                    .name("name")
                    .lastName("lastName")
                    .build());
        }
        return "getMessage()";
    }

}
