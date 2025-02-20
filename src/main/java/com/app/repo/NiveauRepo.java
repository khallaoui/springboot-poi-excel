
package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Etudiant;
import com.app.entities.Niveau;

import java.util.List;
import java.util.Optional;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau,Integer> {

	Optional<Niveau> findByNom(String niveauNom);

}
