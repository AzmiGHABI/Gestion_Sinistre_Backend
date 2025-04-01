package com.example.gestion_sinistre.controller;

import com.example.gestion_sinistre.entity.Expert;
import com.example.gestion_sinistre.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expert")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @GetMapping
    public List<Expert> getAllExperts() {
        return expertService.getAllExperts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expert> getExpertById(@PathVariable Long id) {
        Optional<Expert> expert = expertService.getExpertById(id);
        return expert.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Expert createExpert(@RequestBody Expert expert) {
        return expertService.createExpert(expert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpert(@PathVariable Long id) {
        expertService.deleteExpert(id);
        return ResponseEntity.noContent().build();
    }
}
