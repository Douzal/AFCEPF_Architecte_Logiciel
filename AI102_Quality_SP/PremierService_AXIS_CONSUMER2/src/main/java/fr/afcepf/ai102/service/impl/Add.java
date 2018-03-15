
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
 *         &lt;element name="paramI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paramJ" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "paramI",
    "paramJ"
})
@XmlRootElement(name = "add")
public class Add {

    protected int paramI;
    protected int paramJ;

    /**
     * Obtient la valeur de la propriété paramI.
     * 
     */
    public int getParamI() {
        return paramI;
    }

    /**
     * Définit la valeur de la propriété paramI.
     * 
     */
    public void setParamI(int value) {
        this.paramI = value;
    }

    /**
     * Obtient la valeur de la propriété paramJ.
     * 
     */
    public int getParamJ() {
        return paramJ;
    }

    /**
     * Définit la valeur de la propriété paramJ.
     * 
     */
    public void setParamJ(int value) {
        this.paramJ = value;
    }

}
