# 🎁 Customer Rewards API

A Spring Boot RESTful API to calculate reward points for a retailer's customers based on their purchase history over a three-month period.

---

## 📘 Problem Statement

A retailer offers a rewards program based on the following rules:

- **1 point** for every dollar spent **over $50** up to $100.
- **2 points** for every dollar spent **over $100**.

### Example:

For a `$120` purchase:
- 2 × ($120 - $100) = 40 points
- 1 × ($100 - $50) = 50 points  
➡️ **Total = 90 points**

---

## 🧩 Features

- Reward calculation per transaction
- Aggregated monthly and total rewards per customer
- RESTful API endpoint
- Proper JavaDocs for classes and methods
- Unit & integration tests (including negative scenarios)
- Clean code and Java coding standards followed

---

## 🧪 Tech Stack

- Java 17+
- Spring Boot 3.x
- Maven
- JUnit 5
- Lombok

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Postman or any REST client (for testing)

### Build & Run


# Clone the repository
git clone https://github.com/yourusername/rewards-api.git
cd rewards-api

# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
