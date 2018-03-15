package fr.afcepf.ai31.rappels.fichiers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

import org.apache.log4j.Logger;

public class TestFile {
    private TestFile() {
    }
    private static Logger log = Logger.getLogger(TestFile.class);
    
    public static void main(String[] args) {

        try {
            // avec un arobase pas besoin d'echaper les caracteres ! UNIQUEMENT en C#
            // on aurait pu ecrire 
            // @"C:\Users\formation\Desktop\toto.txt";
            String path = "C:/Users/formation/Desktop/toto.txt";
            File unFichier = new File(path);
            if(!unFichier.exists()) {
                unFichier.createNewFile();
            } else {
                unFichier.delete();
            }
            
            // creation des dossiers s'ils n'existent pas --> a, b, c, d, toto2.txt sont des fichiers
           String path2 = "C:/Users/formation/Desktop/a/b/c/d/toto2.txt";
           File unDeuxiemeFichier = new File(path2);
           if(!unDeuxiemeFichier.exists()) {
               unDeuxiemeFichier.mkdirs();
           }
            
           // creation des dossiers
           String path3 = "C:/Users/formation/Desktop/a/b/c/d/toto2.txt/file.al31";
           File unTroisiemeFichier = new File(path3);
           // creation du fichier file.al31
           unTroisiemeFichier.createNewFile();
           Thread.sleep(2000);
           // deplacement dans C:/Users/formation/Desktop/a/titi/file.al31
           String path4 = "C:/Users/formation/Desktop/a/titi/al31";
           File unAutreFichier = new File(path4);
           unTroisiemeFichier.renameTo(unAutreFichier);
           
           String path5 = Thread.currentThread()
                   .getContextClassLoader()
                   .getResource(".").getPath();
           path5 += "unFichier.al31";
           File fichierDansProgram = new File(path5);
           log.debug(path5);
           fichierDansProgram.createNewFile();
           // en reprenant le path en console on doit trouver un nouveau fichier
           
           // parcours des fichiers dans un dossier :
           String bureau = "C:/Users/formation/Desktop";
           File desktop = new File(bureau);
           if(desktop.isDirectory()) {
               File[] file = desktop.listFiles();
               for(File file2 : file) {
                   if(file2.isDirectory()) {
                       log.debug("Dossier : " + file2.getName());
                   } else {
                       log.debug("Fichier : " + file2.getName()
                       + ", " + file2.length());
                   }
               }
           }
           
        } catch (Exception e) {
            log.fatal(e);
        }
    }
}
