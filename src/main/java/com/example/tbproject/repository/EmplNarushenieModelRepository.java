package com.example.tbproject.repository;

import com.example.tbproject.model.EmployeeNarushenieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplNarushenieModelRepository extends JpaRepository<EmployeeNarushenieModel,Long> {
}
