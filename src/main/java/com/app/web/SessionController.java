package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Session;
import com.app.service.ISessionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final ISessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<Session> addSession(@Valid @RequestBody Session session) {
        Session savedSession = sessionService.addSession(session);
        return new ResponseEntity<>(savedSession, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/get/{id}")
    public Session getSessionById(@PathVariable("id") Integer id) {
        return sessionService.getSessionById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Session> updateSession(@Valid @RequestBody Session session) {
        Session updatedSession = sessionService.updateSession(session);
        return new ResponseEntity<>(updatedSession, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSession(@PathVariable("id") Integer id) {
        sessionService.deleteSession(id);
        return new ResponseEntity<>("Session deleted successfully", HttpStatus.OK);
    }
}
