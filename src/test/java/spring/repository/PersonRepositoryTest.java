package spring.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.history.Revisions;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import spring.entity.Person;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {})
@ActiveProfiles("entity-person")
@AutoConfigureMockMvc
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Before
    @Transactional
    public void setUp() {
       repository.save(Person
                .builder()
                .name("name")
                .lastName("lastName")
                .build());
    }


    @Test
    @Transactional
    public void methodTest() {
       Person person = repository.findById(Long.valueOf(1)).get();
       person.setLastName("*****");
       repository.save(person);

       Person resultado = repository.findById(Long.valueOf(1)).get();

       Revisions<Integer, Person> revisiones = repository.findRevisions(person.getId());
       Stream<Person> personStream = repository.findAllByName("Edwin Mendez");

       personStream.findFirst().map(person1 -> {
          return person1;
       });
    }


}
