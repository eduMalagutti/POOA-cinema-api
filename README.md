# 🎬 POOA Cinema API

This project is part of the coursework for **Advanced Object-Oriented Programming (POOA)** at UFSCar.

## 📘 Description

REST API for managing cinema ticket purchases, built to study software architecture and good development practices.

## 🧱 Architecture

* Hexagonal Architecture (Ports & Adapters)
* SOLID principles
* Design patterns: Singleton, Dependency Injection and Dependency Inversion
* Heavy use of interfaces for decoupling

## 🚀 Technologies

* Java 21
* Apache Maven
* Docker & Docker Compose (for the database)

## 🛠️ Running the Project

### Prerequisites

* Java 21
* Apache Maven
* Docker

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/eduMalagutti/POOA-cinema-api.git
   cd POOA-cinema-api
   ```

2. Start the database with Docker Compose:

   ```bash
   docker-compose up -d
   ```

3. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Set up the email environment variables:

   Copy `env-example.properties` to `env-dev.properties` and fill in your email credentials:

   ```properties
   EMAIL_HOST=smtp.gmail.com
   EMAIL_PORT=587
   EMAIL_SENDER="Sender Name" <your-email>
   EMAIL_USERNAME=your-email
   EMAIL_PASSWORD=your-password
   ```

   **Note:** The system uses these settings to send email notifications.

   **⚠️ For Gmail:** `EMAIL_PASSWORD` must be an **App Password**, not your regular Gmail password. To generate one:
   1. Go to your Google account at [myaccount.google.com](https://myaccount.google.com)
   2. Open **Security** → **2-Step Verification** (enable it if needed)
   3. Open **App passwords** and generate a new password for the application
   4. Use the generated password as `EMAIL_PASSWORD`

5. Access the API at:

   ```
   http://localhost:8080
   ```



## 📂 Project Structure

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/ufscar/pooa/cinema_api/
│   │   │           ├── adapters/
│   │   │           │   ├── in/
│   │   │           │   └── out/
│   │   │           ├── application/
│   │   │           │   ├── dtos/
│   │   │           │   ├── exceptions/
│   │   │           │   ├── ports/
│   │   │           │   │   ├── in/
│   │   │           │   │   └── out/
│   │   │           │   ├── usecases/
│   │   │           │   └── validation/
│   │   │           ├── config/
│   │   │           └── domain/
│   │   │               └── enums/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       └── templates/
├── docs/
│   ├── gemini.md
│   └── hexagonal-rules.md
├── docker-compose.yml
├── pom.xml
└── README.md
```



## 🧪 Tests

To run the automated tests:

```bash
mvn test
```
