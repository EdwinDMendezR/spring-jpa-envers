package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Person;

import java.util.stream.Stream;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, RevisionRepository<Person, Long, Integer> {

    Stream<Person> findAllByName(String author);

}
