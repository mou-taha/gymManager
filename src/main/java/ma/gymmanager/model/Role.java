package ma.gymmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String role;
}