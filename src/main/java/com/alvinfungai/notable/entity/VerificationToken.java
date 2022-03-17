package com.alvinfungai.notable.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VerificationToken {

    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    @Id
    private Long id;
    private String token;
    private LocalDateTime expiresAt;
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    public VerificationToken(String token, AppUser user) {
        this.token = token;
        this.expiresAt = LocalDateTime.now().plusHours(1); // valid for 1 hour
        this.user = user;
    }
}
