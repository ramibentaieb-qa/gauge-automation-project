[![Gauge Badge](https://gauge.org/Gauge_Badge.svg)](https://gauge.org)

Automated UI Testing Project
I built this project to practice and showcase my skills in test automation. It uses Behavior-Driven Development (BDD) to test web applications automatically.

Technologies I Used
Java (JDK 17): The main programming language for writing test steps.

Selenium WebDriver: To control the web browser and interact with page elements.

Gauge: A BDD test automation framework that lets me write specifications in plain English.

Maven: To manage project dependencies and build the project.

Page Object Model (POM): A design pattern to keep test scripts separate from page locators for clean, maintainable code.

GitHub Actions: For building a CI/CD pipeline that runs tests automatically in the cloud.

What I Did in This Project
Wrote BDD Specifications: I created clear test scenarios in login.spec covering successful login, invalid login attempts, and logging out.

Created Page Objects: I built reusable page classes (LoginPage and HomePage) to locate elements like input fields and buttons using OrangeHRM.

Automated User Actions: I wrote Java step implementations to handle navigation, entering credentials, clicking buttons, and asserting expected results.

Built a CI/CD Pipeline: I configured a GitHub Actions workflow (main.yml) to automatically run my test suite on an Ubuntu cloud runner every time I push code.

Configured Headless Testing: I set up Chrome options so the browser runs smoothly in headless mode on the cloud server without needing a physical screen.

Project Structure
Plaintext
gauge-automation-project/
├── .github/workflows/main.yml    # GitHub Actions CI pipeline configuration
├── specs/                        # Gauge BDD specification files (.spec)
├── src/test/java/
│   ├── pages/                    # Page Object classes (LoginPage, HomePage, BasePage)
│   └── StepImplementation.java   # Step definitions linking specs to Selenium
└── pom.xml                       # Maven configuration file
How to Run the Tests Locally
Clone this repository to your computer.

Open the project in your favorite IDE (like VS Code or IntelliJ).

Open your terminal and run the following Maven command:

Bash
mvn gauge:execute