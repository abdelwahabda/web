package taxes.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "TAXES" )
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "TYPE_TAXE", discriminatorType = DiscriminatorType.STRING, length = 3 )
public class Taxe implements Serializable {
    @Id
    @GeneratedValue
    @Column( name = "REF_TAXE" )
    private Long       id;
    @NotNull
    @Size( min = 3, max = 35 )
    private String     titre;
    private Date       dateTaxe;
    private double     montant;
    @ManyToOne
    @JoinColumn( name = "REF_ENT" )
    private Entreprise entreprise;

    public Taxe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Taxe( String titre, Date dateTaxe, double montant, Entreprise entreprise ) {
        super();
        this.titre = titre;
        this.dateTaxe = dateTaxe;
        this.montant = montant;
        this.entreprise = entreprise;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public Date getDateTaxe() {
        return dateTaxe;
    }

    public void setDateTaxe( Date dateTaxe ) {
        this.dateTaxe = dateTaxe;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant( double montant ) {
        this.montant = montant;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise( Entreprise entreprise ) {
        this.entreprise = entreprise;
    }

}
