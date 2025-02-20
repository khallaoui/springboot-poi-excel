package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Element;
import com.app.repo.ElementRepo;
import com.app.service.IElementService;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements IElementService {

    private final ElementRepo elementRepo;

    @Override
    public Element addElement(Element element) {
        return elementRepo.save(element);
    }

    @Override
    public List<Element> getAllElement() {
        return elementRepo.findAll();
    }

    @Override
    public Element getElementById(Integer id) {
        return elementRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Element not found with id: " + id));
    }

    @Override
    public Element updateElement(Element newElement) {
        Element element = elementRepo.findById(newElement.getId())
                .orElseThrow(() -> new RuntimeException("Element not found"));
        element.setNom(newElement.getNom());
        element.setAlias(newElement.getAlias());
        element.setNote(newElement.getNote());
        return elementRepo.save(element);
    }

    @Override
    public void deleteElement(Integer id) {
        elementRepo.deleteById(id);
    }
}