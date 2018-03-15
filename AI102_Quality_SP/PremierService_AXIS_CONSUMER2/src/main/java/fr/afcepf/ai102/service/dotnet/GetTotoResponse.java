
package fr.afcepf.ai102.service.dotnet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetTotoResult" type="{http://dotnet.service.ai102.afcepf.fr/}Toto" minOccurs="0"/>
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
    "getTotoResult"
})
@XmlRootElement(name = "GetTotoResponse")
public class GetTotoResponse {

    @XmlElement(name = "GetTotoResult")
    protected Toto getTotoResult;

    /**
     * Obtient la valeur de la propriété getTotoResult.
     * 
     * @return
     *     possible object is
     *     {@link Toto }
     *     
     */
    public Toto getGetTotoResult() {
        return getTotoResult;
    }

    /**
     * Définit la valeur de la propriété getTotoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Toto }
     *     
     */
    public void setGetTotoResult(Toto value) {
        this.getTotoResult = value;
    }

}
