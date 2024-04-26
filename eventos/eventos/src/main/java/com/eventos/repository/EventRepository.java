package com.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventos.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
  
}
