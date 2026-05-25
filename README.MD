# Task Manager Console

A Java console application for managing tasks.  
This project is focused on practicing Java fundamentals, object-oriented programming, collections, input validation and a basic layered structure before moving into Spring Boot.

## Features

- Add tasks
- List all tasks
- Find a task by id
- Mark a task as completed
- Delete tasks
- Validate numeric input
- Prevent empty text input

## Project Structure

```text
src/
├── Main.java
├── model/
│   └── Task.java
├── service/
│   └── TaskService.java
└── ui/
    └── Menu.java
```

## Architecture

The project is organized into simple layers:

- `model`: contains the `Task` class and represents the data structure.
- `service`: contains the business logic and manages the task list.
- `ui`: handles console interaction, user input and messages.
- `Main`: starts the application.

## Technologies

- Java 21
- IntelliJ IDEA
- Git
- GitHub

## Concepts Practiced

- Classes and objects
- Constructors
- Getters and setters
- Encapsulation
- ArrayList
- Methods
- Loops and conditionals
- Input validation
- Basic exception handling
- Layered project structure

## How To Run

1. Clone the repository:

```bash
git clone https://github.com/Dmunozcode/task-manager-console.git
```

2. Open the project in IntelliJ IDEA.

3. Run the `Main` class.

## Current Limitations

- Tasks are stored in memory.
- Data is lost when the application stops.
- There is no database connection yet.
- Task ids are entered manually by the user.

## Goal

The goal of this project is to build a clean Java console application and prepare the code structure for future backend development with SQL and Spring Boot.