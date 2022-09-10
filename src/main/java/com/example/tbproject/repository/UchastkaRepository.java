package com.example.tbproject.repository;

import com.example.tbproject.model.Uchastka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UchastkaRepository extends JpaRepository<Uchastka, Integer> {
}
