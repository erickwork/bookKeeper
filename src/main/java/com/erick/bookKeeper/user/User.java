package com.erick.bookKeeper.user;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity(name = "USer")
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(CadastroUser cadastroUser) {

        this.name = cadastroUser.name();
        this.email = cadastroUser.email();
    }
}
