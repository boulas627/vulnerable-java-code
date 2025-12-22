
# Code Fixes

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
## Supply Chain Vulnerabilities

In order to fix supply chain vulnerabilities, Dependabot was enabled in the repository settings and the following packages were upgraded: 
- Spring Framework
- jackson-databind

## Spring Framework
This vulnerability generally speaking has a very high liklihood of exploitation (EPSS score of > 90%) and would cause significant impact if exploitated considering that it is vulnerable to remote code execution. When it comes to this repositories code and whether or not the appliction would be vulnerable to CVE-2022-22965, the following analysis has been done to examine exploitability: 

- JDK 9 or higher. It appears as though we are running a higher version for this application
- Apache Tomcat as Servlet container. Apache Tomcat is embedded via spring boot.
- The code is packaged as a WAR. This is not the case for this application as it is being packaged as a JAR.

Because the code doesn't meet the WAR packaging requirement, this application would not be vulnerable to exploitation despite the fact that an older package is being used. In order to follow best practices and be extra careful, I will still be upgrading this package but the analysis above shows that this specific application wouldn't be vulnerable to the CVE outlined above. 


## Jackson-Databind 
This package appears to be vulnerable because of an inability to properly deserialize the data as outlined in CWE-502. Deserialization is the process of converting a set of bytes back into a fully functional Java object. This is essentially the process of rebuiliding an object and when user-controlled data is processed without the proper sanitization, a number of vulnerabilities may be present such as remote code execution or denial of service. It is likely that exploitation is possible when examining this vulnerability and because of this, it is best to upgrade the package to the necessary version.  
