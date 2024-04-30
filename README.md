# ⚚ Hermes - Your Payments App

<div align='center'>
    <img src="https://github.com/Larry8668/hermes/assets/114809719/d08db9d0-7c8d-464a-9318-5e2c9b335116" height = "450" />
</div>

---

This app is designed to simplify transactions between users, merchants, and administrators. Built on Spring Boot with JPA repositories and PostgreSQL, it provides a robust backend infrastructure for secure and efficient payment processing.

---

## 🔮 Features

1. **User Login**: Users can securely log in to their accounts to access various functionalities.

2. **Sending Money**: Users can easily send money to other users within the app.

3. **Reward Scheme for Users**: Users will earn rewards and cashbacks for more transactions they make.

4. **Stock Creation using Factory**: Stock creation is simplified through a factory pattern, where predefined stocks like tech, finance, or pharma can be easily generated.

5. **Builder Pattern for Custom Stock Creation**: Users can create custom stocks by specifying the name, type, and price, providing step-by-step instructions for stock creation.

6. **Admin Portal**: Administrators have access to a portal where they can view all accounts, transactions, and manage stock creation.

7. **Notification System**: An observer pattern is implemented for notifications. Admins are subscribers, and they receive notifications whenever transactions occur.

---

## 📜 Design Patterns Utilized

- **Singleton**: Leveraging Spring Boot's `@Service` or `@Component` annotation ensures that each instance of any class exists at most once, maintaining singleton behavior.

- **Adapter**: Spring Boot's JPA repository acts as an adapter between the backend and the chosen database. This abstraction simplifies database interactions, allowing the flexibility to use various databases without altering backend logic.

- **Factory Pattern**: Used for stock creation, abstracting the process by defining stock types and their respective attributes.

- **Builder Pattern**: Custom stock creation is facilitated through a builder pattern, providing step-by-step guidance for stock configuration.

- **Observer Pattern**: Implemented for the notification system, where admins act as observers and receive notifications upon transaction events.

---

## 📄 Software Engineering Principles

- **Single Responsibility Principle (SRP)**: Each class or module has a single responsibility, enhancing maintainability and reducing code complexity.

- **Open/Closed Principle (OCP)**: The system is designed to be open for extension but closed for modification, allowing for easy integration of new features without altering existing code.

- **Model-View-Controller-Service (MVCS)**: The architecture follows MVCS principles, separating concerns between data, presentation, and logic layers for better organization and maintainability.

- **Low Coupling (GRASP)**: Components are loosely coupled, minimizing dependencies between modules, thus enhancing flexibility and scalability.

- **Creator (GRASP)**: Emphasizes the importance of specialized factories for creating objects, promoting a more cohesive design.

---

## ⚙️ How to Use

1. Clone the repository.
2. Configure your PostgreSQL database details in the `application.properties` file.
3. Build and run the application.
4. Access the application through the provided endpoints for user login, transaction processing, and admin functionalities.

---
