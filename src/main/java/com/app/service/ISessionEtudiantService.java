package com.app.service;

import java.util.List;
import com.app.entities.SessionEtudiant;

public interface ISessionEtudiantService {

    SessionEtudiant addSessionEtudiant(SessionEtudiant sessionEtudiant);
    List<SessionEtudiant> getAllSessionEtudiants();
    SessionEtudiant getSessionEtudiantById(Integer id);
    SessionEtudiant updateSessionEtudiant(SessionEtudiant newSessionEtudiant);
    void deleteSessionEtudiant(Integer id);
}
