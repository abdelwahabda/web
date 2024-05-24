package taxes.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import taxes.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query( "select e from Entreprise e where e.nom like :x" )
    public abstract Page<Entreprise> listeEntrepriseParMC(
            @Param( "x" ) String mc, Pageable pageable );

    @Query( "select e.nom from Entreprise e" )
    public abstract List<String> listeNomEntreprise();

    @Query( "select e from Entreprise e where e.nom = :x" )
    public abstract Entreprise retournEntreprise( @Param( "x" ) String nom );
}
