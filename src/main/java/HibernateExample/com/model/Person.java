package HibernateExample.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person-id")
    private int personId;

    @Column(name = "person-name")
    private String personName;

    @Column(name = "person-surname")
    private String personSurname;

    @Column(name = "person-age")
    private int personAge;

}