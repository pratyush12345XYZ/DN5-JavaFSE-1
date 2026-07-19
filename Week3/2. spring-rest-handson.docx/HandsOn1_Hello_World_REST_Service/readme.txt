# Spring REST - HTTP Request & Response

## Name
Pratyush Kumar Mohanty

## Roll Number
23053320

## Module
Spring REST using Spring Boot

## Topic
HTTP Request & HTTP Response

---

# Objective

In this section, I learned the fundamentals of HTTP communication and how RESTful web services use the HTTP protocol to exchange data between a client and a server.

---

# What I Learned

## HTTP Request

An HTTP Request is sent by the client (Browser, Postman, Mobile App, etc.) to the server requesting a resource.

Example:

GET /hello.txt HTTP/1.1
Host: www.example.com
User-Agent: Chrome
Accept: text/html

### Components

- HTTP Method (GET, POST, PUT, DELETE)
- Resource URL
- HTTP Version
- Request Headers
- Request Body (for POST/PUT)

---

## HTTP Response

An HTTP Response is sent by the server after processing the request.

Example:

HTTP/1.1 200 OK
Content-Type: text/plain

Hello World!!

### Components

- HTTP Version
- Status Code
- Status Message
- Response Headers
- Response Body

---

# Common HTTP Methods

| Method | Purpose |
|---------|----------|
| GET | Retrieve data |
| POST | Create data |
| PUT | Update data |
| DELETE | Delete data |

---

# Common HTTP Status Codes

| Code | Meaning |
|------|---------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Internal Server Error |

---

# Common Content Types

- text/plain
- text/html
- application/json
- image/png

---

# What is REST?

REST (Representational State Transfer) is an architectural style used for developing web services.

Features:

- Lightweight
- Scalable
- Stateless
- Client-Server Architecture
- Uses HTTP Protocol

---

# Client-Server Flow

Client
   |
HTTP Request
   |
Server
   |
Process Request
   |
HTTP Response
   |
Client

---

# Browser Developer Tools

To inspect HTTP requests and responses:

1. Open Google Chrome
2. Press F12
3. Open Network Tab
4. Refresh the page
5. Select any request
6. Observe:
   - General
   - Request Headers
   - Response Headers

---

# Sample Java Snippet

Although this section is theory-only, a simple Spring REST endpoint looks like this:

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }
}
```

This controller receives a GET request at `/hello` and returns a simple text response.

---

# Conclusion

This section provided an understanding of how HTTP Request and HTTP Response work, how RESTful services communicate over HTTP, and how browser developer tools can be used to inspect network requests before implementing REST APIs in Spring Boot.