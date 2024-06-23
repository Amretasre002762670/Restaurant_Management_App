# Restaurant Management Application

## Overview

This Restaurant Management Application is a web-based solution developed using Spring Boot, Hibernate, and JSP. The application aims to streamline and simplify the management of restaurant operations, including menu management, order processing, and customer management.

## Features

- **Menu Management**: Create, update, and delete menu items.
- **Order Management**: Process customer orders and track order status.
- **Customer Management**: Manage customer information and order history.
- **Staff Management**: Manage restaurant staff details and roles.
- **Reporting**: Generate reports for sales and inventory.

## Technologies Used

- **Backend**: 
  - Spring Boot
  - Hibernate (for ORM)
- **Frontend**: 
  - JSP (JavaServer Pages)
- **Database**: 
  - MySQL (or any other compatible RDBMS)
- **Others**: 
  - POJO classes for model representation

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+
- MySQL 5.7+ (or any other compatible RDBMS)
- An IDE like IntelliJ IDEA or Eclipse

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/restaurant-management-app.git
   cd restaurant-management-app
   ```

2. **Set Up the Database**

   No need to manually create the database. The application will create it automatically if it doesn't exist.

3. **Update the Database Configuration**

   The database configuration is set using Hibernate utility. Ensure your `HibernateUtil.java` file in the `utils` package contains the correct settings:

   ```
   DRIVER: com.mysql.cj.jdbc.Driver
   URL: jdbc:mysql://localhost:3306/ordersManageDB?createDatabaseIfNotExist=true
   USER: root
   PASS: amre1999
   DIALECT: org.hibernate.dialect.MySQL8Dialect
   ```

4. **Build and Run the Application**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The application will be accessible at `http://localhost:8080`.

## Directory Structure

```
restaurant-management-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── webtools/
│   │   │           └── ResManageApp/
│   │   │               ├── DAO/              # Data Access Objects (DAO)
│   │   │               ├── controller/       # Controllers
│   │   │               ├── exceptions/       # Custom exceptions
│   │   │               ├── pojo/             # POJO classes (models)
│   │   │               ├── utils/            # Utility classes
│   │   │               ├── validator/        # Validation classes
│   │   │               └── ResManageAppApplication.java
│   │   ├── resources/
│   │   │   ├── static/                       # Static files
│   │   │   ├── templates/                    # JSP files
│   │   │   └── application.properties        # Configuration
│   └── test/
│       └── java/
│           └── com/
│               └── webtools/
│                   └── ResManageApp/
│                       └── ResManageAppApplicationTests.java
├── .gitignore
├── pom.xml
└── README.md
```

## Key Components

### Controllers

Located in `src/main/java/com/webtools/ResManageApp/controller/`, these classes handle HTTP requests and responses.

### DAO (Data Access Objects)

Located in `src/main/java/com/webtools/ResManageApp/DAO/`, these classes manage data access using Hibernate:

- `AddressDAO.java`
- `CustomerDAO.java`
- `DAO.java`
- `MenuDAO.java`
- `OrderDAO.java`
- `RestaurantDAO.java`
- `UserDAO.java`

### Exceptions

Located in `src/main/java/com/webtools/ResManageApp/exceptions/`, these classes handle custom exceptions.

### POJO Classes

Located in `src/main/java/com/webtools/ResManageApp/pojo/`, these classes represent the entities in the application.

### Utils

Located in `src/main/java/com/webtools/ResManageApp/utils/`, these classes provide utility functions.

### Validator

Located in `src/main/java/com/webtools/ResManageApp/validator/`, these classes perform validation.

### Views

Located in `src/main/resources/templates/`, these JSP files are used to render the frontend.

## Configuration

Application-specific configurations are located in `src/main/resources/application.properties`.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


---

Thank you for using the Restaurant Management Application! We hope it helps you streamline your restaurant operations efficiently.
