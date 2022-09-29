package com.example.tbproject.repository;

import com.example.tbproject.model.PhotoNarushenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoNarushenieRepository extends JpaRepository<PhotoNarushenie, Long> {
    Optional<PhotoNarushenie> findByCdate(String cdate);

}
