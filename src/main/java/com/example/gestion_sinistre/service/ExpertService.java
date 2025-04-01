package com.example.gestion_sinistre.service;

import com.example.gestion_sinistre.entity.Expert;
import com.example.gestion_sinistre.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {

    @Autowired
    private ExpertRepository expertRepository;

    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }

    public Optional<Expert> getExpertById(Long id) {
        return expertRepository.findById(id);
    }

    public Expert createExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    public void deleteExpert(Long id) {
        expertRepository.deleteById(id);
    }
}

