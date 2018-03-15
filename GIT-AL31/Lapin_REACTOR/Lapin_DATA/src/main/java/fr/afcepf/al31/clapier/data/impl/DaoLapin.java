package fr.afcepf.al31.clapier.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.data.api.IDaoLapin;
import fr.afcepf.al31.clapier.entity.Lapin;
import fr.afcepf.al31.util.AL31DataSource;

public class DaoLapin implements IDaoLapin {
	private DataSource ds = new AL31DataSource();
	private static final String REQ_AJOUTER_LAPIN =
			"INSERT INTO lapin (nom, couleur, nboreille, naissance, sexe)"
			+" VALUES (?, ?, ?, ?, ?)";
	private static final String REQ_SUPPRIMER_LAPIN =
			"DELETE FROM lapin WHERE id = ?";
	private Logger log = Logger.getLogger(getClass());
	@Override
	public Lapin ajouter(Lapin lapin) {
		log.debug("ajout d'un lapin");
		try (Connection cnx = ds.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(
					REQ_AJOUTER_LAPIN, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, lapin.getNom());
			pstmt.setString(2, lapin.getCouleur());
			pstmt.setDouble(3, lapin.getNbOreille());
			pstmt.setDate(4, new java.sql.Date(lapin.getNaissance().getTime()));
			pstmt.setString(5, lapin.getSexe());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			lapin.setId(rs.getInt(1));
		} catch (Exception e) {
			log.fatal(e);
		}
		return lapin;
	}

	@Override
	public boolean supprimer(Lapin lapin) {
		log.debug("suppression d'un lapin");
		try (Connection cnx = ds.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(REQ_SUPPRIMER_LAPIN);
			pstmt.setInt(1, lapin.getId());
			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
			log.fatal(e);
			return false;
		}
	}

}
