
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
 *         &lt;element name="ajouterResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "ajouterResult"
})
@XmlRootElement(name = "ajouterResponse")
public class AjouterResponse {

    protected int ajouterResult;

    /**
     * Obtient la valeur de la propri�t� ajouterResult.
     * 
     */
    public int getAjouterResult() {
        return ajouterResult;
    }

    /**
     * D�finit la valeur de la propri�t� ajouterResult.
     * 
     */
    public void setAjouterResult(int value) {
        this.ajouterResult = value;
    }

}
