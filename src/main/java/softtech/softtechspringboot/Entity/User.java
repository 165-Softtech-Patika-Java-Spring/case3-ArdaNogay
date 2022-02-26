package softtech.softtechspringboot.Entity;

import lombok.Getter;
import lombok.Setter;
import softtech.softtechspringboot.Enum.UserType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "User",sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME",length = 70, nullable = true)
    private String name;

    @Column(name = "SURNAME",length = 50,nullable = true)
    private String surname;

    @Column(name = "EMAIL",length = 40,nullable = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11,nullable = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30,nullable = true)
    private UserType userType;
}
