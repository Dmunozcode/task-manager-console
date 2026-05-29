# Task Manager Console

A Java console application for managing tasks.  
This project is focused on practicing Java fundamentals, object-oriented programming, collections, input validation, SQL basics and a simple layered structure before moving into Spring Boot.

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

database/
├── schema.sql
└── data.sql
```

## Architecture

The project is organized into simple layers:

- `model`: contains the `Task` class and represents the data structure.
- `service`: contains the business logic and manages the task list.
- `ui`: handles console interaction, user input and messages.
- `Main`: starts the application.
- `database`: contains SQL scripts for the relational database model.

## Database Model

The project includes a basic relational database model using PostgreSQL.

### Tables

#### users

Stores application users.

| Column | Type | Description |
|---|---|---|
| id | SERIAL | Primary key |
| name | VARCHAR(100) | User name |
| email | VARCHAR(150) | Unique user email |

#### tasks

Stores tasks created by users.

| Column | Type | Description |
|---|---|---|
| id | SERIAL | Primary key |
| title | VARCHAR(100) | Task title |
| description | TEXT | Task description |
| completed | BOOLEAN | Task completion status |
| user_id | INTEGER | Foreign key referencing `users(id)` |

### Relationship

A user can have many tasks.  
Each task belongs to one user.

```text
users 1 ─── * tasks
```

### SQL Scripts

The database scripts are located in the `database` folder:

- `schema.sql`: creates the database tables and relationships.
- `data.sql`: inserts sample data.

## Example Queries

List tasks with user names:

```sql
SELECT t.id, t.title, t.completed, u.name AS user_name
FROM tasks t
JOIN users u ON t.user_id = u.id;
```

Count tasks by user:

```sql
SELECT u.id, u.name, COUNT(t.id) AS task_count
FROM users u
JOIN tasks t ON u.id = t.user_id
GROUP BY u.id, u.name;
```

## Technologies

- Java 21
- PostgreSQL
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
- SQL table design
- Primary keys and foreign keys
- Basic relational database modeling
- JOIN queries
- GROUP BY queries

## How To Run

1. Clone the repository:

```bash
git clone https://github.com/Dmunozcode/task-manager-console.git
```

2. Open the project in IntelliJ IDEA.

3. Run the `Main` class.

## Database Setup

1. Create a PostgreSQL database.

2. Run the schema script:

```bash
database/schema.sql
```

3. Insert sample data:

```bash
database/data.sql
```

## Current Limitations

- Tasks are stored in memory in the Java application.
- SQL scripts are included for practice, but the Java application is not connected to the database yet.
- Data is lost when the Java application stops.
- Task ids are entered manually by the user.

## Goal

The goal of this project is to build a clean Java console application, practice SQL database modeling and prepare the code structure for future backend development with Spring Boot.