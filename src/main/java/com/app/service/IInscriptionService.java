package com.app.service;

import java.util.List;
import com.app.entities.Inscription;

public interface IInscriptionService {

    Inscription addInscription(Inscription inscription);
    List<Inscription> getAllInscriptions();
    Inscription getInscriptionById(Integer id);
    Inscription updateInscription(Inscription newInscription);
    void deleteInscription(Integer id);
}
