package com.example.itemservice.repo;

import com.example.itemservice.domain.Item;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by nvpivot on 6/6/18.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {

}
