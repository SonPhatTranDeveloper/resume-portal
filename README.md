# Remy - Online Resume Platform

Remy is a web application that allows users to create, manage, and showcase their professional resumes online. It is built using the Spring Boot framework, leveraging Spring MVC for web development and Spring Security for authentication and authorization.

![Remy](./images/remy.png)

## Features

- User registration and authentication
- Create, update, and delete resumes
- Multiple resume templates to choose from
- Customizable sections (education, experience, skills, etc.)
- Resume sharing and download options (PDF, Word, etc.)
- Admin panel for user management and application settings

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Security
- Thymeleaf (for templating)
- HTML/CSS/JavaScript
- Bootstrap (for responsive design)
- MySQL (or any other relational database)
- Maven (for dependency management)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- MySQL Server
- Maven

### Installation

Note: These steps will be finalised when the project is done.

1. Clone the repository:
```
git clone
```
2. Navigate to the project directory 
```
cd resume-portal
```
3. Configure the database connection properties in `src/main/resources/application.properties`.
4. Build the project using Maven:
```
mvn clean install
```
5. Run the application:
```
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).