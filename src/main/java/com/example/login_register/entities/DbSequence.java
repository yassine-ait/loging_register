package com.example.login_register.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {

        @Id
        private String  id;
        private int seq;

}
