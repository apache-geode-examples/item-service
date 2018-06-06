package com.example.itemservice;

import com.example.itemservice.domain.Item;
import com.example.itemservice.repo.ItemRepository;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;

@SpringBootApplication
@EnableEntityDefinedRegions(basePackageClasses = Item.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner run(ItemRepository itemRepository) {

		return args -> {

			itemRepository.save(new Item("Book", "123.45"));
			itemRepository.save(new Item("Ipad", "678.90"));

			System.out.println("Items are: "+itemRepository.findAll());
		};
	}
}
