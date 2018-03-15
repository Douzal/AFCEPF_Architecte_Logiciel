
package fr.afcepf.ai102.monservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getTotoResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getTotoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="leToto" type="{http://monservice.ai102.afcepf.fr}foo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTotoResponse", propOrder = {
    "leToto"
})
public class GetTotoResponse {

    protected Foo leToto;

    /**
     * Obtient la valeur de la propriété leToto.
     * 
     * @return
     *     possible object is
     *     {@link Foo }
     *     
     */
    public Foo getLeToto() {
        return leToto;
    }

    /**
     * Définit la valeur de la propriété leToto.
     * 
     * @param value
     *     allowed object is
     *     {@link Foo }
     *     
     */
    public void setLeToto(Foo value) {
        this.leToto = value;
    }

}
