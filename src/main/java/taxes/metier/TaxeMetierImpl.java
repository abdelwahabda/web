package taxes.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import taxes.dao.EntrepriseRepository;
import taxes.dao.TaxeRepository;
import taxes.entities.Entreprise;
import taxes.entities.Taxe;

@Service
@Transactional
public class TaxeMetierImpl implements ITaxeMetier {
    @Autowired
    private EntrepriseRepository entrepriseR;
    @Autowired
    private TaxeRepository       taxeR;

    @Override
    public Entreprise getEntreprise( Long code ) {
        // TODO Auto-generated method stub
        Optional<Entreprise> e = entrepriseR.findById( code );
        return e.get();
    }

    @Override
    public Entreprise addEntreprise( Entreprise e ) {
        // TODO Auto-generated method stub
        return entrepriseR.save( e );
    }

    @Override
    public void deleteEntreprise( Long code ) {
        entrepriseR.deleteById( code );

    }

    @Override
    public Page<Entreprise> getAllEntreprise( int page, int size ) {
        // TODO Auto-generated method stub
        return entrepriseR.findAll( new PageRequest( page, size ) );
    }

    @Override
    public Page<Entreprise> getEntrepriseByKeyWork( String mc, int page, int size ) {
        // TODO Auto-generated method stub
        return entrepriseR.listeEntrepriseParMC( mc, new PageRequest( page, size ) );
    }

    @Override
    public Taxe getTaxe( Long id ) {
        Optional<Taxe> t = taxeR.findById( id );
        return t.get();
    }

    @Override
    public Taxe addTaxe( Taxe t ) {
        // TODO Auto-generated method stub
        return taxeR.save( t );
    }

    @Override
    public void deleteTaxe( Long id ) {
        taxeR.deleteById( id );

    }

    @Override
    public Page<Taxe> getAllTaxeByEntreprise( Entreprise e, int page ) {
        // TODO Auto-generated method stub
        return taxeR.findByEntreprise( e, new PageRequest( page, 4 ) );

    }

    @Override
    public Entreprise getEntrepriseByName( String nom ) {
        // TODO Auto-generated method stub
        return entrepriseR.retournEntreprise( nom );
    }

    @Override
    public List<String> getAllNameEntreprise() {
        // TODO Auto-generated method stub
        return entrepriseR.listeNomEntreprise();
    }

}
