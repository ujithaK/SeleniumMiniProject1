# Selenium Mini Project 1

## Table of Contents
1. [Project Overview](#project-overview)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Prerequisites](#prerequisites)
5. [Setup & Installation](#setup--installation)
6. [Running Tests](#running-tests)
7. [Features](#features)
8. [Contributing](#contributing)

---

## 1 Project Overview
This project is a **Selenium WebDriver automation framework** built with **Java** and **Maven**.  
It automates web-based tests and demonstrates core Selenium concepts such as locating elements, performing actions, validations, and handling multiple browsers.

---

## 2 Tech Stack
- **Language:** Java 11+
- **Testing Framework:** TestNG
- **Automation Tool:** Selenium WebDriver
- **Build Tool:** Maven
- **Browser Drivers:** ChromeDriver 
- **Optional:** WebDriverManager for automatic driver management

---

## 3 Project Structure

SeleniumMiniProject1/
├── src/
│ ├── main/
│ │ └── java/ # Core utilities and page objects
│ └── test/
│ └── java/ # Test classes
├── pom.xml # Maven project dependencies
├── testing.xml # TestNG suite file
├── README.md # Project documentation
└── .gitignore



## 4 Prerequisites
Before running the project, make sure you have:

- **Java JDK 11+**
- **Maven**
- A supported browser installed (Chrome, Firefox)
- IDE (IntelliJ, Eclipse, VS Code, etc.)
- (Optional) WebDriverManager for automatic driver setup

---

## 5 Setup & Installation

1. **Clone the repository**
```bash
git clone https://github.com/ujithaK/SeleniumMiniProject1.git

2 **Navigate into the project folder
**
cd SeleniumMiniProject1


3 **Install dependencies**

mvn clean install


**## 6 Running Tests**

**1 Run all tests with Maven:**
mvn test

**2 Run tests using a TestNG suite:**
mvn test -DsuiteXmlFile=testing.xml

**3 Run a specific test class:**

mvn -Dtest=ClassName test

**7 Features**

Cross-browser automation
Page Object Model (POM) structure support
TestNG-based test execution
Capture screenshots on test failure
Easy to extend with new test cases

**8 Contributing**

Fork the repository
Create a new branch: git checkout -b feature-name
Make your changes
Commit your changes: git commit -m 'Add feature'
Push to the branch: git push origin feature-name
Open a Pull Request
