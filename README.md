# Spring Boot JWT Authentication Example

This is a simple Spring Boot application demonstrating JWT (JSON Web Token) authentication. It includes user registration, authentication, and authorization using Spring Security and JWT.

## Table of Content s📑
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Endpoints](#endpoints)


## Overview

This Spring Boot application provides a basic implementation of JWT authentication. It includes the following components:

- **Controller  🎮**: Exposes endpoints for user registration and authentication.
- **DTO (Data Transfer Object)**: Defines request and response objects for registration and authentication.
- **Entity**: Represents the User entity, including user details and roles.
- **Repository**: Manages the persistence of User entities.
- **Security Configuration  🔐**: Configures Spring Security with JWT authentication.
- **Service ⚙️**: Implements business logic for user registration and authentication.
- **Security Filter**: Custom filter to intercept requests, validate JWT, and set up the authentication context.

## Prerequisites

Make sure you have the following installed:

- Java 8 or later
- Maven
- Your favorite IDE (e.g., IntelliJ, Eclipse)

## Project Structure

The project is organized as follows:


src
|-- main
    |-- java
        |-- com.example.demo
            |-- Controller
            |-- Dto
            |-- Entity
            |-- Repository
            |-- Security
            |-- Service



## Installation and Setup

1. **Clone the repository:**
   - Run the following command in your terminal:
     ```
     git clone https://github.com/your-username/spring-boot-jwt-authentication.git
     ```

2. **Open the project in your preferred IDE.**

3. **Build the project:**
   - Execute the following command to build the project:
     ```
     mvn clean install
     ```

4. **Run the application:**
   - Start the application using the following command:
     ```
     mvn spring-boot:run
     ```

## Usage

Once the application is running, you can use tools like Postman or curl to interact with the exposed endpoints.

## Endpoints

### Register User

- **URL:** `POST /jwt/register`
- **Request Body:**
  ```json
  {
    "email": "user@example.com",
    "firstname": "John",
    "lastname": "Doe",
    "password": "password123"
  }

 ## Response:

{
  "token": "your-generated-token-here"
}
Authenticate User
URL: POST /jwt/authenticate

##Request Body:


{
  "email": "user@example.com",
  "password": "password123"
}
 ## Response:

{
  "token": "your-generated-token-here"
}