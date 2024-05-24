package taxes.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import taxes.entities.Entreprise;
import taxes.entities.Taxe;

public interface ITaxeMetier {

    public Entreprise getEntreprise( Long code );

    public Entreprise getEntrepriseByName( String nom );

    public Entreprise addEntreprise( Entreprise e );

    public void deleteEntreprise( Long code );

    public List<String> getAllNameEntreprise();

    public Page<Entreprise> getAllEntreprise( int page, int size );

    public Page<Entreprise> getEntrepriseByKeyWork( String mc, int page, int size );

    public Taxe getTaxe( Long id );

    public Taxe addTaxe( Taxe t );

    public void deleteTaxe( Long id );

    // public Page<Taxe> getAllTaxe( int page, int size );

    public Page<Taxe> getAllTaxeByEntreprise( Entreprise e, int page );
}
