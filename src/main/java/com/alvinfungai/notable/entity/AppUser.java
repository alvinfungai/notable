package com.alvinfungai.notable.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppUser {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Id
    private Long id;
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private Boolean enabled;

    public AppUser(
            String username,
            String email,
            String password,
            Boolean enabled
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
}
