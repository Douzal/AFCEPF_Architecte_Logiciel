
package fr.afcepf.ai102.service.impl;

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
 *         &lt;element name="paramA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="paramB" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "paramA",
    "paramB"
})
@XmlRootElement(name = "pow")
public class Pow {

    protected double paramA;
    protected double paramB;

    /**
     * Obtient la valeur de la propri�t� paramA.
     * 
     */
    public double getParamA() {
        return paramA;
    }

    /**
     * D�finit la valeur de la propri�t� paramA.
     * 
     */
    public void setParamA(double value) {
        this.paramA = value;
    }

    /**
     * Obtient la valeur de la propri�t� paramB.
     * 
     */
    public double getParamB() {
        return paramB;
    }

    /**
     * D�finit la valeur de la propri�t� paramB.
     * 
     */
    public void setParamB(double value) {
        this.paramB = value;
    }

}
