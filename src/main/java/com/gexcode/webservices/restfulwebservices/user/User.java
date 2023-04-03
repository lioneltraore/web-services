package com.gexcode.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "mono_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    @Column
    private String name;
    @Past
    @Column
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
