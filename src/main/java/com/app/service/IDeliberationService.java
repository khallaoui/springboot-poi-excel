package com.app.service;

import java.util.List;
import com.app.entities.Deliberation;

public interface IDeliberationService {

    Deliberation addDeliberation(Deliberation deliberation);
    List<Deliberation> getAllDeliberations();
    Deliberation updateDeliberation(Deliberation newDeliberation);
	Deliberation getDeliberationById(Integer id);
	void deleteDeliberation(Integer id);
}
