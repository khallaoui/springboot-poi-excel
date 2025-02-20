package com.app.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date anneeAcc;
    private Date anneeFinAcc;
    private String intitule;
    private String alias;
    
    @OneToOne
    private Enseignant coordinateur;

    @OneToMany(mappedBy = "filiere")
    private List<Niveau> niveaus;
    
    @ManyToOne
    private Deliberation deliberation;

}