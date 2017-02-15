package com.ecommerce;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Country;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.Store;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.CountryRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.StoreRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogApplication {

	public static void main(String[] args) {



		SpringApplication.run(CatalogApplication.class, args);


	}

	@Bean
	public CommandLineRunner loadData(CountryRepository countryRepository,
									  StoreRepository storeRepository,
									  CategoryRepository categoryRepository,
									  ProductRepository productRepository) {

		return (String... args) -> {
			Faker faker = new Faker();

			for(int i=0; i< 10; i++) {

				String storeName = faker.commerce().department();
				String productName = faker.commerce().productName();
				String material = faker.commerce().material();

				String sku = faker.idNumber().ssnValid();

				String description  = productName + " " +  material + " " + faker.superhero().name();

				String[] countryList = { "North America", "Germany", "South Africa"};

				int selectedPosition = new Random().ints(0,countryList.length).findAny().getAsInt();

				System.out.println(" sku " + sku + " store " + storeName + " productname "
						+ productName + " material " + material
				+ " country " + countryList[selectedPosition] ) ;


				Country country = new Country(countryList[selectedPosition]);

				countryRepository.save(country);


				Store store = new Store(storeName);

				storeRepository.save(store);

				Category category = new Category(material);

				categoryRepository.save(category);

				productRepository.save(new Product(sku, productName, description, category, store, country));

			}
		};

	}

}
