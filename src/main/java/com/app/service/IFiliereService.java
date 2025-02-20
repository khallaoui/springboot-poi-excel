package com.app.service;

import java.util.List;
import com.app.entities.Filiere;

public interface IFiliereService {

    Filiere addFiliere(Filiere filiere);
    List<Filiere> getAllFilieres();
    Filiere getFiliereById(Integer id);
    Filiere updateFiliere(Filiere newFiliere);
    void deleteFiliere(Integer id);
}
