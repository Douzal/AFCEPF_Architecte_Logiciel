package fr.afcepf.al31.test;


import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public class TestPreparedStatement {
    private TestPreparedStatement() {
    }

    private static Logger log = Logger.getLogger(TestJDBC.class);
    public static void main(String[] args) {
        String nom = "Pan";
        String couleur = "bleu";
//        String sexe = "F";
        String sexe = "F' );TRUNCATE TABLE lapin;"
                + "";
        double nboreille = 12.56;
        Date naissance = new Date();

        // MM en majuscule dans le format, sinon ce sont des minutes !
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // INTERDIT - JAMAIS faire ça -- INJECTION SQL
        // Pas de concat, les preparedStatement gere tous les caracteres speciaux
        StringBuilder sb = new StringBuilder()
                .append("INSERT INTO lapin (`nom`, `couleur`, `nboreille`, `naissance`, `sexe`)")
                .append("'").append(nom).append(",")
                .append("'").append(couleur).append(",")
                .append("'").append(sexe).append(",")
                .append("'").append(nboreille).append(",")
                .append("'").append(naissance).append(",");
        
        try (Connection cnx = new AL31DataSource().getConnection()) {
            int nbLigne = cnx.createStatement().executeUpdate(sb.toString());
        } catch (Exception e) {
            log.debug(e);;
        } 
        
    }

}
