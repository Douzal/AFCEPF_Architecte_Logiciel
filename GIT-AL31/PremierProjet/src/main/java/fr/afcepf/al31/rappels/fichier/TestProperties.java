package fr.afcepf.al31.rappels.fichier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public final class TestProperties {
	private TestProperties() {
	}
	private static Logger log = Logger.getLogger(TestProperties.class);
	public static void main(String[] args) {
		Properties props = new Properties();
		String pathToProperties = Thread.currentThread()
				.getContextClassLoader().getResource("test.properties")
				.getPath();
		try {
			props.load(new FileInputStream(pathToProperties));
			log.debug(props.getProperty("al31"));
			log.debug(props.getProperty("test"));
			log.debug(props.getProperty("unechaine"));
		} catch (Exception e) {
			log.fatal(e);
		}
		try (OutputStream out = new FileOutputStream(pathToProperties)) {
			props.setProperty("nouvelle", "value");
			props.setProperty("toto", "dhasgdi hazoidj azlaz ue");
			props.setProperty("test", "()()");
			props.setProperty("titi", "(^^)");
			props.setProperty("tata", "(_()()");
			props.setProperty("al31", "Love C#");
			props.store(out, "un commentaire");
		} catch (Exception e) {
			log.fatal(e);
		}
		// lecture seule :
		ResourceBundle rb = ResourceBundle.getBundle("test");
		log.debug(rb.getString("al31"));
		Enumeration<String> cles = rb.getKeys();
		while(cles.hasMoreElements()) {
			log.debug(cles.nextElement());
		}
	}
}
