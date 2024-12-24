# PassSec: Password Security and Strength Analysis Tool

## Overview

PassSec is a Java-based application designed to evaluate password strength and generate secure passwords. It offers users an intuitive interface to:

- Test the strength of their passwords based on various criteria.
- Generate secure and robust passwords using predefined rules.

Developed under the **ThreatForge** banner, PassSec emphasizes enhancing user password security.

---

## Features

### 1. Password Strength Evaluation

The application analyzes a password's strength based on:

- Inclusion of special characters.
- Use of uppercase letters.
- Length and inclusion of numbers.

### 2. Password Generation

PassSec generates strong passwords using:

- At least 2 special characters.
- 4 numeric digits.
- 3 uppercase letters.
- Sufficient lowercase letters to meet a minimum length of 17 characters.

### 3. Interactive CLI

- Users can choose to evaluate a password or generate a new one.
- Provides feedback on password quality and suggestions for improvement.

---

## File Structure

### 1. `Main`

The entry point of the application.

- **Responsibilities**:
  - Display a menu for user interaction.
  - Handle user input to test password strength or generate a new password.
  - Provide feedback on evaluated passwords and prompt users for further actions.

### 2. `PassSec`

Extends the `Pass` class to provide enhanced password functionality.

- **Key Methods**:
  - `verify()`: Evaluates the password strength and assigns a strength level.
  - `regenPass()`: Generates a strong password based on predefined criteria.
  - `howMany(String password)`: Counts uppercase letters, special characters, and numbers in a password.
- **Strength Levels**:
  - `bad`: Very weak.
  - `good`: Acceptable but needs improvement.
  - `great`: Strong password.
  - `incredible`: Highly secure password.

### 3. `Pass`

Base class for password-related functionality.

- **Responsibilities**:
  - Handle password storage and retrieval.
  - Provide utility methods such as `getLength()` and `toString()`.
  - Support cloning and equality checks.

---

## Usage

### Running the Application

1. Compile the Java files:

    ```bash
    javac Main.java PassSec/PassSec.java PassSec/Pass.java
    ```

2. Run the application:

    ```bash
    java Main
    ```


### Menu Options

- **Option 1**: Test Password Strength

  - Enter a password to evaluate its strength.
  - Receive feedback and suggestions for improvement.
  - Optionally, generate a new password if the current one is weak.
- **Option 2**: Generate a New Password

  - Automatically generates a strong password and displays it.

---

## Password Strength Criteria

1. **Weak Passwords**:
  - Fewer than 8 characters.
  - Missing special characters or numbers.
2. **Good Passwords**:
  - Moderate length with some special characters and numbers.
3. **Strong Passwords**:
  - Longer length (12+ characters).
  - Inclusion of multiple special characters and numbers.
4. **Incredible Passwords**:
  - 15+ characters with diverse character types.

---

## Example Interaction

```
What do you wish to do?
1 - Test password strength
2 - Generate a new password
Enter your choice: 1

What's your password? myPass123!
Analyzing password strength...
Your password is good. Do you want to generate a better one?
1 - Yes
2 - No
Enter your choice: 1
Your new password is: A1b2!3c4@D5e6F7g

Do you want to:
1 - Leave
2 - Reevaluate or test another password
Enter your choice: 2
```

---

## Development Notes

- The project uses modular Java design with clear separation of concerns.
- Password generation ensures randomness and unpredictability.
- Extendable architecture allows for future enhancements, such as:
  - Storing user passwords securely.
  - Adding GUI components.

---

## License

PassSec is released under the MIT License.

---
