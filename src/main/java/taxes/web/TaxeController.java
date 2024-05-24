package taxes.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import taxes.entities.Entreprise;
import taxes.entities.Taxe;
import taxes.metier.ITaxeMetier;

@Controller
public class TaxeController {
    @Autowired
    private ITaxeMetier  metier;

    private List<String> namesEntreprise;

    @RequestMapping( value = "/entreprises", method = RequestMethod.GET )
    public String home( Model model,
            @RequestParam( value = "page", defaultValue = "0" ) int p ) {
        Page<Entreprise> entreprises = metier.getAllEntreprise( p, 5 );
        model.addAttribute( "entreprises", entreprises.getContent() );
        int[] pages = new int[entreprises.getTotalPages()];
        model.addAttribute( "pages", pages );
        model.addAttribute( "pageCourante", p );
        return "entreprises";
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public String index() {
        return "redirect:/entreprises";
    }

    @RequestMapping( value = "/consulterEntreprise", method = RequestMethod.GET )
    public String consulterEntreprise( Model model,
            @RequestParam( name = "motCle", defaultValue = "" ) String mc,
            @RequestParam( name = "page", defaultValue = "0" ) int p ) {
        Page<Entreprise> entreprises = metier.getEntrepriseByKeyWork( "%" + mc + "%", p, 5 );
        model.addAttribute( "entreprises", entreprises.getContent() );
        int[] pages = new int[entreprises.getTotalPages()];
        model.addAttribute( "pages", pages );
        model.addAttribute( "pageCourante", p );
        model.addAttribute( "motCle", mc );
        return "entreprises";
    }

    @RequestMapping( value = "/formEntreprise", method = RequestMethod.GET )
    public String formulaire( Model model ) {
        model.addAttribute( "entreprise", new Entreprise() );
        return "formulaire";
    }

    @RequestMapping( value = "/addEntreprise", method = RequestMethod.POST )
    public String addEntreprise( Model model,
            @Valid Entreprise e,
            BindingResult bindingResult ) {
        // BindingResult contient les erreurs enregistrer au
        // moment de l'enrégistrement
        if ( bindingResult.hasErrors() )
            return "formulaire";

        metier.addEntreprise( e );
        return "redirect:/entreprises";
    }

    @RequestMapping( value = "/taxes", method = RequestMethod.GET )
    public String taxes( Model model,
            @RequestParam( name = "code", defaultValue = "1" ) Long code,
            @RequestParam( name = "page", defaultValue = "0" ) int page ) {
        Entreprise e = new Entreprise();
        e.setCode( code );
        Page<Taxe> taxes = metier.getAllTaxeByEntreprise( e, page );

        namesEntreprise = metier.getAllNameEntreprise();
        int[] pages = new int[taxes.getTotalPages()];
        model.addAttribute( "taxes", taxes.getContent() );
        model.addAttribute( "pages", pages );
        model.addAttribute( "pageCourante", page );
        model.addAttribute( "code", code );
        model.addAttribute( "listeNoms", namesEntreprise );
        return "taxes";
    }

    @RequestMapping( value = "/listeTaxes", method = RequestMethod.GET )
    public String listeTaxes( Model model,
            @RequestParam( name = "nomEntreprise", defaultValue = "" ) String nom,
            @RequestParam( name = "page", defaultValue = "0" ) int p ) {
        Entreprise e = metier.getEntrepriseByName( nom );
        Page<Taxe> taxes = metier.getAllTaxeByEntreprise( e, p );
        int[] pages = new int[taxes.getTotalPages()];
        model.addAttribute( "taxes", taxes.getContent() );
        model.addAttribute( "pages", pages );
        model.addAttribute( "pageCourante", p );
        model.addAttribute( "code", e.getCode() );
        model.addAttribute( "listeNoms", namesEntreprise );
        return "taxes";
    }

    @RequestMapping( value = "/addTaxe", method = RequestMethod.POST )
    public String addTaxe( Model model,
            @Valid Taxe t ) {
        metier.addTaxe( t );
        return "taxes";
    }

}
