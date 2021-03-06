# commerce

#Assumptions and Risks
1. Domain Model for Product uses RDBMS 
2. Specification for product is restricted to few fields which can either kept as seperate table as properties and values or moved the model to noSQL document DB like mongodb.
3. Current query model is not scalable to huge volume of products and this can be moved to seperate index like Solr or Elastic search
4. Scaling to the application to multiple seperate machine requires schedulers like docker swarm or kubernetes infrastructure to the application.
5. Hytrix need to be used to calling the pricing from the catalog service with a graceful fallback need to be implemented.
6. Assumes other parts UI and services like cart, customer facing UI are running as seperate services
7. Common Authentication & Authorization services ensures the security requirements
8. Logging, Auditing and Monitoring infrastructure is managed as seperate services
9. Strategy pattern to be used to adding various pricing methology is used to add different approaches for the product pricing.


#Pre-requisite
1. Java 8
2. Docker
3. Docker Compose
4. nodejs
5. angular cli
6. git

#System flow diagram

![alt tag](https://github.com/jeswinlouis/commerce/blob/master/docs/system%20flow.jpg?raw=true)

#Domain Model


![alt tag](https://github.com/jeswinlouis/commerce/blob/master/docs/domainModel.jpg?raw=true)

# Build Instructions

For building the ecommerce UI.

1. $ cd ecommerce

2. $ cd discovery

3. mvn spring-boot:run

4. cd ..

5. cd api-gateway

6. mvn spring-boot:run

7. cd ..

8. cd catalog

9. mvn spring-boot:run

10. cd ..

11. cd ecommerce-ui

12. npm start


Access the application from the URL http://localhost:4200/