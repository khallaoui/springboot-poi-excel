package com.app.repo;

import com.app.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
    // Additional query methods can be defined here if needed
}
