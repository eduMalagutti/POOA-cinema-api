workspace "Cinema API" "Sistema de gerenciamento de cinema" {

    model {
        # Atores externos
        client = person "Cliente" "Usuário que compra ingressos e assiste filmes"
        manager = person "Gerente" "Usuário que gerencia o cinema, sessões e filmes"

        # Sistema principal
        cinemaSystem = softwareSystem "Cinema API" "Sistema de gerenciamento de cinema baseado em Spring Boot" {
            
            # Camada de Adapters (Interface)
            adaptersLayer = container "Adapters Layer" "Camada de adaptadores de entrada" {
                restControllers = component "REST Controllers" "Controllers REST para expor endpoints da API" "Spring MVC"
                securityConfig = component "Security" "Configuração de segurança HTTP" "Spring Security"
                exceptionHandlers = component "Exception Handlers" "Tratamento global de exceções" "Spring MVC"
            }

            # Camada de Application (Casos de Uso e Domínio)
            applicationLayer = container "Application Layer" "Camada de aplicação com regras de negócio e domínio" {
                
                # Domain (Entidades e Enums)
                entities = component "Domain Entities" "Entidades do domínio: Client, Manager, Movie, Room, Session, Theater, Ticket, User, Address, Genre, Row, Seat" "JPA Entities"
                enums = component "Domain Enums" "Enumerações: AgeRating, Format, Gender, PaymentMethod, Role, RoomType, SeatType, Subtitle" "Java Enums"
                
                # Ports (Interfaces)
                inputPorts = component "Input Ports" "Interfaces dos casos de uso" "Java Interfaces"
                
                # Use Cases (Implementações)
                clientUseCases = component "Client Use Cases" "Casos de uso relacionados a clientes" "Spring Service"
                managerUseCases = component "Manager Use Cases" "Casos de uso relacionados a gerentes" "Spring Service"
                movieUseCases = component "Movie Use Cases" "Casos de uso relacionados a filmes" "Spring Service"
                roomUseCases = component "Room Use Cases" "Casos de uso relacionados a salas" "Spring Service"
                sessionUseCases = component "Session Use Cases" "Casos de uso relacionados a sessões" "Spring Service"
                theaterUseCases = component "Theater Use Cases" "Casos de uso relacionados a cinemas" "Spring Service"
                ticketUseCases = component "Ticket Use Cases" "Casos de uso relacionados a ingressos" "Spring Service"
                userUseCases = component "User Use Cases" "Casos de uso relacionados a usuários" "Spring Service"
                
                # DTOs
                dtos = component "DTOs" "Data Transfer Objects para request/response" "Java Records/Classes"
                
                # Validation
                validation = component "Validation" "Validadores customizados" "Bean Validation"
                
                # Exceptions
                exceptions = component "Exceptions" "Exceções de negócio" "Java Exceptions"
            }

            # Camada de Configuração
            configLayer = container "Configuration Layer" "Configurações da aplicação" {
                asyncConfig = component "Async Config" "Configuração de processamento assíncrono" "Spring Config"
                frameworkConfig = component "Framework Config" "Configuração do framework customizado" "Spring Config"
                notificationConfig = component "Notification Config" "Configuração de notificações" "Spring Config"
            }
        }

        # Sistemas externos
        database = softwareSystem "Database" "Banco de dados PostgreSQL" "External"
        notificationService = softwareSystem "Notification Service" "Serviço de envio de notificações por email" "External"

        # Relacionamentos entre pessoas e sistema
        client -> cinemaSystem "Usa para comprar ingressos e ver sessões"
        manager -> cinemaSystem "Usa para gerenciar filmes, sessões e salas"

        # Relacionamentos internos do sistema
        restControllers -> inputPorts "Implementa"
        restControllers -> dtos "Usa"
        restControllers -> exceptionHandlers "Delega exceções"
        
        inputPorts -> clientUseCases "Define contrato"
        inputPorts -> managerUseCases "Define contrato"
        inputPorts -> movieUseCases "Define contrato"
        inputPorts -> roomUseCases "Define contrato"
        inputPorts -> sessionUseCases "Define contrato"
        inputPorts -> theaterUseCases "Define contrato"
        inputPorts -> ticketUseCases "Define contrato"
        inputPorts -> userUseCases "Define contrato"
        
        clientUseCases -> entities "Manipula"
        managerUseCases -> entities "Manipula"
        movieUseCases -> entities "Manipula"
        roomUseCases -> entities "Manipula"
        sessionUseCases -> entities "Manipula"
        theaterUseCases -> entities "Manipula"
        ticketUseCases -> entities "Manipula"
        userUseCases -> entities "Manipula"
        
        dtos -> validation "Validado por"
        entities -> enums "Usa"
        
        # Relacionamentos com sistemas externos
        cinemaSystem -> database "Persiste dados"
        cinemaSystem -> notificationService "Envia notificações"
    }

    views {
        # Vista de contexto do sistema
        systemContext cinemaSystem "SystemContext" {
            include *
            autoLayout
        }

        # Vista de containers
        container cinemaSystem "Containers" {
            include *
            autoLayout
        }

        # Vista de componentes da camada de adapters
        component adaptersLayer "AdaptersComponents" {
            include *
            autoLayout
        }

        # Vista de componentes da camada de application (inclui domain)
        component applicationLayer "ApplicationComponents" {
            include *
            autoLayout
        }

        styles {
            element "Software System" {
                background #1168bd
                color #ffffff
            }
            element "Person" {
                shape Person
                background #08427b
                color #ffffff
            }
            element "Container" {
                background #438dd5
                color #ffffff
            }
            element "Component" {
                background #85bbf0
                color #000000
            }
            element "External" {
                background #999999
                color #ffffff
            }
        }
    }

}
