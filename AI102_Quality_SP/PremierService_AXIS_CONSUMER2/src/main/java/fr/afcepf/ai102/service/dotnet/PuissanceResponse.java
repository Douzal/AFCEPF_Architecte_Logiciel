
package fr.afcepf.ai102.service.dotnet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="puissanceResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "puissanceResult"
})
@XmlRootElement(name = "puissanceResponse")
public class PuissanceResponse {

    protected double puissanceResult;

    /**
     * Obtient la valeur de la propri�t� puissanceResult.
     * 
     */
    public double getPuissanceResult() {
        return puissanceResult;
    }

    /**
     * D�finit la valeur de la propri�t� puissanceResult.
     * 
     */
    public void setPuissanceResult(double value) {
        this.puissanceResult = value;
    }

}
