package org.application.Repository;

import java.util.List;

import org.application.entities.Offre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offre, Long> {
//		public List<Offre> findBypost(String poste);
//		public List<Offre> findBypost(String poste, Pageable pageable);
}
