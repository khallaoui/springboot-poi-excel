package com.app.repo;

import com.app.entities.SessionEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionEtudiantRepo extends JpaRepository<SessionEtudiant, Integer> {
    // You can add custom query methods here if needed
}
