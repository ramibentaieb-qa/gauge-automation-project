[![Gauge Selenium CI Pipeline](https://github.com/ramibentaieb-qa/gauge-automation-project/actions/workflows/main.yml/badge.svg)](https://github.com/ramibentaieb-qa/gauge-automation-project/actions/workflows/main.yml) [![Gauge Badge](https://gauge.org/Gauge_Badge.svg)](https://gauge.org) 

# Gauge Selenium Automation Project

An automated UI testing framework built with **Java**, **Gauge** (BDD framework), **Selenium WebDriver**, and **Maven**. This project validates the OrangeHRM demo application and features dual CI/CD pipeline execution supporting both **GitLab CI/CD** (via a local Windows GitLab Runner) and **GitHub Actions**.

---

## Tech Stack & Tools

* **Language:** Java 17
* **BDD Framework:** Gauge (v1.6+)
* **Test Runner:** Maven
* **UI Automation:** Selenium WebDriver (v4.x) with ChromeDriver
* **Design Pattern:** Page Object Model (POM)
* **CI/CD Platforms:** 
  * GitLab CI/CD (Local Windows 11 Shell Executor)
  * GitHub Actions (Ubuntu Linux Runner with Xvfb)

---

## Project Structure

```
gauge-automation-project/
├── env/
│   └── default/
│       └── default.properties     # Environment configurations & base URLs
├── icons/                         # Project icons & assets
├── specs/
│   └── login.spec                 # BDD specification files (.spec)
├── src/
│   └── test/
│       └── java/
│           ├── pages/             # Page Object Model classes (LoginPage, HomePage, BasePage)
│           └── StepImplementation.java # Step definitions and hook implementations
├── .github/
│   └── workflows/
│       └── main.yml               # GitHub Actions CI/CD configuration
├── .gitlab-ci.yml                 # GitLab CI/CD pipeline configuration
└── pom.xml                        # Maven dependencies and build plugins
```