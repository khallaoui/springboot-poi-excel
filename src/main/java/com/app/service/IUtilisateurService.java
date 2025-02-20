package com.app.service;

import com.app.entities.Utilisateur;
import java.util.List;

public interface IUtilisateurService {
    Utilisateur addUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurById(Integer id);
    Utilisateur updateUtilisateur(Utilisateur newUtilisateur);
    void deleteUtilisateur(Integer id);
}
