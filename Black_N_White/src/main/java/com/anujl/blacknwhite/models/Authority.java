package com.anujl.blacknwhite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String privilage;

    public Authority(Long id, String privilage) {
        this.id = id;
        this.privilage = privilage;
    }
public Authority(String privilage) {
        this.privilage = privilage;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", privilage='" + privilage + '\'' +
                '}';
    }
   
}
