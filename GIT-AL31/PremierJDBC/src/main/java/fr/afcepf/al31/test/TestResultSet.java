package fr.afcepf.al31.test;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public final class TestResultSet {
	private TestResultSet() {
	}
	private static Logger log = Logger.getLogger(TestResultSet.class);
	public static void main(String[] args) {
		try (Connection cnx = new AL31DataSource().getConnection()) {
			ResultSet rs = cnx.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM lapin");
			StringBuilder sb = new StringBuilder(System.lineSeparator());
			while (rs.next()) {
				sb.append("id: ").append(rs.getInt("id"))
				  .append("\tnom: ").append(rs.getString("nom"))
				  .append("\tcouleur: ").append(rs.getString("couleur"))
				  .append("\tnboreille: ").append(rs.getDouble("nboreille"))
				  .append("\tnaissance: ").append(rs.getDate("naissance"))
				  .append("\tsexe: ").append(rs.getString("sexe"))
				  .append(System.lineSeparator());
				rs.updateString("couleur", "Blanc");
				rs.updateRow();
			}
			log.debug(sb);
			rs.absolute(2);
			rs.updateString("nom", "PanPan");
			rs.updateRow();
			sb.setLength(0);
			sb.append("id: ").append(rs.getInt("id"))
			  .append("\tnom: ").append(rs.getString("nom"))
			  .append("\tcouleur: ").append(rs.getString("couleur"))
			  .append("\tnboreille: ").append(rs.getDouble("nboreille"))
			  .append("\tnaissance: ").append(rs.getDate("naissance"))
			  .append("\tsexe: ").append(rs.getString("sexe"))
			  .append(System.lineSeparator());
			log.debug(sb);
			rs.absolute(3);
			rs.deleteRow();
			// ajout : 
			rs.moveToInsertRow();
			rs.updateString("nom", "Nouveau");
			rs.updateString("couleur", "gris");
			rs.updateDouble("nboreille", 3.25);
			rs.updateDate("naissance", new java.sql.Date(new java.util.Date().getTime()));
			rs.updateString("sexe", "H");
			rs.insertRow();
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
