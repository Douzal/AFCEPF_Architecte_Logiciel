
package fr.afcepf.ai102.monservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.ai102.monservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetToto_QNAME = new QName("http://monservice.ai102.afcepf.fr", "getToto");
    private final static QName _AjouterResponse_QNAME = new QName("http://monservice.ai102.afcepf.fr", "ajouterResponse");
    private final static QName _GetTotoResponse_QNAME = new QName("http://monservice.ai102.afcepf.fr", "getTotoResponse");
    private final static QName _Ajouter_QNAME = new QName("http://monservice.ai102.afcepf.fr", "ajouter");
    private final static QName _PuissanceResponse_QNAME = new QName("http://monservice.ai102.afcepf.fr", "puissanceResponse");
    private final static QName _Toto_QNAME = new QName("http://monservice.ai102.afcepf.fr", "Toto");
    private final static QName _Puissance_QNAME = new QName("http://monservice.ai102.afcepf.fr", "puissance");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.ai102.monservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PuissanceResponse }
     * 
     */
    public PuissanceResponse createPuissanceResponse() {
        return new PuissanceResponse();
    }

    /**
     * Create an instance of {@link Foo }
     * 
     */
    public Foo createFoo() {
        return new Foo();
    }

    /**
     * Create an instance of {@link GetTotoResponse }
     * 
     */
    public GetTotoResponse createGetTotoResponse() {
        return new GetTotoResponse();
    }

    /**
     * Create an instance of {@link Ajouter }
     * 
     */
    public Ajouter createAjouter() {
        return new Ajouter();
    }

    /**
     * Create an instance of {@link Puissance }
     * 
     */
    public Puissance createPuissance() {
        return new Puissance();
    }

    /**
     * Create an instance of {@link GetToto }
     * 
     */
    public GetToto createGetToto() {
        return new GetToto();
    }

    /**
     * Create an instance of {@link AjouterResponse }
     * 
     */
    public AjouterResponse createAjouterResponse() {
        return new AjouterResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetToto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "getToto")
    public JAXBElement<GetToto> createGetToto(GetToto value) {
        return new JAXBElement<GetToto>(_GetToto_QNAME, GetToto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "ajouterResponse")
    public JAXBElement<AjouterResponse> createAjouterResponse(AjouterResponse value) {
        return new JAXBElement<AjouterResponse>(_AjouterResponse_QNAME, AjouterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "getTotoResponse")
    public JAXBElement<GetTotoResponse> createGetTotoResponse(GetTotoResponse value) {
        return new JAXBElement<GetTotoResponse>(_GetTotoResponse_QNAME, GetTotoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ajouter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "ajouter")
    public JAXBElement<Ajouter> createAjouter(Ajouter value) {
        return new JAXBElement<Ajouter>(_Ajouter_QNAME, Ajouter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PuissanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "puissanceResponse")
    public JAXBElement<PuissanceResponse> createPuissanceResponse(PuissanceResponse value) {
        return new JAXBElement<PuissanceResponse>(_PuissanceResponse_QNAME, PuissanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Foo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "Toto")
    public JAXBElement<Foo> createToto(Foo value) {
        return new JAXBElement<Foo>(_Toto_QNAME, Foo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Puissance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monservice.ai102.afcepf.fr", name = "puissance")
    public JAXBElement<Puissance> createPuissance(Puissance value) {
        return new JAXBElement<Puissance>(_Puissance_QNAME, Puissance.class, null, value);
    }

}
