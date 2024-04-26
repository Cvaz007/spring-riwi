package com.eventos.entity;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event")
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id ;
  private String name ;
  @FutureOrPresent
  private Date date ;
  private String location ;
  @Min(value = 0, message = "Capacity cannot be negative")
  private int capacity ;
}
