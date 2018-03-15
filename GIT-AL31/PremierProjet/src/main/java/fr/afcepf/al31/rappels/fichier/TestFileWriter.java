package fr.afcepf.al31.rappels.fichier;

import java.io.FileWriter;

import org.apache.log4j.Logger;

public final class TestFileWriter {
	private TestFileWriter() {
	}
	private static Logger log = Logger.getLogger(TestFileWriter.class);
	public static void main(String[] args) {
		String fichier = "c:/users/formation/Desktop/al31.al31";
		for(int i = 0 ; i < 100 ; i++) {
			try (FileWriter fw = new FileWriter(fichier, true)){
				fw.write("()()");
				fw.write(System.lineSeparator());
				fw.write("(^^) Love Java !!!");
				fw.write(System.lineSeparator());
				fw.write("(_()()");
				fw.write(System.lineSeparator());
			} catch (Exception e) {
				log.fatal(e);
			}
		}
	}
}
