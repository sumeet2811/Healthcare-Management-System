# 🏥 Healthcare Management System (Spring MVC)

A comprehensive Healthcare Management System built using *Spring MVC, applying various **design patterns* and *software engineering principles* to ensure maintainability, scalability, and clean code structure.

---

## ✅ Features

- *Patient Management*: Register, view, and manage patient profiles  
- *Doctor Management*: Register, view, and manage doctor profiles  
- *Appointment Scheduling*: Book, reschedule, and cancel appointments  
- *Payment Processing*: Process payments with multiple modes  
- *Schedule Management*: Doctors can manage availability  
- *User Authentication*: Secure login for patients and doctors  

---

## 🛠 Technology Stack

- *Backend*: Java, Spring MVC, Spring Data JPA  
- *Frontend*: HTML, CSS, JavaScript, Thymeleaf  
- *Database*: MySQL  
- *Build Tool*: Maven  

---

## 🧠 Design Patterns & Principles

### SOLID Principles
- *Single Responsibility* – Each class has a specific responsibility  
- *Open/Closed* – Open for extension, closed for modification  
- *Liskov Substitution* – Subclasses should be substitutable for base classes  
- *Interface Segregation* – Interfaces are tailored to client needs  
- *Dependency Inversion* – High-level modules depend on abstractions  

### Architectural Patterns
- *MVC* – Model-View-Controller  
- *DAO Pattern* – For database operations  
- *Repository Pattern* – For standard CRUD operations  
- *Service Layer Pattern* – For business logic abstraction  

### Other Patterns
- *Factory Pattern* – For object creation using Spring  
- *Singleton Pattern* – For shared services/DAOs  
- *DTO Pattern* – For data transfer between layers  
- *Template Method Pattern* – For standardized processes  
- *Transaction Management Pattern* – Ensures data consistency  

---

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher  
- Maven 3.6 or higher  
- MySQL 5.7 or higher  

### Installation

```bash
# Clone the repository
git clone https://github.com/sumeet2811/Healthcare-Management-System
cd Hospital-Management-System-MVC

# Configure your DB in application.properties
# Example:
# spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
# spring.datasource.username=root
# spring.datasource.password=yourpassword

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
