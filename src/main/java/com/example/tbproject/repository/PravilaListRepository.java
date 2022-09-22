package com.example.tbproject.repository;

import com.example.tbproject.model.PravilaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PravilaListRepository extends JpaRepository<PravilaList,Long> {
}
