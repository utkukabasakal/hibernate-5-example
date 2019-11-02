package HibernateExample.com.dao;

import HibernateExample.com.model.Person;
import HibernateExample.com.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public PersonDAOImpl() {
       entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
      entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Person findbyId(Integer id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT person FROM Person AS person")
                .getResultList();
    }

    @Override
    public void insert(Person person) {
        entityTransaction.begin();
        entityManager.persist(person);
        entityTransaction.commit();
    }

    @Override
    public void deleteById(Integer id) {
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, id);
        if (person != null){
            entityManager.remove(person);
        }
        entityTransaction.commit();
    }

    @Override
    public void delete(Person person) {
        entityTransaction.begin();
        entityManager.remove(person);
        entityTransaction.commit();
    }

    @Override
    public void update(Person person) {
        entityTransaction.begin();
        entityManager.merge(person);
        entityTransaction.commit();
    }
}
