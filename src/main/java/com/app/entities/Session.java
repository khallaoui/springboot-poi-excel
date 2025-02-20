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
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateSession;
    private Date dateUnv;
    private String nom;
    private String alias;

    @OneToMany(mappedBy = "session")
    private List<SessionEtudiant> sessionEtudiants;
}
