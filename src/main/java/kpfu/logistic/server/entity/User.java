package kpfu.logistic.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

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
            name = "password_crypt",
            unique = false
    )
    private String passwordCrypt;

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

    public String getPasswordCrypt() {
        return passwordCrypt;
    }

    public void setPasswordCrypt(String passwordCrypt) {
        this.passwordCrypt = passwordCrypt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(passwordCrypt, user.passwordCrypt) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, phoneNumber, passwordCrypt, firstName, secondName);
    }
}


