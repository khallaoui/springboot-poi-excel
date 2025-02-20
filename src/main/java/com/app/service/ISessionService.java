package com.app.service;

import java.util.List;
import com.app.entities.Session;

public interface ISessionService {

    Session addSession(Session session);
    List<Session> getAllSessions();
    Session getSessionById(Integer id);
    Session updateSession(Session newSession);
    void deleteSession(Integer id);
}
