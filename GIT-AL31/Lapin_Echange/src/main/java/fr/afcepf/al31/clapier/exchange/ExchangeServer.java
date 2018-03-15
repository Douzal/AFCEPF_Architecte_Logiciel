package fr.afcepf.al31.clapier.exchange;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.api.IClapier;
import fr.afcepf.al31.clapier.api.ITunnel;

public class ExchangeServer {
	private static Logger log = Logger.getLogger(ExchangeServer.class);
	public ExchangeServer() {
		try {
			LocateRegistry.createRegistry(12346);
			IClapier clapier = new EchangeService();
			Naming.bind("rmi://" + InetAddress.getLocalHost().getHostAddress() + ":12346/clapier", clapier);
			log.info("exchange service lancé");
			
		} catch (Exception e) {
			log.fatal(e);
		}
	}
	public static void main(String[] args) {
		
	}
}
