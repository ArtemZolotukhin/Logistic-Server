package kpfu.logistic.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {


    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_DRIVER = "DRIVER";

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @NotNull
    @Column(
            name = "id",
            unique = true
    )
    private Long id;

    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @Column(
            name = "phone_number",
            unique = true
    )
    private String phoneNumber;


    @NotNull
    @Column(
            name = "password_crypted",
            unique = false
    )
    private String passwordCrypted;

    @NotNull
    @Column(
            name = "first_name",
            unique = false
    )
    private String firstName;

    @Column(
            name = "second_name",
            unique = false
    )
    private String secondName;

    @Column(
            name = "role",
            unique = true
    )
    private String role;


    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserToken token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordCrypted() {
        return passwordCrypted;
    }

    public void setPasswordCrypted(String passwordCrypted) {
        this.passwordCrypted = passwordCrypted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public UserToken getToken() {
        return token;
    }

    public void setToken(UserToken token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(passwordCrypted, user.passwordCrypted) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, phoneNumber, passwordCrypted, firstName, secondName, role);
    }
}


