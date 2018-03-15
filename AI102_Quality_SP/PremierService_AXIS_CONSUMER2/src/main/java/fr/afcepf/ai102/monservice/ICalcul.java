
package fr.afcepf.ai102.monservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICalcul", targetNamespace = "http://monservice.ai102.afcepf.fr")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICalcul {


    /**
     * 
     * @param unAutreEntier
     * @param unEntier
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "resultatAddition", targetNamespace = "")
    @RequestWrapper(localName = "ajouter", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.Ajouter")
    @ResponseWrapper(localName = "ajouterResponse", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.AjouterResponse")
    public int ajouter(
        @WebParam(name = "unEntier", targetNamespace = "")
        int unEntier,
        @WebParam(name = "unAutreEntier", targetNamespace = "")
        int unAutreEntier);

    /**
     * 
     * @return
     *     returns fr.afcepf.ai102.monservice.Foo
     */
    @WebMethod
    @WebResult(name = "leToto", targetNamespace = "")
    @RequestWrapper(localName = "getToto", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.GetToto")
    @ResponseWrapper(localName = "getTotoResponse", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.GetTotoResponse")
    public Foo getToto();

    /**
     * 
     * @param unAutreDouble
     * @param unDouble
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(name = "resultatPuissance", targetNamespace = "")
    @RequestWrapper(localName = "puissance", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.Puissance")
    @ResponseWrapper(localName = "puissanceResponse", targetNamespace = "http://monservice.ai102.afcepf.fr", className = "fr.afcepf.ai102.monservice.PuissanceResponse")
    public double puissance(
        @WebParam(name = "unDouble", targetNamespace = "")
        double unDouble,
        @WebParam(name = "unAutreDouble", targetNamespace = "")
        double unAutreDouble);

}
