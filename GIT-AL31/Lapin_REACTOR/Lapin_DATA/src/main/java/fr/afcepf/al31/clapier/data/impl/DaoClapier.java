package fr.afcepf.al31.clapier.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import fr.afcepf.al31.clapier.data.api.IDaoClapier;
import fr.afcepf.al31.clapier.entity.Clapier;
import fr.afcepf.al31.clapier.entity.Lapin;
import fr.afcepf.al31.util.AL31DataSource;

public class DaoClapier implements IDaoClapier {
	private DataSource ds = new AL31DataSource();
	private static final String REQ_AJOUTER_LAPIN =
			"INSERT INTO affectation (lapin, clapier)"
					+" VALUES (?, ?)";
	private static final String REQ_ENLEVER_LAPIN =
			"DELETE FROM affectation WHERE lapin = ?";
	private static final String REQ_RECHERCHER_LAPIN =
			"SELECT l.id, nom, nboreille, couleur, naissance, sexe FROM lapin l "
			+ " inner join affectation a on a.lapin = l.id "
			+ " AND a.clapier = ?";
	private static final String REQ_GETALL_CLAPIER =
			"SELECT a.id, a.numero FROM clapier a";
	private Logger log = Logger.getLogger(getClass());
	@Override
	public boolean ajouter(Lapin lapin, Clapier clapier) {
		try (Connection cnx = ds.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(REQ_AJOUTER_LAPIN);
			pstmt.setInt(1, lapin.getId());
			pstmt.setInt(2, clapier.getId());
			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e);
		}
		return false;
	}

	@Override
	public boolean enlever(Lapin lapin) {
		try (Connection cnx = ds.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(REQ_ENLEVER_LAPIN);
			pstmt.setInt(1, lapin.getId());
			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
			log.fatal(e);
		}
		return false;
	}

	@Override
	public List<Lapin> getLapins(Clapier clapier) {
		List<Lapin> liste = new ArrayList<>();
		try (Connection cnx = ds.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(REQ_RECHERCHER_LAPIN);
			pstmt.setInt(1, clapier.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				liste.add(new Lapin(rs.getInt("id"),
						rs.getString("nom"),
						rs.getDouble("nbOreille"),
						rs.getString("couleur"),
						rs.getDate("naissance"),
						rs.getString("sexe")));
			}
		} catch (Exception e) {
			log.fatal(e);
		}
		return liste;
	}

	@Override
	public List<Clapier> getAll() {
		List<Clapier> liste = new ArrayList<>();
		try (Connection cnx = ds.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_GETALL_CLAPIER);
			while (rs.next()) {
				liste.add(new Clapier(rs.getInt("id"), rs.getInt("numero")));
			}
		} catch (Exception e) {
			log.fatal(e);
		}
		return liste;
	}

}
