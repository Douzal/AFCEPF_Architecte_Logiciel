package fr.afcepf.squad.gestion.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import fr.afcepf.squad.entity.Confrontation;
import fr.afcepf.squad.entity.Equipe;
import fr.afcepf.squad.entity.Evenement;
import fr.afcepf.squad.entity.Membre;
import fr.afcepf.squad.entity.Message;
import fr.afcepf.squad.entity.MessageRencontre;
import fr.afcepf.squad.entity.Participation;
import fr.afcepf.squad.entity.ResultatConfrontation;
import fr.afcepf.squad.gestion.api.IBusinessEvenement;
import fr.afecpf.squad.data.api.IDaoConfrontation;
import fr.afecpf.squad.data.api.IDaoEquipe;
import fr.afecpf.squad.data.api.IDaoEvenement;
import fr.afecpf.squad.data.api.IDaoMessage;
import fr.afecpf.squad.data.api.IDaoParticipation;
import fr.afecpf.squad.data.api.IDaoResultatsConfrontation;
@Remote(IBusinessEvenement.class)
@Singleton
public class BusinessEvenement implements IBusinessEvenement {

	@EJB
	private IDaoEvenement proxyEvenement;


	@EJB
	private IDaoConfrontation proxyConfrontation;

	@EJB
	private IDaoEquipe proxyEquipe;

	@EJB
	private IDaoResultatsConfrontation proxyResultatConfrontation;

	@EJB
	private IDaoParticipation proxyParticipation;
	
	@EJB
	private IDaoMessage proxyMessage;


	@Override
	public Evenement creation(Evenement paramEvenement) {
		paramEvenement.setDateCreation(new Date());
		return proxyEvenement.creer(paramEvenement);
	}
	@Override
	public Evenement getEvenementFullPackById(Integer id) {
		return proxyEvenement.getEvenementFullPackById(id);
	}
	@Override
	public Equipe updateMembreEquipe(Equipe equipe) {
		return proxyEvenement.updateMembreEquipe(equipe);
	}
	@Override
	public Evenement supprimerRencontre(Evenement evenement, Equipe equipe) {
		return proxyEvenement.supprimerEquipe(evenement, equipe);
	}
	@Override
	public Evenement refreshInstance(Evenement evenement) {
		return proxyEvenement.refreshInstance(evenement);
	}
	@Override
	public Evenement genererConfrontation(Evenement evenement) {

		Equipe equipe = null;

		if ((evenement.getEquipes().size() % 2) != 0) {
			equipe = new Equipe();
			equipe.setNom("fake");
			evenement.getEquipes().add(equipe);
		}

		int idRound;


		for(int i = 1; i<evenement.getEquipes().size(); i++) {

			for(int j = i+1; j<=evenement.getEquipes().size(); j++) {

				idRound = determinerRound(i, j, evenement.getEquipes().size());

				if (!evenement.getEquipes().get(i-1).getNom().equals("fake") 
						&& !evenement.getEquipes().get(j-1).getNom().equals("fake") ){

					List<ResultatConfrontation> res = new ArrayList<>();

					Confrontation confrontation = new Confrontation();
					confrontation.setEvenement(evenement);
					confrontation.setResultats(res);
					confrontation.setRound(idRound);

					ResultatConfrontation resultEq1 = new ResultatConfrontation();
					resultEq1.setEquipe(evenement.getEquipes().get(i-1));
					resultEq1.setConfrontation(confrontation);


					ResultatConfrontation resultEq2 = new ResultatConfrontation();
					resultEq2.setEquipe(evenement.getEquipes().get(j-1));
					resultEq2.setConfrontation(confrontation);


					confrontation.getResultats().add(resultEq1);
					confrontation.getResultats().add(resultEq2);

					evenement.getConfrontations().add(confrontation);
				}

			}

		}
		if(equipe != null) {
			evenement.getEquipes().remove(equipe);
		}

		evenement = proxyEvenement.refreshInstance(evenement);

		return evenement;
	}

	@Override
	public Confrontation updateScore(Confrontation confrontation) {
		return proxyEvenement.updateAjoutRes(confrontation);
	}
	@Override
	public Evenement ajouterParticipation(Participation participation, Evenement evenement) {
		proxyParticipation.ajouter(participation);
		return proxyEvenement.refreshParticipant(evenement);
	}
	@Override
	public Evenement retirerParticipation(Participation participation, Evenement evenement) {
		proxyParticipation.retirer(participation);
		return proxyEvenement.refreshParticipant(evenement);
	}
	@Override
	public Evenement ajouterEquipe(Equipe equipe, Evenement evenement) {
		proxyEquipe.ajouter(equipe);
		return proxyEvenement.refreshEquipe(evenement);
	}
	@Override
	public Evenement retirerEquipe(Equipe equipe, Evenement evenement) {
		proxyEquipe.supprimer(equipe);
		return proxyEvenement.refreshEquipe(evenement);
	}
	@Override
	public Evenement modifierEquipeAdd(Equipe equipe, Membre membre, Evenement evenement) {
		proxyEquipe.modifierCompoAdd(equipe,membre);
		return proxyEvenement.refreshEquipe(evenement);
	}
	@Override
	public Evenement modifierEquipeDel(Equipe equipe, Membre membre, Evenement evenement) {
		proxyEquipe.modifierCompoDel(equipe,membre);
		return proxyEvenement.refreshEquipe(evenement);
	}

	@Override
	public Evenement placerLesGens(Evenement evenement, List<Membre> membres) {

		proxyEvenement.placerLesGens(evenement, membres);
		return proxyEvenement.refreshEquipe(evenement);

	}

	public int determinerRound(int numeroEquipe1, int numeroEquipe2, int nombreEquipe) {

		int round;
		int retour = 1;
		/**
		 * formule pour toute équipe différente de la dernière équipe
		 */
		if ((numeroEquipe1 != nombreEquipe) && (numeroEquipe2 != nombreEquipe)) {
			round = numeroEquipe1 + numeroEquipe2 - 1;
			if (round < nombreEquipe) {
				retour = round;

			} else if (round >= nombreEquipe) {
				round = numeroEquipe1 + numeroEquipe2 - nombreEquipe;
				retour = round;
			}
		}
		/**
		 * formule quand une des équipe est la dernière équipe concerné.
		 */
		else if (numeroEquipe2 == nombreEquipe) {
			round = (2 * numeroEquipe1) - 1;
			if (round < nombreEquipe) {
				retour = round;
			} else if (round >= nombreEquipe) {
				round = (2 * numeroEquipe1) - nombreEquipe;
				retour = round;
			}
		} else if (numeroEquipe1 == nombreEquipe) {
			round = (2 * numeroEquipe2) - 1;
			if (round < nombreEquipe) {
				retour = round;
			} else if (round >= nombreEquipe) {
				round = (2 * numeroEquipe2) - nombreEquipe;
				retour = round;
			}
		}
		return retour;
	}
	@Override
	public Evenement ajouterMessage(Evenement evenement, Message message) {
		proxyMessage.ajouter(message);
		return proxyEvenement.refreshMessage(evenement);
	}
	@Override
	public Evenement retirerMessage(Evenement evenement, Message message) {
		proxyMessage.retirer(message);
		return proxyEvenement.refreshMessage(evenement);
	}


}

