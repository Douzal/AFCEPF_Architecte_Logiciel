using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Description résumée de PremierServiceDotNet
/// </summary>
[WebService(Namespace = "http://dotnet.service.ai102.afcepf.fr/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Pour autoriser l'appel de ce service Web depuis un script à l'aide d'ASP.NET AJAX, supprimez les marques de commentaire de la ligne suivante. 
// [System.Web.Script.Services.ScriptService]
public class PremierServiceDotNet : System.Web.Services.WebService
{
    public PremierServiceDotNet()
    {
    }
    [WebMethod]
    public string HelloWorld()
    {
        return "Hello World";
    }
    [WebMethod]
    public Int32 ajouter(Int32 i, Int32 j)
    {
        return i + j;
    }
    [WebMethod]
    public Double puissance(Double a, Double b)
    {
        return Math.Pow(a, b);
    }
    [WebMethod]
    public Toto GetToto()
    {
        Toto t = new Toto();
        t.Id = 5;
        t.Nom = "toto";
        t.Prenom = "titi";
        return t;
    }

}
public class Toto
{
    public int Id { get; set; }
    public string Nom { get; set; }
    public string Prenom { get; set; }
}
