# Playwright Java Test Automation Framework

## Overview

Test automation framework built with Playwright and **Java** for UI testing for testing https://demoqa.com.

---

## Project Structure

```
PlaywrightJava/
├── src/
│   ├── main/java/
│   │   ├── builders/          # Test data builders
│   │   ├── enums/             # Enumerations for constants
│   │   ├── framework/         # Core framework classes
│   │   ├── models/            # Data models (POJOs)
│   │   ├── pages/             # Page Object classes
│   │   │   └── components/    # Reusable action components
│   │   ├── steps/             # Business logic steps
│   │   ├── utils/             # Utility classes
│   │   └── validators/        # Validation helpers
│   │
│   └── test/
│       ├── java/
│       │   ├── helpers/       # Test helpers
│       │   ├── listeners/     # TestNG listeners
│       │   └── tests/         # Test classes
│       │       ├── ui/        # UI tests
│       │       └── api/       # API tests
│       └── resources/
│           └── simplelogger.properties
│
├── allure-results/            # Allure report data
├── pom.xml                    # Maven configuration
└── TestNg.xml                 # TestNG suite configuration
```

---

## Architecture

### Layer Diagram

```
┌─────────────────────────────────────────────────────────┐
│                      TEST LAYER                         │
│  (TextBoxTests, MainPageTests, ElementsTests)           │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                     STEPS LAYER                         │
│  (MainSteps, ElementSteps, TextBoxSteps)                │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                     PAGES LAYER                         │
│  (MainPage, ElementsPage, TextBoxPage)                  │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                  COMPONENTS LAYER                       │
│  (ElementActions, WaitActions, MouseActions, etc.)      │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                    PLAYWRIGHT                           │
└─────────────────────────────────────────────────────────┘
```

---

## Class Descriptions

### Framework (`framework/`)

| Class | Description |
|-------|-------------|
| `Injector` | Custom dependency injection utility. Automatically injects Playwright Page instances and nested page objects using reflection. |
| `Steps` | Aggregates all step classes. Provides single access point to all business steps. |

### Pages (`pages/`)

| Class | Description |
|-------|-------------|
| `BasePage` | Abstract base class for all pages. Initializes and exposes action components (`element`, `wait`, `mouse`, etc.). |
| `MainPage` | Main landing page. Handles application category selection. |
| `ElementsPage` | Elements section page. Handles category and sub-category navigation. |
| `TextBoxPage` | Text Box form page. Handles form input, submission, and output validation. |

### Page Components (`pages/components/`)

| Class | Description |
|-------|-------------|
| `BaseComponent` | Abstract base for all components. Provides `getLocator()` method. |
| `ElementActions` | Basic element interactions: click, fill, getText, isVisible, check/uncheck. |
| `WaitActions` | Wait operations: waitForVisible, waitForHidden, waitForEnabled, waitForUrl. |
| `MouseActions` | Mouse interactions: hover, doubleClick, rightClick, scrollIntoView. |
| `KeyboardActions` | Keyboard operations: pressKey, typeSlow. |
| `DropdownActions` | Dropdown handling: selectByValue, selectByLabel, selectByIndex. |
| `NavigationActions` | Navigation: navigate, getCurrentUrl, goBack, goForward, reload. |
| `FileActions` | File operations: uploadFile, download. |
| `FrameActions` | Frame handling: getFrameByName, getFrameBySelector. |
| `AssertionActions` | Playwright assertions: validateText, validateVisible, validateAttribute. |
| `JsActions` | JavaScript execution: executeJs. |

### Steps (`steps/`)

| Class | Description |
|-------|-------------|
| `MainSteps` | Business steps for main page operations. |
| `ElementSteps` | Business steps for elements section navigation. |
| `TextBoxSteps` | Business steps for text box form operations and validations. |

### Models (`models/`)

| Class | Description |
|-------|-------------|
| `TextBoxModel` | Data model for TextBox form fields (fullName, email, currentAddress, permanentAddress). Uses Lombok `@Data` and `@Builder`. |

### Builders (`builders/`)

| Class | Description |
|-------|-------------|
| `TextBoxModelBuilder` | Factory methods for creating TextBoxModel instances with default or custom data. |

### Enums (`enums/`)

| Class | Description |
|-------|-------------|
| `Category` | Main application categories (Elements, Forms, Alerts, Widgets, Interactions, Book Store). |
| `SubCategory` | Sub-categories with display names and URLs. |
| `InputTextBoxValues` | Input field identifiers for TextBox form. |
| `OutputTextBoxValues` | Output field identifiers for TextBox validation. |

### Utils (`utils/`)

| Class | Description |
|-------|-------------|
| `RandomUtils` | Random data generation using JavaFaker (names, emails, strings, numbers). |
| `PropertyUtils` | Configuration property reader from resource files. |
| `EnumUtils` | Utility methods for enum operations. |

### Validators (`validators/`)

| Class | Description |
|-------|-------------|
| `BaseValidator` | Generic validation methods using AssertJ. |
| `MainPageValidator` | Specific validations for main page. |

### Tests (`tests/`)

| Class | Description |
|-------|-------------|
| `AbstractTest` | Base test class. Sets up Playwright browser, context, page, and dependency injection. |
| `BaseTest` | Extends AbstractTest. Adds navigation to base URL in `@BeforeMethod`. |
| `MainPageTests` | Tests for main page functionality. |
| `ElementsTests` | Tests for elements section. |
| `TextBoxTests` | Tests for TextBox form (valid input, invalid email, empty form, XSS injection). |

### Listeners (`listeners/`)

| Class | Description |
|-------|-------------|
| `AllureScreenshotListener` | TestNG listener that captures screenshots on test failure and attaches to Allure report. |

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Playwright browsers (auto-installed)

### Installation

```bash
# Clone repository
git clone <repository-url>
cd PlaywrightJava

# Install dependencies
mvn clean install -DskipTests

# Install Playwright browsers
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=TextBoxTests

# Run specific test method
mvn test -Dtest=TextBoxTests#validateTextBox

# Run with TestNG XML
mvn test -DsuiteXmlFile=TestNg.xml
```

### Generate Allure Report

```bash
# Generate and open report
mvn allure:serve

# Generate report only
mvn allure:report
```

---

## Configuration

### Environment Properties

Create `src/test/resources/environment.properties`:

```properties
base.url=https://demoqa.com
browser=chromium
headless=false
```

### TestNG Configuration

Edit `TestNg.xml` for parallel execution:

```xml
<suite name="Test Suite" parallel="methods" thread-count="3">
    <test name="UI Tests">
        <classes>
            <class name="tests.ui.TextBoxTests"/>
            <class name="tests.ui.MainPageTests"/>
        </classes>
    </test>
</suite>
```

---

## Writing Tests

### Example Test

```java
@Test
public void validateTextBoxForm() {
    // Create test data
    TextBoxModel model = TextBoxModelBuilder.buildEmpty();
    model.setFullName("John Doe");
    model.setEmail("john@example.com");
    
    // Execute steps
    steps.textBoxSteps.fillTextBoxAndSubmit(model);
    
    // Validate
    steps.textBoxSteps.validateOutputIsDisplayed();
    steps.textBoxSteps.validateOnlyFilledFieldsDisplayed(model);
}
```

### Adding New Page

1. Create page class extending `BasePage`:

```java
public class NewPage extends BasePage {
    private final String ELEMENT_SELECTOR = "#element";
    
    @Step("Click element")
    public void clickElement() {
        element.click(ELEMENT_SELECTOR);
    }
}
```

2. Create steps class:

```java
public class NewSteps {
    NewPage newPage;
    
    @Step("Perform action")
    public void performAction() {
        newPage.clickElement();
    }
}
```

3. Register in `Steps.java`:

```java
public class Steps {
    public NewSteps newSteps;
    // ...
}
```

---

## Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Programming language |
| Playwright | 1.49.0 | Browser automation |
| TestNG | 7.10.2 | Test framework |
| Allure | 2.29.0 | Reporting |
| AssertJ | 3.26.3 | Fluent assertions |
| Lombok | 1.18.42 | Boilerplate reduction |
| JavaFaker | 1.0.2 | Test data generation |

---

## License

This project is licensed under the MIT License.

