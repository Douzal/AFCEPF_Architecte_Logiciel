package fr.afcepf.al31.rappels.fichier;

import java.io.RandomAccessFile;

import org.apache.log4j.Logger;

public final class TestRandomAccessFile {
	private TestRandomAccessFile() {
	}
	private static Logger log = Logger.getLogger(TestRandomAccessFile.class);
	public static void main(String[] args) {
		try (RandomAccessFile raf = new RandomAccessFile("c:/users/formation/Desktop/raf.al31", "rw")) {
			int[] tab = {12550005, 126562, 12, 126559, 956569, 56565};
			for (int i : tab) {
				raf.writeInt(i);
			}
		} catch (Exception e) {
			log.fatal(e);
		}
		try (RandomAccessFile raf = new RandomAccessFile("c:/users/formation/Desktop/raf.al31", "r")) {
			long position = 8;
			raf.seek(position);
			int troisieme = raf.readInt();
			log.debug(troisieme);
		} catch (Exception e) {
			log.fatal(e);
		}
		// lecture de lapin
		try (RandomAccessFile raf = new RandomAccessFile("c:/users/formation/Desktop/a/titi.al31", "r")) {
			StringBuilder lapin = new StringBuilder(System.lineSeparator());
			// lapin : StringBuilder
			// POUR un entier i allant de 0 à la taille du fichier FAIRE :
			// 		LIRE 1 octet -> octet
			//		TRANSFORMER octet en caractere -> caractere
			//		AJOUTER caractere au lapin
			// FIN POUR
			// AFFICHER lapin
			for (int i = 0 ; i < raf.length() ; i++) {
				lapin.append((char)raf.readByte());
			}
			log.debug(lapin);
		} catch (Exception e) {
			log.fatal(e);
		}
	}
}
