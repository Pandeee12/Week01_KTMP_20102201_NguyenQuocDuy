package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;
    @Column(name="user_name")
    private String name;

    @OneToMany(mappedBy = "user"
            ,fetch = FetchType.LAZY)
    private List<Product> products;

    public User(String name) {
        this.name = name;
    }
}
