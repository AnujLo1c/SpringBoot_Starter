package com.anujl.blacknwhite.models;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;
    private String firstName;
    private String lastName;
    private String password;

   
     private String username;
     @Email(message = "Email should be valid")
     @NotEmpty(message = "Email cannot be empty")
    private String email;
     private String role;
     @NotEmpty(message = "Phone number cannot be empty")
     private String phoneNumber;
        @NotEmpty(message = "Address cannot be empty")
        private String address;

private String gender;

@DateTimeFormat(pattern = "yyyy-MM-dd")
    
private LocalDate dateOfBirth;

private String profilePictureUrl;
private String token;

@DateTimeFormat(pattern = "HH:mm:ss")
   
private LocalTime tokenExpiryTime;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_authority",
            joinColumns = {@JoinColumn(name = "account_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
private Set<Authority> privilages = new HashSet<>();
        }
