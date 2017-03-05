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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogApplication {

    private static final Logger LOG =LoggerFactory.getLogger(CatalogApplication.class);

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


            List<Country> countryList = loadCountries(countryRepository);


            countryList.forEach(System.out::println);

            LOG.debug("countries size : " + countryList.size());
            List<Store> stores = initializeStores(storeRepository, faker);

            List<Category> categories = initializeCategories(categoryRepository, faker);


            for(int i=0; i< 10; i++) {

				String productName = faker.commerce().productName();
				String material = faker.commerce().material();

				String sku = faker.idNumber().ssnValid();

				String description  = productName + " " +  material + " " + faker.superhero().name();



				int selectedPosition = new Random().ints(0,countryList.size()).findAny().getAsInt();

				int randomStorePosition = new Random().ints(0,stores.size()).findAny().getAsInt();

                int randomCategoryPosition = new Random().ints(0,categories.size()).findAny().getAsInt();


				Store randomStore = stores.get(randomStorePosition);

                Country randomCountry = countryList.get(selectedPosition);

                Category randomCategory = categories.get(randomCategoryPosition);



				LOG.debug(" sku : " + sku + " store : " + randomStore + " productname :"
						+ description + " category : " + randomCategory
				+ " country " + randomCountry ); ;

				Product p = new Product(sku, productName, description, randomCategory, randomStore, randomCountry);


				productRepository.save(p);

				LOG.debug(" Product ID : " + p.getId());


			}
		};

	}

    private List<Store> initializeStores(StoreRepository storeRepository, Faker faker) {

	    List<Store> stores = new ArrayList<>();


        for(int i=0; i< 10; i++) {
            String storeName = faker.commerce().department();
            Store store = new Store(storeName);
            stores.add(store);
            Store newStore = storeRepository.save(store);

            LOG.debug("Store ID " + store.getId());
        }

        return  stores;
    }


    private List<Category> initializeCategories(CategoryRepository categoryRepository, Faker faker) {

        List<Category> categories = new ArrayList<>();


        for(int i=0; i< 10; i++) {
            String material = faker.commerce().material();
            Category category = new Category(material);
            categories.add(category);
            categoryRepository.save(category);

        }

        return  categories;
    }


    private List<Country> loadCountries(CountryRepository countryRepository) {

	    List countries = new ArrayList();

	    String countryArray[] = { "North America", "Germany", "South Africa"};


        List<String> countryList = Arrays.asList(countryArray);


        countryList.forEach(country -> {
            Country s = new Country(country);
            countryRepository.save(s);

            countries.add(s);
        });

        return countries;

    }

}
