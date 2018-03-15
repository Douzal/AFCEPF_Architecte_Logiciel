package fr.afcepf.al31.clapier.test;

import java.rmi.Naming;
import java.util.Date;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.api.ITunnel;
import fr.afcepf.al31.clapier.entity.Lapin;

public final class CallTunnel {
	private CallTunnel() {
	}
	private static Logger log = Logger.getLogger(CallTunnel.class);
	
	public static void main(String[] args) {
		try {
			log.debug("appel du tunnel");
			ITunnel tunnelProxy = (ITunnel) Naming.lookup(
					"rmi://192.168.102.185:12345/tunnel");
			tunnelProxy.seConnecterAuTunnel();
			tunnelProxy.envoyerDansLeTunnel(new Lapin(null, "nom", 2.3, "vert", new Date(), "M"));
			tunnelProxy.seDeconnecterDuTunnel();
		} catch (Exception e) {
			log.fatal(e);
		}
	}
}
