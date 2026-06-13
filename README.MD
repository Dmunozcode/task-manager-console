# Task Manager Console

A Java console application for managing tasks using a layered architecture and in-memory storage.

This project was created to practice Java fundamentals, object-oriented programming, collections, input validation, SQL database design and REST API concepts before moving into Spring Boot.

## Features

- Add tasks with priority
- List all tasks
- Find a task by ID
- Mark tasks as completed
- Delete tasks
- Filter tasks by completion status
- Filter tasks by priority
- Automatically record the creation date
- Validate numeric input
- Prevent empty text input
- Validate priority values

## Task Properties

Each task contains:

- `id`
- `title`
- `description`
- `completed`
- `priority`: `LOW`, `MEDIUM` or `HIGH`
- `createdAt`

## Project Structure

```text
task-manager-console/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Priority.java
│   │   └── Task.java
│   ├── repository/
│   │   └── TaskRepository.java
│   ├── service/
│   │   └── TaskService.java
│   └── ui/
│       └── Menu.java
├── database/
│   ├── schema.sql
│   └── data.sql
├── docs/
│   └── api-design.md
├── .gitignore
└── README.md
```

## Architecture

The project follows a simple layered structure:

- `model`: defines the task data and priority values.
- `repository`: stores and retrieves tasks using an in-memory list.
- `service`: contains the application logic and task filters.
- `ui`: handles console input, validation and output.
- `Main`: creates the application components and starts the menu.
- `database`: contains the PostgreSQL schema and sample data.
- `docs`: contains the design of the future REST API.

The current application flow is:

```text
Menu → TaskService → TaskRepository → List<Task>
```

This structure prepares the project for a future migration to:

```text
REST Controller → TaskService → Repository → PostgreSQL
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
- Encapsulation
- Getters and setters
- Enums
- `LocalDate`
- `List` and `ArrayList`
- Streams and filters
- Methods, loops and conditionals
- Input validation
- Basic exception handling
- Layered architecture
- Repository pattern
- Dependency injection through constructors
- SQL table design
- Primary and foreign keys
- `JOIN` and `GROUP BY`
- REST API design
- HTTP methods and status codes
- JSON representation

## Database Model

The project includes a relational database model designed for PostgreSQL.

### Users

Stores application users.

| Column | Type | Description |
|---|---|---|
| id | SERIAL | Primary key |
| name | VARCHAR(100) | User name |
| email | VARCHAR(150) | Unique user email |

### Tasks

Stores tasks associated with users.

| Column | Type | Description |
|---|---|---|
| id | SERIAL | Primary key |
| title | VARCHAR(100) | Task title |
| description | TEXT | Task description |
| completed | BOOLEAN | Task completion status |
| user_id | INTEGER | Foreign key referencing `users(id)` |

### Relationship

A user can have many tasks, while each task belongs to one user.

```text
users 1 ─── * tasks
```

## SQL Scripts

The `database` folder contains:

- `schema.sql`: creates the tables and their relationship.
- `data.sql`: inserts sample users and tasks.

Example query to list tasks with their users:

```sql
SELECT t.id, t.title, t.completed, u.name AS user_name
FROM tasks t
JOIN users u ON t.user_id = u.id;
```

Example query to count tasks by user:

```sql
SELECT u.id, u.name, COUNT(t.id) AS task_count
FROM users u
JOIN tasks t ON u.id = t.user_id
GROUP BY u.id, u.name;
```

## REST API Design

The `docs/api-design.md` file documents the planned REST API, including:

- `GET /tasks`
- `GET /tasks/{id}`
- `POST /tasks`
- `PUT /tasks/{id}`
- `DELETE /tasks/{id}`
- Filtering by status
- Filtering by priority
- JSON examples
- HTTP status codes

The REST API is currently documented but not yet implemented.

## How To Run

1. Clone the repository:

```bash
git clone https://github.com/Dmunozcode/task-manager-console.git
```

2. Open the project in IntelliJ IDEA.

3. Make sure Java 21 is configured as the project SDK.

4. Run the `Main` class.

## Database Setup

1. Install PostgreSQL.
2. Create a database for the project.
3. Run `database/schema.sql`.
4. Run `database/data.sql`.

The Java console application is not connected to PostgreSQL yet. The SQL scripts currently demonstrate database design and queries.

## Current Limitations

- Tasks are stored in memory.
- Data is lost when the application stops.
- Task IDs are entered manually.
- PostgreSQL is not connected to the Java application yet.
- The REST API is designed but not implemented.
- Automated tests have not been added yet.

## Future Improvements

- Generate task IDs automatically
- Prevent duplicate IDs
- Add more domain validation
- Add automated tests
- Build the REST API with Spring Boot
- Connect the application to PostgreSQL
- Persist tasks using Spring Data JPA

## Goal

The goal of this project is to build a clean and understandable Java application while preparing its architecture and data model for future backend development with Spring Boot and PostgreSQL.