# README for JAVA-Collections-Files Application

## Overview

This README provides an overview of a simple Java application named `JAVA-Collections-Files`, which It is responsible for organizing the data contained in a certain file in a valid format. The order is generated from oldest to youngest by date of birth.

**Table of Contents**

[TOCM]

[TOC]

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Compilation](#compilation)
   - [Execution](#execution)
3. [Code Structure](#code-structure)
4. [Documentation](#documentation)
5. [Contributing](#contributing)
6. [License](#license)

## Introduction

The Application named `JAVA-Collections-Files` is a practical use example for managing java collections. It especially focuses on the use of the static `sort()` method of the `Collections` utility class. To do this, and as can be seen in the code, the list to be sorted must contain elements that implement the `Comparable` interface. In this case, a `person` class is created to manage the data of the file to be sorted.

## Getting Started

To get started with this Java application, follow the instructions below.

### Prerequisites

Before you can run the `JAVA-Collections-Files` program, you need to ensure that you have the Java Development Kit (JDK)  installed on your system, specifically, the Oracle OpenJDK version 20.0.2 is used. You can download and install the appropriate JDK version for your platform from the [official Java website](https://www.oracle.com/java/).

### Compilation

#### Package

Before compiling the main execution program. The package `packagePerson.person` it uses must be compiled. To compile this package you must, open a command console instance and navigate to the directory where the `person.java` file is located. Then, execute the following command:

```bash
javac -d . person.java
```

This command will compile the Java source code and generate a `person.class` file in new subdirectory `packagePerson`.

#### Main class

Once the previous package has been compiled, you can now compile the `principal.java` class. Its compilation must be done on a command console instance with the browser in the directory where the `principla.java` file is located. Then, run the following command:

```bash
javac principal.java
```

This command will compile the Java source code and generate a `principal.class` file.

### Execution

Once the codes are compiled successfully, you can run the `JAVA-Collections-Files` application using the following command:

```bash
java principal ./files/data.txt
```

Where `./files/data.txt` is the file that contains data in the format `Name*Last Name* Date of Birth` for each row of the file.

So, this command will execute the Java program, and you will see in the file `data.txt` all data in order.

##  Contributing
If you would like to contribute to this project or suggest improvements, please feel free to fork the repository, make your changes, and submit a pull request.

## License
This Java HelloWorld application is provided under the MIT License, which allows for both personal and commercial use with proper attribution. See the LICENSE file for more details.
