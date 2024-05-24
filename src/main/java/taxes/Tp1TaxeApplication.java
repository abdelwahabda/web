package taxes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import taxes.dao.EntrepriseRepository;
import taxes.dao.TaxeRepository;

@SpringBootApplication
public class Tp1TaxeApplication implements CommandLineRunner {
    @Autowired
    private TaxeRepository       taxeReposytory;
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public static void main( String[] args ) {
        SpringApplication.run( Tp1TaxeApplication.class, args );
    }

    @Override
    public void run( String... args ) throws Exception {
        // Ajout de 3 entreprise

        /*
         * Entreprise e1 = entrepriseRepository.save( new Entreprise( "Andado",
         * "andado@gmail.com",
         * "Andado est une société evoluant dans le domaine de l'informatique" )
         * ); Entreprise e2 = entrepriseRepository.save( new Entreprise(
         * "Ecobank", "ecobank@gmail.com",
         * "Ecobank est une agence evoluant dans le domaine de l'économie" ) );
         * Entreprise e3 = entrepriseRepository.save( new Entreprise( "Sonatel",
         * "sonatel@gmail.com",
         * "Sonatel est une société evoluant dans le domaine de télécomunication"
         * ) ); // Ajout // des // taxe
         * 
         * Taxe t1 = taxeReposytory.save( new TVA( "TVA Habitation", new Date(),
         * 9000, e1 ) ); Taxe t2 = taxeReposytory.save( new TVA( "TVA Voiture",
         * new Date(), 12000, e1 ) ); Taxe t3 = taxeReposytory.save( new IR(
         * "TVA Location", new Date(), 1500, e3 ) ); Taxe t4 =
         * taxeReposytory.save( new IR( "TVA Courant", new Date(), 2300, e1 ) );
         * Taxe t5 = taxeReposytory.save( new TVA( "TVA Courant", new Date(),
         * 1000, e3 ) ); Taxe t6 = taxeReposytory.save( new TVA(
         * "TVA Habitation", new Date(), 9000, e2 ) ); Taxe t7 =
         * taxeReposytory.save( new IR( "TVA Voiture", new Date(), 15000, e2 )
         * ); Taxe t8 = taxeReposytory.save( new TVA( "TVA Habitation", new
         * Date(), 9000, e1 ) ); Taxe t9 = taxeReposytory.save( new IR(
         * "TVA Publicitaire", new Date(), 34000, e2 ) ); Taxe t10 =
         * taxeReposytory.save( new TVA( "TVA Habitation", new Date(), 9000, e2
         * ) ); Taxe t11 = taxeReposytory.save( new IR( "TVA Voiture", new
         * Date(), 10000, e3 ) );
         */
        /*
         * Entreprise e = entrepriseRepository.findById( new Long( 1 ) ).get();
         * taxeReposytory.findByEntreprise( e ) .forEach( t ->
         * System.out.println( t.getTitre() + " , " + t.getMontant() ) );
         * System.out.println( "test" );
         */

        entrepriseRepository.listeNomEntreprise().forEach( e -> System.out.println( e ) );

    }
}
