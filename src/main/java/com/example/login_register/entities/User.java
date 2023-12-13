package com.example.login_register.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection ="Users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private Long id;
    private  String email;
    private  String password;
    private String name;

}
