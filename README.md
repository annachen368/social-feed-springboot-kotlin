# Kotlin Spring Boot Social Feed Demo

This is a demo project to practice REST API development using Spring Boot and Kotlin.

---

## How to Run

### 1. Start PostgreSQL

```bash
brew services start postgresql
psql postgres
````

Then in the `psql` prompt:

```sql
CREATE DATABASE socialfeed;
```

---

### 2. Update Database Settings

Open `src/main/resources/application.properties` and set your PostgreSQL credentials:

```properties
spring.datasource.username=your_postgres_username
spring.datasource.password=your_password_or_blank
```

---

### 3. Run the App

```bash
./mvnw spring-boot:run
```

The application will start at:

```
http://localhost:8080
```
---

### **Base URL:** `/v1/posts`
#### 1. **Get All Posts**
- **HTTP Method:** `GET`
- **Endpoint:** `/v1/posts`
- **Description:** Retrieves a list of all posts.
- **Response:** List of `Post` objects.

#### 2. **Create a New Post**
- **HTTP Method:** `POST`
- **Endpoint:** `/v1/posts`
- **Description:** Creates a new post using the data provided in the request body.
- **Request Payload Example** (`CreatePostRequest`):
``` json
     {
         "author": "Author Name",
         "content": "Post content",
         "imageUrl": "http://example.com/image.jpg"
     }
```
- **Response:** The newly created `Post` object.

#### 3. **Get a Single Post by ID**
- **HTTP Method:** `GET`
- **Endpoint:** `/v1/posts/{id}`
- **Description:** Retrieves a single post by its unique ID.
- **Path Parameter:** `id` (required, the ID of the post).
- **Response:**
    - `200 OK` with the `Post` object if the post exists.
    - `404 Not Found` if the post does not exist.

#### 4. **Update a Post**
- **HTTP Method:** `PUT`
- **Endpoint:** `/v1/posts/{id}`
- **Description:** Updates an existing post by its ID with the data provided in the request body.
- **Path Parameter:** `id` (required, the ID of the post to update).
- **Request Payload Example** (`CreatePostRequest`):
``` json
     {
         "author": "Updated Author Name",
         "content": "Updated post content",
         "imageUrl": "http://example.com/new-image.jpg"
     }
```
- **Response:**
    - `200 OK` with the updated `Post` object if the post exists.
    - `404 Not Found` if the post does not exist.

#### 5. **Delete a Post**
- **HTTP Method:** `DELETE`
- **Endpoint:** `/v1/posts/{id}`
- **Description:** Deletes a post by its ID.
- **Path Parameter:** `id` (required, the ID of the post to delete).
- **Response:**
    - `204 No Content` if the post was successfully deleted.
    - `404 Not Found` if the post does not exist.

---

### Summary of Endpoints:

| HTTP Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/v1/posts` | Get all posts |
| `POST` | `/v1/posts` | Create a new post |
| `GET` | `/v1/posts/{id}` | Get a single post by ID |
| `PUT` | `/v1/posts/{id}` | Update a post by ID |
| `DELETE` | `/v1/posts/{id}` | Delete a post by ID |
