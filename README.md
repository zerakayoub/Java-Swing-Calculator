# Java Swing Calculator

## Overview

This project is a desktop calculator application built using **Java Swing**. The program provides a graphical user interface that allows users to perform basic arithmetic operations including addition, subtraction, multiplication, and division.

The calculator was designed to demonstrate **event-driven programming**, **GUI design**, and **object-oriented principles** in Java.

---

## Features

- Interactive graphical calculator interface
- Basic arithmetic operations:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- Decimal number support
- Positive/negative number toggle
- Delete last digit functionality
- Clear/reset functionality
- Real-time equation display
- Automatic formatting of results (removes unnecessary `.0`)

---

## Technologies Used

- **Java**
- **Java Swing** (GUI framework)
- **AWT Event Handling**
- **Object-Oriented Programming**

---

## Project Structure

```
Calculator/

│
├── Main.java
├── AppFrame.java
└── Calculator.jar
```

### Main.java

The entry point of the application.

Initializes and launches the calculator window.

### AppFrame.java

Handles the main functionality of the calculator including:

- GUI layout
- Button creation
- Event handling
- Arithmetic logic
- Display formatting

---

## How It Works

The calculator uses an **event-driven architecture** where each button triggers an `ActionEvent`.

When a user presses a button, the `actionPerformed()` method determines which button was pressed and executes the appropriate logic.

Operands are stored as `double` values:

```
num1
num2
result
```

The selected operator is stored as a `char` and evaluated using a `switch` statement when the equals button is pressed.

Example:

```java
case '+':
    result = num1 + num2;
```

The result is then formatted to remove unnecessary decimal places before being displayed.

---

## Running the Application

### Compile

```bash
javac Main.java AppFrame.java
```

### Run

```bash
java Main
```

Alternatively, you can run the packaged executable:

```bash
java -jar Calculator.jar
```

---

## Example Usage

Example calculation:

```
12 + 5 = 17
```

Displayed in the interface as:

```
12+5

17
```

---

## Concepts Demonstrated

- Event-driven programming
- GUI design with Swing
- Object-oriented design
- Input validation
- State management for calculator operations

---

## Future Improvements

Possible enhancements include:

- Keyboard input support
- Scientific calculator functions
- Improved layout using Swing Layout Managers
- Memory operations (M+, M-, MR)
- History of calculations
- Dark/light theme toggle
