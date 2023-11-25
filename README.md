# ThreatForge Password Generator

## Introduction

Welcome to the ThreatForge Password Generator! This simple Python script allows you to generate strong and secure passwords with varying levels of complexity. Additionally, it provides a password strength assessment to help you evaluate the robustness of your passwords.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Functions](#functions)
    - [passGen()](#passgen)
    - [passStrength(passw)](#passstrengthpassw)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Installation

To use the ThreatForge Password Generator, simply clone the repository or download the `password_generator.py` file.

```bash
git clone https://github.com/ThreatForge/password-generator.git
cd password-generator
```
## Functions

### passGen()

Generates a password for the user.

    Requires: None
    Ensures: Returns a string with the new password.

### passStrength(passw)

Provides the user with the strength level of their password.

    Requires: passw - a string representing the user's password.
    Ensures: Returns a string with the strength level.

## Usage example:

```python3
# Import the ThreatForge Password Generator
import password_generator

# Generate a new password
new_password = password_generator.passGen()
print(f"Generated Password: {new_password}")

# Assess the strength of a password
password_strength = password_generator.passStrength(new_password)
print(f"Password Strength: {password_strength}")

```

## Contributors

- [Guilherme Soares](https://github.com/Guimbreon) 
## License
This ThreatForge Password Tool is licensed under the MIT. See the [LICENSE](LICENSE) file for details.
