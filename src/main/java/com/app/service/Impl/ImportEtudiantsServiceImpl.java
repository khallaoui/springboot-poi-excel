
package com.app.service.Impl;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.repo.EtudiantRepo;
import com.app.repo.InscriptionRepo;
import com.app.repo.NiveauRepo;
import com.app.entities.Etudiant;
import com.app.entities.Inscription;
import com.app.entities.Niveau;

@Service
@RequiredArgsConstructor
public class ImportEtudiantsServiceImpl {
    private final EtudiantRepo etudiantRepository;
    private final NiveauRepo niveauRepository;
    private final InscriptionRepo inscriptionRepository;

    public void importEtudiantsFromExcel(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream(); Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            boolean firstRow = true;

            while (rows.hasNext()) {
                Row row = rows.next();

                // Ignore the header row
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                Integer id =(int)row.getCell(0).getNumericCellValue();
                String cne = row.getCell(1).getStringCellValue();
                String nom = row.getCell(2).getStringCellValue();
                String prenom = row.getCell(3).getStringCellValue();
                String niveauNom = row.getCell(4).getStringCellValue();

                Niveau niveau = niveauRepository.findByNom(niveauNom)
                        .orElseThrow(() -> new RuntimeException("Niveau introuvable : " + niveauNom));

                Optional<Etudiant> etudiantOpt = etudiantRepository.findById(id);

                if (etudiantOpt.isPresent()) {
                    // Existing student (re-enrollment)
                    Etudiant etudiant = etudiantOpt.get();

                    // Check if the data is consistent
                    if (!etudiant.getCne().equals(cne) || !etudiant.getNom().equals(nom) || !etudiant.getPrenom().equals(prenom)) {
                        throw new RuntimeException("Les informations de l'étudiant ne correspondent pas à la base de données !");
                    }

                    // Check if the level is valid according to previous results
                    if (!validerNiveau(etudiant, niveau)) {
                        throw new RuntimeException("Le niveau indiqué est contradictoire avec les résultats de l'année passée.");
                    }

                    // Add a new inscription
                    Inscription inscription = new Inscription();
                    inscription.setEtudiant(etudiant);
                    inscription.setNiveau(niveau);
                    inscriptionRepository.save(inscription);
                } else {
                    // New student
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(id);
                    etudiant.setCne(cne);
                    etudiant.setNom(nom);
                    etudiant.setPrenom(prenom);
                    etudiantRepository.save(etudiant);

                    // Automatic enrollment
                    Inscription inscription = new Inscription();
                    inscription.setEtudiant(etudiant);
                    inscription.setNiveau(niveau);
                    inscriptionRepository.save(inscription);
                }
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'importation du fichier Excel : " + e.getMessage(), e);
        }
    }

    private boolean validerNiveau(Etudiant etudiant, Niveau nouveauNiveau) {
        List<Inscription> previousInscriptions = etudiant.getInscriptions();
        
        for (Inscription inscription : previousInscriptions) {
            Niveau currentNiveau = inscription.getNiveau();

            // Example condition: If the student has a passing status in all previous levels
            if (currentNiveau.equals(nouveauNiveau.getNiveauSuivant()) && "pass".equals(inscription.getStatut())) {
                return true;
            }
        }

        // If no valid conditions are met
        return false;
    }


    }
