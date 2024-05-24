package taxes.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import taxes.entities.Entreprise;
import taxes.entities.Taxe;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {

    public Page<Taxe> findByEntreprise( Entreprise e, Pageable pageable );
}
