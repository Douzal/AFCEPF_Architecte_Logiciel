package fr.afcepf.al31.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public class TestResultSet {
    private TestResultSet() {
    }
    
    private static Logger log = Logger.getLogger(TestResultSet.class);
    
    public static void main(String[] args) {
        
        try (Connection cnx = new AL31DataSource().getConnection()) {
            ResultSet rs = cnx.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)
                    .executeQuery("SELECT * FROM lapin");
            
            
            StringBuilder sb = new StringBuilder(System.lineSeparator());
            while (rs.next()) {
                sb.append("id : ").append(rs.getInt("id"))
                .append("\tnom : ").append(rs.getString("nom"))
                .append("\tcouleur : ").append(rs.getString("couleur"))
                .append("\tnboreille : ").append(rs.getDouble("nboreille"))
                .append("\tnaissance : ").append(rs.getDate("naissance"))
                .append("\tsexe : ").append(rs.getString("sexe"))
                .append(System.lineSeparator());
            }
            log.debug("-----------------------------");
            log.debug(sb);
            
            
            rs.absolute(2); // position sur le deuxieme lapin
            rs.updateString("nom", "BOUMBOUM"); // on change la valeur colonne nom
            rs.updateRow(); // il execute la requete update
            sb.setLength(0);
            sb.append("id : ").append(rs.getInt("id"))
            .append("\tnom : ").append(rs.getString("nom"))
            .append("\tcouleur : ").append(rs.getString("couleur"))
            .append("\tnboreille : ").append(rs.getDouble("nboreille"))
            .append("\tnaissance : ").append(rs.getDate("naissance"))
            .append("\tsexe : ").append(rs.getString("sexe"))
            .append(System.lineSeparator());
            log.debug(sb);
            
            
            rs.absolute(5);
            rs.deleteRow();
            // ajout :
            rs.moveToInsertRow();
            rs.updateString("Nom", "Nouveau Lapinou !");
            rs.updateString("couleur", "Grand");
            rs.updateDouble("nboreille", 78);
            rs.updateDate("naissance", new java.sql.Date(new Date().getTime()));
            rs.updateString("sexe", "H");
            rs.insertRow();
            
            
        } catch (Exception e) {
            log.debug(e);;
        }
    }
}
