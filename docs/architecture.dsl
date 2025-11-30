workspace "POOA Cinema API Architecture" "Component diagram for the POOA Cinema API system, following a Clean/Hexagonal Architecture pattern." {
    !identifiers hierarchical

    model {
        cinemaApi = softwareSystem "Cinema API" "The core system for managing cinema operations."

        cinemaApi.springBootApp = container "Spring Boot Application" "The main application, a RESTful API." "Java and Spring Boot" {
            apiControllers = component "API Controllers" "Exposes RESTful endpoints." "Spring MVC Controller"
            useCases = component "Use Cases" "Implements business logic." "Java Classes"
            domainEntities = component "Domain Entities" "Core business objects." "Java Classes"
            repositoryImpl = component "Repository Implementations" "Handles data persistence." "Spring Data JPA"
            emailService = component "Email Service" "Sends email notifications." "External Email API"
            smsService = component "SMS Service" "Sends SMS notifications." "External SMS API"
            paymentService = component "Payment Service" "Processes payments." "External Payment Gateway"

            apiControllers -> useCases "Invokes"
            useCases -> domainEntities "Manages"
            useCases -> repositoryImpl "Uses"
            useCases -> emailService "Uses"
            useCases -> smsService "Uses"
            useCases -> paymentService "Uses"
        }

        cinemaApi.database = container "Database" "Stores persistent data." "PostgreSQL or MySQL"

        cinemaApi.springBootApp.repositoryImpl -> cinemaApi.database "Reads from and writes to" "JDBC/JPA"
    }

    views {
        component cinemaApi.springBootApp "SpringBootComponents" {
            include *
            autoLayout
        }

        theme default
    }
}
