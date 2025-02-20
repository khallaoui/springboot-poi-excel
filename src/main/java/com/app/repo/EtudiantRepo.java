
package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Etudiant;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Integer> {

	Optional<Etudiant> findById(Integer id);

}
