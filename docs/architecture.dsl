workspace "POOA Cinema API Architecture" "Component diagram for the POOA Cinema API system, following a Clean/Hexagonal Architecture pattern." {

    model {
        // Define the Software System and its Containers with identifiers
        cinemaApi = softwareSystem "Cinema API" "The core system for managing cinema operations, including movies, sessions, tickets, and users."

        cinemaApi.springBootApp = container "Spring Boot Application" "The main application, a RESTful API built with Spring Boot." "Java and Spring Boot"
        cinemaApi.database = container "Database" "Stores all persistent data for the cinema system." "PostgreSQL or MySQL"

        // Define Components within the Spring Boot Application container
        cinemaApi.springBootApp.apiControllers = component "API Controllers" "Exposes the RESTful endpoints (e.g., /clients, /movies)." "Spring MVC Controller"
        cinemaApi.springBootApp.useCases = component "Use Cases" "Application-specific business logic, implementing the Inbound Ports (e.g., IRegisterClientUseCase)." "Java Classes"
        cinemaApi.springBootApp.domainEntities = component "Domain Entities" "Core business objects and rules (e.g., Client, Movie, Session, Ticket)." "Java Classes"
        cinemaApi.springBootApp.repositoryImpl = component "Repository Implementations" "Handles persistence operations, implementing the Repository Outbound Ports." "Spring Data JPA"
        cinemaApi.springBootApp.emailService = component "Email Service Implementation" "Sends email notifications, implementing the Email Outbound Port." "External Email API"
        cinemaApi.springBootApp.smsService = component "SMS Service Implementation" "Sends SMS notifications, implementing the SMS Outbound Port." "External SMS API"
        cinemaApi.springBootApp.paymentService = component "Payment Strategy Implementation" "Processes payments, implementing the Payment Outbound Port." "External Payment Gateway"

        // Define Relationships (Dependencies)
        
        // 1. API Controllers -> Use Cases
        cinemaApi.springBootApp.apiControllers -> cinemaApi.springBootApp.useCases "Invokes"
        
        // 2. Use Cases -> Domain Entities
        cinemaApi.springBootApp.useCases -> cinemaApi.springBootApp.domainEntities "Manages"
        
        // 3. Use Cases -> Repository Implementations (via Outbound Ports)
        cinemaApi.springBootApp.useCases -> cinemaApi.springBootApp.repositoryImpl "Uses" "I...Repository"
        
        // 4. Use Cases -> External Services (via Outbound Ports)
        cinemaApi.springBootApp.useCases -> cinemaApi.springBootApp.emailService "Uses" "IEmailService"
        cinemaApi.springBootApp.useCases -> cinemaApi.springBootApp.smsService "Uses" "ISMSService"
        cinemaApi.springBootApp.useCases -> cinemaApi.springBootApp.paymentService "Uses" "IPaymentStrategy"
        
        // 5. Repository Implementations -> Database
        cinemaApi.springBootApp.repositoryImpl -> cinemaApi.database "Reads from and writes to" "JDBC/JPA"
    }

    views {
        // Component View for the Spring Boot Application container
        componentView cinemaApi.springBootApp "Spring Boot Application - Component Diagram" "A component diagram for the Spring Boot Application, showing the internal structure and dependencies." {
            include *
            autoLayout
        }

        theme default
    }
}
