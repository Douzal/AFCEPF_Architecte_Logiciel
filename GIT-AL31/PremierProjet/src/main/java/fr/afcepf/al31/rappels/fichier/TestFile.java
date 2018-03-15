package fr.afcepf.al31.rappels.fichier;

import java.io.File;

import org.apache.log4j.Logger;

public final class TestFile {
	private TestFile() {
	}
	private static Logger log = Logger.getLogger(TestFile.class);
	public static void main(String[] args) {
		try {
			String path = "c:/Users/formation/Desktop/toto.txt";
			File unFichier = new File(path);
			if (!unFichier.exists()) {
				unFichier.createNewFile();
			} else {
				unFichier.delete();
			}
			String path2 = "c:/Users/formation/Desktop/a/b/c/d/toto2.txt";
			File unDeuxiemeFichier = new File(path2);
			if (!unDeuxiemeFichier.exists()) {
				unDeuxiemeFichier.mkdirs();
			}
			String path3 = "c:/Users/formation/Desktop/a/b/c/d/toto2.txt/file.al31";
			File unTroisiemeFichier = new File(path3);
			// creation du fichier file.al31
			unTroisiemeFichier.createNewFile();
			Thread.sleep(2000);
			// deplacement dans c:/Users/formation/Desktop/a/titi.al31
			String path4 = "c:/Users/formation/Desktop/a/titi.al31";
			File unAutreFichier = new File(path4);
			unTroisiemeFichier.renameTo(unAutreFichier);
			
			String path5 = Thread.currentThread()
					.getContextClassLoader()
					.getResource(".").getPath();
			path5 += "unFichier.al31";
			File fichierDansProgram = new File(path5);
			log.debug(path5);
			fichierDansProgram.createNewFile();
			
			String bureau = "c:/Users/formation/Desktop";
			File desktop = new File(bureau);
			if (desktop.isDirectory()) {
				File[] file = desktop.listFiles();
				for (File file2 : file) {
					if (file2.isDirectory()) {
						log.debug("dossier : " + file2.getName());
					} else {
						log.debug("fichier : " + file2.getName()
						+ ", " + file2.length());
					}
				}
			}
		}catch (Exception e) {
			log.fatal(e);
		}
	}
}
