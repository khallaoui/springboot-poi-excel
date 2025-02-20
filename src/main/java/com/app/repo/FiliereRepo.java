
package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Filiere;

import java.util.List;
import java.util.Optional;

@Repository
public interface FiliereRepo extends JpaRepository<Filiere,Integer> {

}
