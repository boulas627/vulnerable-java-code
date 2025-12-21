
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

SQL Injection (JDBC string concatenation)

Command Injection (Runtime.exec)

Expression Injection (Spring Expression Language)

Insecure Deserialization

## Supply Chain Vulnerabilities

Outdated vulnerable dependency

Dependency confusion risk

No checksum / signature verification

Overly permissive dependency versions
