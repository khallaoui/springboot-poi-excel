package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Session;
import com.app.repo.SessionRepo;
import com.app.service.ISessionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements ISessionService {

    private final SessionRepo sessionRepo;

    @Override
    public Session addSession(Session session) {
        return sessionRepo.save(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepo.findAll();
    }

    @Override
    public Session getSessionById(Integer id) {
        return sessionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));
    }

    @Override
    public Session updateSession(Session newSession) {
        Session session = sessionRepo.findById(newSession.getId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setDateSession(newSession.getDateSession());
        session.setDateUnv(newSession.getDateUnv());
        session.setNom(newSession.getNom());
        session.setAlias(newSession.getAlias());
        return sessionRepo.save(session);
    }

    @Override
    public void deleteSession(Integer id) {
        sessionRepo.deleteById(id);
    }
}
