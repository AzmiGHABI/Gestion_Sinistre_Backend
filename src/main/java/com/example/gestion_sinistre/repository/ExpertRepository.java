package com.example.gestion_sinistre.repository;

import com.example.gestion_sinistre.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertRepository extends CrudRepository<Expert, Long> {
    Optional<Expert> findByEmail(String email);
    List<Expert> findByRegion(String region);
}
