package fr.afcepf.ai102.jee.business.api;

import java.util.List;

import fr.afcepf.ai102.jpa.entity.Personne;

public interface IBusinessConseiller extends IBusinessClient {
    List<Personne> rechercher(String nom, Class<?> type);
}
