package fr.afcepf.al31.clapier.impl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.api.ITunnel;

public final class TunnelServer {
	private TunnelServer() {
	}
	private static Logger log = Logger.getLogger(TunnelServer.class);
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(12345);
			ITunnel tunnel = new Tunnel();
			Naming.bind("rmi://192.168.102.185:12345/tunnel", tunnel);
			log.info("tunnel ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
