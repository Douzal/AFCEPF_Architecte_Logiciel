package fr.afcepf.al31.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public final class TestJDBC {
	private TestJDBC() {
	}
	private static Logger log = Logger.getLogger(TestJDBC.class);
	public static void main(String[] args) {
		log.info(" -- test d'ajout d'un lapin --");
		try (Connection cnx = new AL31DataSource().getConnection()) {
			String sqlMaria = "INSERT INTO `lapin` (`nom`, `couleur`, `nboreille`, `naissance`, `sexe`) "
					+ " VALUES ('Lapin','noir',1.5 ,'2018-03-02', 'F')";
			Statement stmt = cnx.createStatement();
			int nbLigne = stmt.executeUpdate(sqlMaria, Statement.RETURN_GENERATED_KEYS);
			log.debug("nb de lapin inseré(s): " + nbLigne);
			ResultSet rsKey = stmt.getGeneratedKeys();
			rsKey.next();
			log.debug("son identifiant est: " + rsKey.getInt(1));
			log.debug("voici tous les lapins : ");
			ResultSet rs = stmt.executeQuery(
					"SELECT id, nom, couleur, nboreille, naissance, sexe FROM lapin");
			StringBuilder sb = new StringBuilder(System.lineSeparator());
			while (rs.next()) {
				sb.append("id: ").append(rs.getInt("id"))
				  .append("\tnom: ").append(rs.getString("nom"))
				  .append("\tcouleur: ").append(rs.getString("couleur"))
				  .append("\tnboreille: ").append(rs.getDouble("nboreille"))
				  .append("\tnaissance: ").append(rs.getDate("naissance"))
				  .append("\tsexe: ").append(rs.getString("sexe"))
				  .append(System.lineSeparator());
			}
			log.debug(sb);
		} catch (Exception e) {
			log.fatal(e);
		}
	}
}
