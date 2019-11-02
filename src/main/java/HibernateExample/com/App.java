package HibernateExample.com;

import HibernateExample.com.dao.PersonDAO;
import HibernateExample.com.dao.PersonDAOImpl;
import HibernateExample.com.model.Person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAOImpl();

        Person person1 = new Person();
        person1.setPersonName("Ahmet");
        person1.setPersonSurname("Koç");
        person1.setPersonAge(20);

        Person person2 = new Person();
        person2.setPersonName("Ayşe");
        person2.setPersonSurname("Yılmaz");
        person2.setPersonAge(32);

        Person person3 = new Person();
        person3.setPersonName("Ali");
        person3.setPersonSurname("Yıldırım");
        person3.setPersonAge(25);

        personDAO.insert(person1);
        personDAO.insert(person2);
        personDAO.insert(person3);

        List<Person> people = personDAO.findAll();
        people.forEach(person -> {
            System.out.println(person);
        });
       // personDAO.insert(new Person("Ahmet", "Koç", 20));
    }
}
