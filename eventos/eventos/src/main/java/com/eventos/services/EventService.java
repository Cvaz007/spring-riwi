package com.eventos.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eventos.entity.Event;
import com.eventos.repository.EventRepository;
import com.eventos.services.services_abstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
  @Autowired
  private final EventRepository objEventRepository;

  @Override
  public Event save(Event objEvent) {

    return this.objEventRepository.save(objEvent);
  }

  @Override
  public Page<Event> getAll(int page, int size) {
    if (page < 0) {
      page = 1;
    }
    Pageable objPageable = PageRequest.of(page, size);

    return this.objEventRepository.findAll(objPageable);
  }

  @Override
  public Event findById(Long id) {
    return this.objEventRepository.findById(id).orElse(null);

  }

  @Override
  public Event update(Long id, Event objEvent) {
    Event objEventDB = objEventRepository.findById(id).orElse(null);
    if (objEventDB == null) {
      return null;
    }
    objEvent.setId(id);
    return this.objEventRepository.save(objEvent);
  }

  @Override
  public void delete(Long id) {

    this.objEventRepository.deleteById(id);
  }

}
