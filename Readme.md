# Playwright Java Test Automation Framework

A robust, scalable test automation framework built with **Playwright** and **Java 17**, following modern design patterns and best practices. This framework provides a comprehensive solution for UI testing with support for parallel execution, detailed reporting, and automatic retry mechanisms.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Key Features](#key-features)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [Configuration](#configuration)

---

## 🎯 Overview

This framework is designed to automate UI testing for web applications.

**Target Application:** [DemoQA](https://demoqa.com/)

---

## 🛠 Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17 | Programming Language |
| **Playwright** | 1.49.0 | Browser Automation |
| **TestNG** | 7.10.2 | Test Framework |
| **Allure** | 2.29.0 | Reporting |
| **AssertJ** | 3.26.3 | Fluent Assertions |
| **Lombok** | 1.18.42 | Boilerplate Reduction |
| **JavaFaker** | 1.0.2 | Test Data Generation |
| **Maven** | 3.x | Build & Dependency Management |

---

## 📁 Project Structure

```
PlaywrightJava/
├── src/
│   ├── main/java/
│   │   ├── api/                          # API-related classes (future expansion)
│   │   ├── framework/                    # Core framework components
│   │   │   ├── Injector.java             # Dependency injection utility
│   │   │   └── Steps.java                # Steps aggregator
│   │   ├── ui/                           # UI automation components
│   │   │   ├── builders/                 # Builder pattern implementations
│   │   │   │   └── TextBoxModelBuilder.java
│   │   │   ├── enums/                    # Enumerations for test data
│   │   │   │   ├── Category.java
│   │   │   │   ├── SubCategory.java
│   │   │   │   └── textBox/
│   │   │   ├── models/                   # Data models (POJOs)
│   │   │   │   └── TextBoxModel.java
│   │   │   ├── pages/                    # Page Objects
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── MainPage.java
│   │   │   │   ├── ElementsPage.java
│   │   │   │   ├── TextBoxPage.java
│   │   │   │   └── components/           # Reusable action components
│   │   │   │       ├── BaseComponent.java
│   │   │   │       ├── ElementActions.java
│   │   │   │       ├── WaitActions.java
│   │   │   │       ├── MouseActions.java
│   │   │   │       ├── KeyboardActions.java
│   │   │   │       ├── DropdownActions.java
│   │   │   │       ├── NavigationActions.java
│   │   │   │       ├── FileActions.java
│   │   │   │       ├── FrameActions.java
│   │   │   │       ├── AssertionActions.java
│   │   │   │       └── JsActions.java
│   │   │   └── steps/                    # Step definitions (business logic)
│   │   │       ├── MainSteps.java
│   │   │       ├── ElementSteps.java
│   │   │       └── TextBoxSteps.java
│   │   ├── utils/                        # Utility classes
│   │   │   ├── PropertyUtils.java
│   │   │   ├── RandomUtils.java
│   │   │   └── EnumUtils.java
│   │   └── validators/                   # Validation utilities
│   │       ├── BaseValidator.java
│   │       └── MainPageValidator.java
│   └── test/
│       ├── java/
│       │   ├── listeners/                # TestNG listeners
│       │   │   ├── AllureScreenshotListener.java
│       │   │   ├── RetryAnalyzer.java
│       │   │   └── RetryTransformer.java
│       │   └── tests/                    # Test classes
│       │       ├── AbstractTest.java     # Thread-safe browser management
│       │       ├── BaseTest.java         # Common test setup
│       │       └── ui/                   # UI test suites
│       │           ├── MainPageTests.java
│       │           ├── ElementsTests.java
│       │           └── TextBoxTests.java
│       └── resources/
│           └── base.properties           # Configuration properties
├── allure-results/                       # Allure report data
├── pom.xml                               # Maven configuration
├── TestNg.xml                            # TestNG suite configuration
└── Readme.md                             # This file
```

---

## 🏗 Architecture

#### 1. **Page Object Model (POM)**
Pages encapsulate UI element locators and page-specific actions:
```java
public class TextBoxPage extends BasePage {
    private final String SUBMIT_BUTTON = "#submit";
    
    public void clickSubmitButton() {
        element.click(SUBMIT_BUTTON);
    }
}
```

#### 2. **Component-Based Architecture**
BasePage uses composition to provide specialized action components:
- `ElementActions` - Basic interactions (click, fill, getText)
- `WaitActions` - Explicit waits
- `MouseActions` - Mouse operations (hover, drag)
- `KeyboardActions` - Keyboard operations
- `DropdownActions` - Select/dropdown handling
- `NavigationActions` - Page navigation
- `FileActions` - File upload/download
- `FrameActions` - iFrame handling
- `AssertionActions` - UI assertions
- `JsActions` - JavaScript execution

#### 3. **Steps Pattern**
Business logic layer with Allure annotations for reporting:
```java
public class TextBoxSteps {
    @Step("Fill text box form and submit")
    public void fillTextBoxAndSubmit(TextBoxModel model) {
        fillTextBox(model);
        clickSubmitButton();
    }
}
```

#### 4. **Builder Pattern**
Flexible test data creation:
```java
TextBoxModel model = TextBoxModelBuilder.buildDefaultTextBoxModel();
// or
TextBoxModel model = TextBoxModelBuilder.buildEmpty();
model.setFullName("John Doe");
```

#### 5. **Dependency Injection**
Custom injector for automatic Page Object instantiation:
```java
public class Injector {
    public <T> T get(Class<T> type) {
        // Automatically injects Page and nested dependencies
    }
}
```
---

## ✨ Key Features

| Feature | Description |
|---------|-------------|
| **Parallel Execution** | Run tests in parallel across multiple browser instances (configurable thread count) |
| **Allure Reporting** | Beautiful, detailed HTML reports with steps, screenshots, and attachments |
| **Automatic Screenshots** | Captures screenshots on test failure and skipped tests |
| **Retry Mechanism** | Automatic retry for flaky tests (configurable retry count) |
| **Test Data Generation** | JavaFaker integration for random test data |
| **Fluent Assertions** | AssertJ for readable, chainable assertions |
| **Lombok Integration** | Reduced boilerplate with annotations |
| **Property Management** | Externalized configuration via properties files |

---

## 🚀 Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **Allure CLI** (for viewing reports locally)

### Installation

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd PlaywrightJava
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Install Playwright browsers:**
   ```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
   ```

---

## ▶️ Running Tests

### Run all tests:
```bash
mvn clean test
```

### Run specific test class:
```bash
mvn clean test -Dtest=TextBoxTests
```

### Run with specific thread count:
Modify `TestNg.xml`:
```xml
<suite name="Playwright Test Suite" parallel="classes" thread-count="5">
```

---

## 📊 Reporting

### Generate Allure Report:
```bash
mvn allure:serve
```

### Retry Configuration
Modify `RetryAnalyzer.java`:
```java
private static final int MAX_RETRY_COUNT = 1;  // Number of retries for failed tests
```

---

## 📝 Writing New Tests

### 1. Create a Page Object (if needed):
```java
public class NewPage extends BasePage {
    private final String ELEMENT_SELECTOR = "#element";
    
    public void performAction() {
        element.click(ELEMENT_SELECTOR);
    }
}
```

### 2. Create Steps class:
```java
public class NewSteps {
    NewPage newPage;
    
    @Step("Perform business action")
    public void performBusinessAction() {
        newPage.performAction();
    }
}
```

### 3. Register Steps in `Steps.java`:
```java
public class Steps {
    public NewSteps newSteps;
    
    public Steps(Injector injector) {
        this.newSteps = injector.get(NewSteps.class);
    }
}
```

### 4. Write Test:
```java
public class NewTests extends BaseTest {
    @Test
    public void testScenario() {
        steps.newSteps.performBusinessAction();
    }
}
```

---

## 📄 License

This project is licensed under the MIT License.

---

