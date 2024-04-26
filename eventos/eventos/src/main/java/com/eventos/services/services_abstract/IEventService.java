package com.eventos.services.services_abstract;

import org.springframework.data.domain.Page;

import com.eventos.entity.Event;

public interface IEventService {
  public Event  save (Event objEvent);
  public Page<Event> getAll (int page, int size);
  public Event findById (Long id);
  public Event update (Long id , Event objEvent);
  public void delete (Long id);
}
