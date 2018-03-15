
package fr.afcepf.ai102.service.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="powReturn" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "powReturn"
})
@XmlRootElement(name = "powResponse")
public class PowResponse {

    protected double powReturn;

    /**
     * Obtient la valeur de la propriété powReturn.
     * 
     */
    public double getPowReturn() {
        return powReturn;
    }

    /**
     * Définit la valeur de la propriété powReturn.
     * 
     */
    public void setPowReturn(double value) {
        this.powReturn = value;
    }

}
