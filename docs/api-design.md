# Task Manager REST API Design

This document describes the initial REST API design for the Task Manager application.

The API will allow clients to create, read, update and delete tasks using HTTP requests and JSON.

## Task Resource

A task is represented in JSON format:

```json
{
  "id": 1,
  "title": "Study REST",
  "description": "Learn HTTP methods and status codes",
  "completed": false,
  "priority": "HIGH",
  "createdAt": "2026-06-11"
}
```

## Get All Tasks

Returns all available tasks.

- Method: `GET`
- Endpoint: `/tasks`
- Success status: `200 OK`

### Example Response

```json
[
  {
    "id": 1,
    "title": "Study REST",
    "description": "Learn HTTP methods and status codes",
    "completed": false,
    "priority": "HIGH",
    "createdAt": "2026-06-11"
  }
]
```

## Get Task By ID

Returns a task using its identifier.

- Method: `GET`
- Endpoint: `/tasks/{id}`
- Success status: `200 OK`
- Error status: `404 Not Found`

### Example Request

```http
GET /tasks/1
```

### Example Response

```json
{
  "id": 1,
  "title": "Study REST",
  "description": "Learn HTTP methods and status codes",
  "completed": false,
  "priority": "HIGH",
  "createdAt": "2026-06-11"
}
```

## Create Task

Creates a new task.

- Method: `POST`
- Endpoint: `/tasks`
- Success status: `201 Created`
- Error status: `400 Bad Request`

### Example Request Body

```json
{
  "title": "Practice Spring Boot",
  "description": "Create a basic REST API",
  "priority": "HIGH"
}
```

### Example Response

```json
{
  "id": 2,
  "title": "Practice Spring Boot",
  "description": "Create a basic REST API",
  "completed": false,
  "priority": "HIGH",
  "createdAt": "2026-06-11"
}
```

## Update Task

Updates an existing task.

- Method: `PUT`
- Endpoint: `/tasks/{id}`
- Success status: `200 OK`
- Error status: `400 Bad Request`
- Error status: `404 Not Found`

### Example Request

```http
PUT /tasks/2
```

### Example Request Body

```json
{
  "title": "Practice Spring Boot",
  "description": "Create and test a REST API",
  "completed": true,
  "priority": "MEDIUM"
}
```

### Example Response

```json
{
  "id": 2,
  "title": "Practice Spring Boot",
  "description": "Create and test a REST API",
  "completed": true,
  "priority": "MEDIUM",
  "createdAt": "2026-06-11"
}
```

## Delete Task

Deletes a task using its identifier.

- Method: `DELETE`
- Endpoint: `/tasks/{id}`
- Success status: `204 No Content`
- Error status: `404 Not Found`

### Example Request

```http
DELETE /tasks/2
```

A successful deletion does not return a response body.

## Filter Tasks By Status

Returns tasks filtered by their completion status.

- Method: `GET`
- Endpoint: `/tasks?completed={value}`
- Success status: `200 OK`

### Example Requests

```http
GET /tasks?completed=true
```

```http
GET /tasks?completed=false
```

## Filter Tasks By Priority

Returns tasks filtered by priority.

- Method: `GET`
- Endpoint: `/tasks?priority={value}`
- Success status: `200 OK`
- Error status: `400 Bad Request`

### Example Request

```http
GET /tasks?priority=HIGH
```

Valid priority values:

- `LOW`
- `MEDIUM`
- `HIGH`

## HTTP Status Codes

| Status | Meaning |
|---|---|
| `200 OK` | The request was completed successfully |
| `201 Created` | A new task was created |
| `204 No Content` | The task was deleted successfully |
| `400 Bad Request` | The request contains invalid data |
| `404 Not Found` | The requested task does not exist |
| `500 Internal Server Error` | An unexpected server error occurred |