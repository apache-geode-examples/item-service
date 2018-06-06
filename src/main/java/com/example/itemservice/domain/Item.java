package com.example.itemservice.domain;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * Created by nvpivot on 6/6/18.
 */
@Data
@EqualsAndHashCode(of = { "name" })
@ToString(of = { "name" })
@Region("items")
public class Item {

  private static AtomicLong COUNTER = new AtomicLong(0L);

  @Id
  private Long id;

  private String name;
  private Double price;
  private String category;
  private String description;

  public Item(String name) {
    this.id = COUNTER.getAndIncrement();
    this.name = name;
  }

  public Item(String name, String price) {
    this.id = COUNTER.getAndIncrement();
    this.name = name;
    this.price = Double.parseDouble(price);
  }
}
