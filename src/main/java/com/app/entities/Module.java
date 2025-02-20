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
public class Module { // Renamed from Module
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;


    @ManyToOne
    private Enseignant enseignant;
    
    @ManyToOne
    private Niveau niveau;
    
    @ManyToOne
    private Deliberation deliberation ;

    @OneToMany(mappedBy= "module")
    private List<Element> elements;
}
