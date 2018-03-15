
package fr.afcepf.ai102.monservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouterResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajouterResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultatAddition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouterResponse", propOrder = {
    "resultatAddition"
})
public class AjouterResponse {

    protected int resultatAddition;

    /**
     * Obtient la valeur de la propriété resultatAddition.
     * 
     */
    public int getResultatAddition() {
        return resultatAddition;
    }

    /**
     * Définit la valeur de la propriété resultatAddition.
     * 
     */
    public void setResultatAddition(int value) {
        this.resultatAddition = value;
    }

}
