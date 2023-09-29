# Auto Project

## Overview

The **Auto Project** is a Java-based REST API application that manages information about cars, manufacturers, and models. It provides a set of endpoints for performing CRUD (Create, Read, Update, Delete) operations on these entities.

## Features

- **REST API**: Implements a standard REST API for cars, manufacturers, and models, allowing you to perform basic CRUD operations.

- **Object-Oriented Design**: Utilizes object-oriented principles, including DTOs (Data Transfer Objects) and the Lombok library for getter and setter generation. Entities are organized with a focus on maintainability.

- **Logging**: Incorporates logging with various levels, including INFO for method calls, ERROR for programmatic errors, and SUCCESS for successful user inputs. Logs are stored in a dedicated database table, and filtering options are available.

- **Validation**: Ensures data integrity by validating user inputs. Any invalid user inputs are logged with the NOT_VALID level.

- **Exception Handling**: Handles errors using exceptions and provides user-friendly error messages.

- **Database Integration**: Utilizes an SQL database, such as PostgreSQL, for data storage. Includes custom SQL queries for specific data retrieval tasks.

- **Documentation**: Automatically generates API documentation using Swagger. Methods are documented using Javadoc comments.

- **Version Control**: Manages project versions with GIT, following the Gitflow branching model. Tags versions for easy reference.

- **Data Import**: Supports bulk creation of car entities by importing data from JSON or CSV files.

- **Unit Tests**: Includes unit tests for methods with complex logic to ensure code quality.

- **Postman Test Cases**: Provides test cases in Postman for API testing and validation.

## Usage

1. Clone the repository to your local machine.
2. Set up your database configuration in the application properties.
3. Build and run the application.
4. Access the API documentation through Swagger to explore available endpoints.

## Requirements

- Java (version X.X)
- Spring Boot (version X.X)
- PostgreSQL (or your preferred SQL database)
- Postman (for testing)

## Contact

For questions or inquiries, please contact jmslouka@gmail.com
