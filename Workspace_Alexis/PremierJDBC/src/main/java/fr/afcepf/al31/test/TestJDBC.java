package fr.afcepf.al31.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public class TestJDBC {
    private TestJDBC() {
    }

    private static Logger log = Logger.getLogger(TestJDBC.class);

    public static void main(String[] args) {
        log.info(" -- test d'ajout d'un lapinou à l'ASFH -- ");

        // insersion d'un lapin en base
        try (Connection cnx = new AL31DataSource().getConnection()) {
            String sqlMaria = "INSERT INTO `lapin` (`nom`, `couleur`, `nboreille`, `naissance`, `sexe`) "
                    + " VALUES ('Danidan', 'Rouge', 6, '1989-03-02', 'F')";
            Statement stmt = cnx.createStatement();
            // recuperer l'ID aussi avec le deuxieme param
            int nbLigne = stmt.executeUpdate(sqlMaria, Statement.RETURN_GENERATED_KEYS);
            log.debug("Nombre de lapins inséré(s) : " + nbLigne);

            ResultSet rsKey = stmt.getGeneratedKeys();
            rsKey.next();
            log.debug("Son identifiant est : " + rsKey.getInt(1));
            
            log.debug("Voci tous les lapinous : ");
            ResultSet rs = stmt.executeQuery(
                    "SELECT `id`, `nom`, `couleur`, `nboreille`, `naissance`, `sexe` FROM lapin");
            
            StringBuilder sb = new StringBuilder();
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
        } catch (Exception e) {
            log.fatal(e);
        }
    }
}
