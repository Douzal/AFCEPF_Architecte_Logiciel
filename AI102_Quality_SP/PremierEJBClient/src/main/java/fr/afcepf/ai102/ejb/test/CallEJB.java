package fr.afcepf.ai102.ejb.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.afcepf.ai102.ejb.api.ICalcul;
import fr.afcepf.ai102.ejb.api.ITestObjet;
import fr.afcepf.ai102.ejb.entity.Toto;

public class CallEJB {
    private static final String JNDI_NAME =
        "PremierEJB/Calcul!fr.afcepf.ai102.ejb.api.ICalcul";
    private static final String JNDI_NAME2 =
            "PremierEJB/TestObjet!fr.afcepf.ai102.ejb.api.ITestObjet";
    private static final String JNDI_PROVIDER =
        "http-remoting://127.0.0.1:18080";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "afcepf";
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(Context.PROVIDER_URL, JNDI_PROVIDER);
        props.put(Context.SECURITY_PRINCIPAL, USERNAME);
        props.put(Context.SECURITY_CREDENTIALS, PASSWORD);
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.URL_PKG_PREFIXES,
                "org.jboss.ejb.client.naming");
        props.put("jboss.naming.client.ejb.context", true);
        try {
            Context ctx = new InitialContext(props);
            ICalcul proxy = (ICalcul) ctx.lookup(JNDI_NAME);
            System.out.println(proxy.add(20, 22));
            System.out.println(proxy.pow(2, 11));
            ITestObjet proxy2 = (ITestObjet) ctx.lookup(JNDI_NAME2);
            Toto toto = proxy2.Toto(new Toto(1, "toto", "toto"));
            System.out.println(toto.getNom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
