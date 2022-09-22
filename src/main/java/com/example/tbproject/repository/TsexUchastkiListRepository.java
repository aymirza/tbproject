package com.example.tbproject.repository;

import com.example.tbproject.model.TsexUchastkiList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TsexUchastkiListRepository extends JpaRepository<TsexUchastkiList,Long> {
}
