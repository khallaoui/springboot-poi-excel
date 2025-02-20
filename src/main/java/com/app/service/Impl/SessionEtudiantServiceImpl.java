package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.SessionEtudiant;
import com.app.repo.SessionEtudiantRepo;
import com.app.service.ISessionEtudiantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionEtudiantServiceImpl implements ISessionEtudiantService {

    private final SessionEtudiantRepo sessionEtudiantRepo;

    @Override
    public SessionEtudiant addSessionEtudiant(SessionEtudiant sessionEtudiant) {
        return sessionEtudiantRepo.save(sessionEtudiant);
    }

    @Override
    public List<SessionEtudiant> getAllSessionEtudiants() {
        return sessionEtudiantRepo.findAll();
    }

    @Override
    public SessionEtudiant getSessionEtudiantById(Integer id) {
        return sessionEtudiantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SessionEtudiant not found with id: " + id));
    }

    @Override
    public SessionEtudiant updateSessionEtudiant(SessionEtudiant newSessionEtudiant) {
        SessionEtudiant sessionEtudiant = sessionEtudiantRepo.findById(newSessionEtudiant.getId())
                .orElseThrow(() -> new RuntimeException("SessionEtudiant not found"));
        sessionEtudiant.setEtudiant(newSessionEtudiant.getEtudiant());
        sessionEtudiant.setSession(newSessionEtudiant.getSession());
        return sessionEtudiantRepo.save(sessionEtudiant);
    }

    @Override
    public void deleteSessionEtudiant(Integer id) {
        sessionEtudiantRepo.deleteById(id);
    }
}
