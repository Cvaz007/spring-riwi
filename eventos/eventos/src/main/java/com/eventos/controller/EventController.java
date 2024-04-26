package com.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.entity.Event;
import com.eventos.services.services_abstract.IEventService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/events")
public class EventController {
  @Autowired
  private final IEventService objIEventService;

  @GetMapping
  public ResponseEntity<Page<Event>> getAll(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {
    Page<Event> listEvents = this.objIEventService.getAll(page - 1, size);
    return ResponseEntity.ok(listEvents);
  }

  @PostMapping
  public ResponseEntity<Event> insert(@RequestBody Event objEvent) {
    return ResponseEntity.ok(this.objIEventService.save(objEvent));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Event> findById(@PathVariable Long id) {
    return ResponseEntity.ok(this.objIEventService.findById(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody Event objEvent) {
    return ResponseEntity.ok(this.objIEventService.update(id, objEvent));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.objIEventService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
