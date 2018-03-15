package fr.afcepf.ai31.rappels.fichiers;

import java.io.FileWriter;

import org.apache.log4j.Logger;

public final class TestFileWriter {

    // constructeur prive ... ?!
    private TestFileWriter() {
    }

    private static Logger log = Logger.getLogger(TestFileWriter.class);

    public static void main(String[] args) {
        String fichier = "C:/Users/formation/Desktop/al31.al31";
        for (int i = 0; i < 100; i++) {
            // le fileWriter ecrit simplement en memoire, jusqu'au Close()
            // Il ecrit alors physiquement
            try (FileWriter fw = new FileWriter(fichier, true)) {
                fw.write("Texte");
                fw.write(System.lineSeparator());
                fw.write("Texte à la ligne");
            } catch (Exception e) {
                log.fatal(e);
            }
        }
    }

}
