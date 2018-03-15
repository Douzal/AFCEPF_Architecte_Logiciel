
package fr.afcepf.ai102.monservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour puissance complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="puissance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unDouble" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="unAutreDouble" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puissance", propOrder = {
    "unDouble",
    "unAutreDouble"
})
public class Puissance {

    protected double unDouble;
    protected double unAutreDouble;

    /**
     * Obtient la valeur de la propri�t� unDouble.
     * 
     */
    public double getUnDouble() {
        return unDouble;
    }

    /**
     * D�finit la valeur de la propri�t� unDouble.
     * 
     */
    public void setUnDouble(double value) {
        this.unDouble = value;
    }

    /**
     * Obtient la valeur de la propri�t� unAutreDouble.
     * 
     */
    public double getUnAutreDouble() {
        return unAutreDouble;
    }

    /**
     * D�finit la valeur de la propri�t� unAutreDouble.
     * 
     */
    public void setUnAutreDouble(double value) {
        this.unAutreDouble = value;
    }

}
