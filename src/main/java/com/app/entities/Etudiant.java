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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cne;
    private String cni;
    private String nom;
    private String prenom;
    private String type;

    
    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> inscriptions;
    
    @OneToMany(mappedBy = "etudiant")
    private List<SessionEtudiant> sessionEtudiants;
}