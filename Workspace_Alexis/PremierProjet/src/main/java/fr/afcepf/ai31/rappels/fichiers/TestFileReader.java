package fr.afcepf.ai31.rappels.fichiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.log4j.Logger;

public class TestFileReader {
    private TestFileReader() {
    }
    
    private static Logger log = Logger.getLogger(TestFileReader.class);
    public static void main(String[] args) {
        String path = "C:/Users/Formation/Desktop/a/titi.al31";
        // try with resources appelle close de type IO automatiquement
        
        try (FileReader fr = new FileReader(path)) {
            int caractere = 0;
            StringBuilder sb = new StringBuilder();
            // - 1 : fin du fichier
            while((caractere = fr.read()) != -1) {
                sb.append((char) caractere);
            }
            log.debug(sb);
        } catch (Exception e) {
            log.fatal(e);;
        }
        
        
        // lecture par caractere
        File fichier = new File(path);
        try (FileReader fr = new FileReader(fichier)) {
            int caractere = 0;
            char[] donnees = new char[(int) fichier.length()];
            fr.read(donnees);
            for (char c : donnees) {
                log.debug(c);
            }
        } catch (Exception e) {
            log.fatal(e);;
        }
        
        // lecture par ligne
        try ( BufferedReader br  =  new BufferedReader(new FileReader(fichier))) {
            String ligne = "";
            StringBuilder sb = new StringBuilder(System.lineSeparator());
            // parcours : 
            while ((ligne = br.readLine()) != null) {
                sb.append(ligne).append(System.lineSeparator());
            }
            log.debug(sb);
        } catch (Exception e) {
            log.fatal(e);;
        }
        
    }

}
