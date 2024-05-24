package taxes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taxes.dao.EntrepriseRepository;
import taxes.entities.Entreprise;
import taxes.metier.ITaxeMetier;

@RestController
public class TaxeRestController {
    @Autowired
    private ITaxeMetier          metier;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @RequestMapping( "/listeEntreprises" )
    public Page<Entreprise> entreprise( int page, int size ) {
        return entrepriseRepository.findAll( new PageRequest( page, size ) );
    }

}
