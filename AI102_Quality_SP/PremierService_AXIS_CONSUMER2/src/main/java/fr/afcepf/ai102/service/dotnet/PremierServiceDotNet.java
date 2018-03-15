
package fr.afcepf.ai102.service.dotnet;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PremierServiceDotNet", targetNamespace = "http://dotnet.service.ai102.afcepf.fr/", wsdlLocation = "http://localhost:54626/PremierServiceDotNet.asmx?WSDL")
public class PremierServiceDotNet
    extends Service
{

    private final static URL PREMIERSERVICEDOTNET_WSDL_LOCATION;
    private final static WebServiceException PREMIERSERVICEDOTNET_EXCEPTION;
    private final static QName PREMIERSERVICEDOTNET_QNAME = new QName("http://dotnet.service.ai102.afcepf.fr/", "PremierServiceDotNet");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:54626/PremierServiceDotNet.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PREMIERSERVICEDOTNET_WSDL_LOCATION = url;
        PREMIERSERVICEDOTNET_EXCEPTION = e;
    }

    public PremierServiceDotNet() {
        super(__getWsdlLocation(), PREMIERSERVICEDOTNET_QNAME);
    }

    public PremierServiceDotNet(WebServiceFeature... features) {
        super(__getWsdlLocation(), PREMIERSERVICEDOTNET_QNAME, features);
    }

    public PremierServiceDotNet(URL wsdlLocation) {
        super(wsdlLocation, PREMIERSERVICEDOTNET_QNAME);
    }

    public PremierServiceDotNet(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PREMIERSERVICEDOTNET_QNAME, features);
    }

    public PremierServiceDotNet(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PremierServiceDotNet(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PremierServiceDotNetSoap
     */
    @WebEndpoint(name = "PremierServiceDotNetSoap")
    public PremierServiceDotNetSoap getPremierServiceDotNetSoap() {
        return super.getPort(new QName("http://dotnet.service.ai102.afcepf.fr/", "PremierServiceDotNetSoap"), PremierServiceDotNetSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PremierServiceDotNetSoap
     */
    @WebEndpoint(name = "PremierServiceDotNetSoap")
    public PremierServiceDotNetSoap getPremierServiceDotNetSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://dotnet.service.ai102.afcepf.fr/", "PremierServiceDotNetSoap"), PremierServiceDotNetSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PREMIERSERVICEDOTNET_EXCEPTION!= null) {
            throw PREMIERSERVICEDOTNET_EXCEPTION;
        }
        return PREMIERSERVICEDOTNET_WSDL_LOCATION;
    }

}