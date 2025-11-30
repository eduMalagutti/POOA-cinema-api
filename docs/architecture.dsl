workspace "POOA Cinema API Architecture" "Component diagram for the POOA Cinema API system, following a Clean/Hexagonal Architecture pattern." {

    model {
        softwareSystem "Cinema API" "The core system for managing cinema operations, including movies, sessions, tickets, and users." {
            container "Spring Boot Application" "The main application, a RESTful API built with Spring Boot." "Java and Spring Boot" {

                component "API Controllers" "Exposes the RESTful endpoints (e.g., /clients, /movies)." "Spring MVC Controller" {
                    uses "Use Cases" "Invokes"
                }

                component "Use Cases" "Application-specific business logic, implementing the Inbound Ports (e.g., IRegisterClientUseCase)." "Java Classes" {
                    uses "Domain Entities" "Manages"
                    uses "Repository Implementations" "Uses" "I...Repository"
                    uses "Email Service Implementation" "Uses" "IEmailService"
                    uses "SMS Service Implementation" "Uses" "ISMSService"
                    uses "Payment Strategy Implementation" "Uses" "IPaymentStrategy"
                }

                component "Domain Entities" "Core business objects and rules (e.g., Client, Movie, Session, Ticket)." "Java Classes"

                component "Repository Implementations" "Handles persistence operations, implementing the Repository Outbound Ports." "Spring Data JPA" {
                    uses "Database" "Reads from and writes to" "JDBC/JPA"
                }

                component "Email Service Implementation" "Sends email notifications, implementing the Email Outbound Port." "External Email API"
                component "SMS Service Implementation" "Sends SMS notifications, implementing the SMS Outbound Port." "External SMS API"
                component "Payment Strategy Implementation" "Processes payments, implementing the Payment Outbound Port." "External Payment Gateway"
            }

            container "Database" "Stores all persistent data for the cinema system." "PostgreSQL or MySQL"
        }
    }

    views {
        component "Spring Boot Application" "Component Diagram" {
            include *
            autoLayout
        }

        theme default
    }
}
