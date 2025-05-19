package com.example.gestion_sinistre.service;

import com.example.gestion_sinistre.entity.Dossier;
import com.example.gestion_sinistre.entity.Expert;
import com.example.gestion_sinistre.repository.DossierRepository;
import com.example.gestion_sinistre.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {

    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private DossierRepository dossierRepository;

    public List<Expert> getAllExperts() {
        return (List<Expert>) expertRepository.findAll();
    }

    public Optional<Expert> getExpertById(Long id) {
        return expertRepository.findById(id);
    }

    public Expert createExpert(Expert expert) {
        if (expert.getDossiers() != null) {
            for (Dossier dossier : expert.getDossiers()) {
                dossier.setId(null);
                // important : lier le dossier à l'expert courant
                dossier.setExpert(expert);
            }
        }

        // on peut maintenant sauvegarder l'expert, Hibernate s'occupe de ses dossiers
        return expertRepository.save(expert);
    }

    public void deleteExpert(Long id) {
        expertRepository.deleteById(id);
    }

    public void affectFolderToExpert(Long idExpert, Long idFolder) {
        Optional<Expert> expertToAffect = expertRepository.findById(idExpert);
        Optional<Dossier> dossierToAffect = dossierRepository.findById(idFolder);

        if (expertToAffect.isPresent() && dossierToAffect.isPresent()) {
            Expert expert = expertToAffect.get();
            Dossier dossier = dossierToAffect.get();

            // Associer dans les deux sens
            dossier.setExpert(expert);
            dossierRepository.save(dossier); // d'abord on sauvegarde le dossier avec son expert

            expert.getDossiers().add(dossier); // mettre à jour la collection
            expertRepository.save(expert); // ensuite on sauvegarde l'expert
        }
    }


    public List<Expert> getExpersByRegion(String region) {
        return expertRepository.findByRegionIgnoreCase(region);
    }

    public Expert updateExpertById(Long id ,Expert expert) {
        if (expertRepository.findById(id).isPresent())
        {
            return expertRepository.save(expert);
        }
        else return null;
    }

}

