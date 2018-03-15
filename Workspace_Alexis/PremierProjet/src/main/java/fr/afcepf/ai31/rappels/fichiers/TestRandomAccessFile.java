package fr.afcepf.ai31.rappels.fichiers;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

import org.apache.log4j.Logger;

public class TestRandomAccessFile {
        
    private TestRandomAccessFile() {
    }
    private static Logger log = Logger.getLogger(TestFileWriter.class);
    public static void main(String[] args) {
        // le file writer ecrit sur 1 octet
        try {
            RandomAccessFile raf = new RandomAccessFile("c://users/formation/desktop/raf.al31", "rw");
            int[] tab = {1522545, 126545,522,1,888,546,564};
            for (int i : tab) {
                raf.writeInt(i);
            }
        } catch (Exception e) {
            log.fatal(e);
        }
        
        // un caractere sur un fichier brut, est sur un octet
        
        try {
            // droit d'ecriture seul
            RandomAccessFile raf = new RandomAccessFile("c://users/formation/desktop/raf.al31", "r");
            int position = 8;
            raf.seek(position);
            int troisieme = raf.readInt();
            log.debug(troisieme);
        } catch (Exception e) {
            log.fatal(e);
        }

        // exercice lire le lapin
        
        try {
            // droit d'ecriture seul
            RandomAccessFile raf = new RandomAccessFile("c://users/formation/desktop/raf.al31", "r");
            int position = 8;
            raf.seek(position);
            int troisieme = raf.readInt();
            log.debug(troisieme);
        } catch (Exception e) {
            log.fatal(e);
        }
    }

}
