
package fr.afcepf.ai102.monservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouter complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajouter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unEntier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unAutreEntier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouter", propOrder = {
    "unEntier",
    "unAutreEntier"
})
public class Ajouter {

    protected int unEntier;
    protected int unAutreEntier;

    /**
     * Obtient la valeur de la propri�t� unEntier.
     * 
     */
    public int getUnEntier() {
        return unEntier;
    }

    /**
     * D�finit la valeur de la propri�t� unEntier.
     * 
     */
    public void setUnEntier(int value) {
        this.unEntier = value;
    }

    /**
     * Obtient la valeur de la propri�t� unAutreEntier.
     * 
     */
    public int getUnAutreEntier() {
        return unAutreEntier;
    }

    /**
     * D�finit la valeur de la propri�t� unAutreEntier.
     * 
     */
    public void setUnAutreEntier(int value) {
        this.unAutreEntier = value;
    }

}
