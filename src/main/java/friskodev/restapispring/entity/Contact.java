package friskodev.restapispring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacs")
public class Contact {

    @Id
    private String id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    private String phone;

    private String email;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
