package com.stackroute.customerservice.authenticationservice.entity;

<<<<<<< HEAD:authentication-service/src/main/java/com/stackroute/customerservice/authenticationservice/entity/User.java
import com.stackroute.customerservice.authenticationservice.enums.Roles;
=======
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:authentication-service/src/main/java/com/stackroute/authenticationservice/entity/User.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
}
