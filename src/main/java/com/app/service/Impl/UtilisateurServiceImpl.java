package com.app.service.Impl;

import com.app.entities.Utilisateur;
import com.app.repo.UtilisateurRepo;
import com.app.service.IUtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {

    private final UtilisateurRepo utilisateurRepo;

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur newUtilisateur) {
        Utilisateur utilisateur = utilisateurRepo.findById(newUtilisateur.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        utilisateur.setLogin(newUtilisateur.getLogin());
        utilisateur.setMotDePasse(newUtilisateur.getMotDePasse());
        utilisateur.setNom(newUtilisateur.getNom());
        utilisateur.setAlias(newUtilisateur.getAlias());
        utilisateur.setStatus(newUtilisateur.isStatus());
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        utilisateurRepo.deleteById(id);
    }
}
