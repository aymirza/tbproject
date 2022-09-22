package com.example.tbproject.repository;

import com.example.tbproject.model.NarushenieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarushenieListRepository extends JpaRepository<NarushenieList, Long> {
}
