package fr.afcepf.al31.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import fr.afcepf.al31.util.AL31DataSource;

public final class TestPreparedStatement {
	private TestPreparedStatement() {
	}
	private static Logger log = Logger.getLogger(TestPreparedStatement.class);
	public static void main(String[] args) {
		String nom = "Pan";
		String couleur = "bleu";
		String sexe = "H');TRUNCATE TABLE lapin #";
		double oreille = 12.36;
		Date naissance = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// INTERDIT ---- JAMAIS ÇA ----- INJECTION SQL
		StringBuilder sb = new StringBuilder()
				.append("INSERT INTO lapin (nom, couleur, nboreille, naissance, sexe)")
				.append(" VALUES ('").append(nom).append("',") 
					    .append("'").append(couleur).append("',") 
					    .append("'").append(oreille).append("',") 
					    .append("'").append(sdf.format(naissance)).append("',") 
					    .append("'").append(sexe).append("')");
		try (Connection cnx = new AL31DataSource().getConnection()) {
			log.debug(sb);
			//int nbLigne = cnx.createStatement().executeUpdate(sb.toString());
			//log.debug(nbLigne);
			sb = new StringBuilder()
					.append("INSERT INTO lapin (nom, couleur, nboreille, naissance, sexe)")
					.append(" VALUES (?, ?, ?, ?, ?)");
			PreparedStatement pstmt = cnx.prepareStatement(sb.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, nom);
			pstmt.setString(2, couleur);
			pstmt.setDouble(3, oreille);
			pstmt.setDate(4, new java.sql.Date(naissance.getTime()));
			pstmt.setString(5, "H");
			pstmt.executeUpdate();
			ResultSet rsKey = pstmt.getGeneratedKeys();
			rsKey.next();
			log.debug("id : " + rsKey.getInt(1));
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
