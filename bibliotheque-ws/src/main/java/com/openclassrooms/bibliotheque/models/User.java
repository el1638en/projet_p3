package com.openclassrooms.bibliotheque.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// Classe representant un utilisateur bibliothécaire
@Entity
@Table(name = "T_UTILISATEUR")

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "U_ID")
    private Long id;

    @Column(name = "U_NAME")
    private String name;

    @Column(name = "U_FIRST_NAME")
    private String firstName;

    @Column(name = "U_USERNAME")
    private String username;

    @Column(name = "U_PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
