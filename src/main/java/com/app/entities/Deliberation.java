package com.app.entities;




import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deliberation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String anneeUniversitaire;
    private Date dateDeliberation;

    @OneToMany(mappedBy = "deliberation")
    private List<Filiere> filieres;

    @OneToMany(mappedBy = "deliberation")
    private List<Module> modules;

}
