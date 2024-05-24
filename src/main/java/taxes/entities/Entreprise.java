package taxes.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "ENTREPRISES" )
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue
    @Column( name = "REF_ENT" )
    private Long             code;
    @NotNull
    @Size( min = 2, max = 25 )
    private String           nom;
    @NotNull
    @Size( min = 2, max = 100 )

    private String           email;
    @Column( name = "PRESENTATION" )
    @NotNull
    @Size( min = 4, max = 1500 )
    private String           description;
    @OneToMany( mappedBy = "entreprise", fetch = FetchType.LAZY )
    private Collection<Taxe> taxes;

    public Entreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Entreprise( String nom, String email, String description ) {
        super();
        this.nom = nom;
        this.email = email;
        this.description = description;
    }

    public Long getCode() {
        return code;
    }

    public void setCode( Long code ) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @JsonIgnore
    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes( Collection<Taxe> taxes ) {
        this.taxes = taxes;
    }

}
