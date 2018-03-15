using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsumerService
{
    class Program
    {
        [STAThread]
        static void Main(string[] args)
        {
            fr.afcepf.ai102.service.dotnet.PremierServiceDotNetSoap proxy =
                new fr.afcepf.ai102.service.dotnet.PremierServiceDotNetSoapClient();
            Console.WriteLine(proxy.ajouter(10, 32));
            Console.WriteLine(proxy.puissance(2, 11));
            fr.afcepf.ai102.service.dotnet.GetTotoRequest request =
                new fr.afcepf.ai102.service.dotnet.GetTotoRequest();
            fr.afcepf.ai102.service.dotnet.GetTotoResponse response =
                proxy.GetToto(request);
            fr.afcepf.ai102.service.dotnet.Toto leToto = response.Body.GetTotoResult;
            Console.WriteLine(leToto.Nom);

            fr.afcepf.ai102.service.java.ICalcul proxyJava =
                new fr.afcepf.ai102.service.java.CalculClient();
            fr.afcepf.ai102.service.java.ajouter requestAdd =
                new fr.afcepf.ai102.service.java.ajouter();
            requestAdd.unEntier = 10;
            requestAdd.unAutreEntier = 32;
            Console.WriteLine(proxyJava.ajouter(requestAdd).resultatAddition);
            fr.afcepf.ai102.service.java.getToto requestFoo =
                new fr.afcepf.ai102.service.java.getToto();
            fr.afcepf.ai102.service.java.foo leTotoJava =
                proxyJava.getToto(requestFoo).leToto;
            Console.WriteLine(leTotoJava.nom);

            Console.ReadLine();
        }
    }
}
