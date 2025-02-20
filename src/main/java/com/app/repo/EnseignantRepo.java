
package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Enseignant;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Integer> {

}
