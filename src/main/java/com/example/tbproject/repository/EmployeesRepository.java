package com.example.tbproject.repository;

import com.example.tbproject.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
        public Employees findByEmpid(int empid);
}
