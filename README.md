
# Vulnerable Java App

Intentionally vulnerable Java/Spring Boot application for AppSec code review demonstrations.
DO NOT deploy. This repository is designed to help demonstrate application security code review skills. It includes examples of injection vulnerabilities and supply chain weaknesses commonly identified during AppSec reviews.

# Project Overview

Language: Java 11

Build Tool: Maven

Framework: Spring Boot (intentionally misconfigured)

Purpose: Code review & vulnerability identification

# Vulnerabilities Demonstrated

## Injection Vulnerabilities

SQL Injection: Line 20 of UserService.java file. The username variable is processed without any input validation of the SQL query which leaves the application vulnerable to an SQL injection vulnerability. In order to remediate this vulnerability, one of the following solutions should be considered: 
- Input sanitization and escaping special characters
- Allow listing
- Stored procedures

In this specific code, the "username" variable is completely controlled by the user and a threat actor could submit an SQL injection payload. 

Command Injection (Runtime.exec): Line 8 of the CommandUtil.java file. Command injection vulnerabilities allow for a threat actor to execute commands directly on the host OS which is incredibly dangerous and can lead to full takeover as well as lateral movement. These vulnerabilities should be treated of the highest priority and potential weaknesses should ideally be identified in the threat modeling phase. In addition to fixing this vulnerability, an application security team should also ensure that best practices are followed around defense in depth and principle of least privilege. In this specific code, a user supplied input is saved to a variable called "host" which isn't properly sanitized and can be executed directly. 

Expression Injection (Spring Expression Language): Line 15 of the UserController.java file. For expression language injection vulnerabilities, an attacker is able to perform remote code execution attacks when a user input is passed into an expression parser. In this specific code, a user supplied input is saved to a variable called "expression" which is passed into SpelExpressionParser(). 

Insecure Deserialization: Line 10 of the DeserializeUtil.java file. For insecure deserialization vulnerabilities, an untrusted user input can be used to abuse the logic of an applications deserialization process. Serialization involves taking the object and converting it into a format that can be stored or transmitted across a network. Deserialization is the opposite of this process and involves recreating the initial object. In this specific code, a data field is user controlled and is passed into a ByteArrayInputStream() function. 

## Supply Chain Vulnerabilities

Outdated vulnerable dependency

Dependency confusion risk

No checksum / signature verification

Overly permissive dependency versions
