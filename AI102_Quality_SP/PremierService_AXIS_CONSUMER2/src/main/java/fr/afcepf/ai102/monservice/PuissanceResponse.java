
package fr.afcepf.ai102.monservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour puissanceResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="puissanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultatPuissance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puissanceResponse", propOrder = {
    "resultatPuissance"
})
public class PuissanceResponse {

    protected double resultatPuissance;

    /**
     * Obtient la valeur de la propriété resultatPuissance.
     * 
     */
    public double getResultatPuissance() {
        return resultatPuissance;
    }

    /**
     * Définit la valeur de la propriété resultatPuissance.
     * 
     */
    public void setResultatPuissance(double value) {
        this.resultatPuissance = value;
    }

}
