package com.app.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String alias;
    private String nom;

    @ManyToOne
    private Niveau niveauSuivant;

    @ManyToOne
    private Filiere filiere;

    @OneToMany(mappedBy = "niveau")
    private List<Module> modules;
   
    
    @OneToMany(mappedBy = "niveau")
    private List<Inscription> inscriptions;
}
