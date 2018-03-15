package fr.afcepf.ai102.service.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.afcepf.ai102.service.entity.Foo;

@WebService(targetNamespace = "http://monservice.ai102.afcepf.fr")
public interface ICalcul {
    @WebMethod(operationName = "ajouter")
    @WebResult(name = "resultatAddition")
    int add(@WebParam(name = "unEntier") int i,
            @WebParam(name = "unAutreEntier") int j);
    @WebMethod(operationName = "puissance")
    @WebResult(name = "resultatPuissance")
    double pow(@WebParam(name = "unDouble") double a,
               @WebParam(name = "unAutreDouble")  double b);
    @WebMethod(operationName = "getToto")
    @WebResult(name = "leToto")
    Foo getFoo();
}
