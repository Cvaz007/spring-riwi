package com.riwi.simulacro.domain.repositories;

import com.riwi.simulacro.domain.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Integer> { }
