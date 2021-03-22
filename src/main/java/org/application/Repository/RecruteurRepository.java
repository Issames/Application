package org.application.Repository;

import org.application.entities.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {

	
}



