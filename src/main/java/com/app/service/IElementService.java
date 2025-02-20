package com.app.service;

import java.util.List;
import com.app.entities.Element;
public interface IElementService {

 
    Element addElement(Element element);
    List<Element> getAllElement();
    Element getElementById(Integer id);
    Element updateElement(Element newElement);
    void deleteElement(Integer id);
}