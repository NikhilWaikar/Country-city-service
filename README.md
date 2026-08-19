# Country City Service

Simple Spring Boot REST API for countries and cities.

## Requirements

- Java 21
- Maven
- Git
- Postman

## Run

Application runs on:

```text
http://localhost:8080
```

## APIs

### Get Countries

```http
GET /api/v1/countries
```

### Get Cities by Country

```http
GET /api/v1/countries/{countryId}/cities?page=0&size=10
```

Example:

```http
GET /api/v1/countries/1/cities?page=0&size=2
```

### Get City Details

```http
GET /api/v1/cities/{cityId}
```

## Swagger

```text
http://localhost:8080/swagger-ui.html
```

## Data

The application uses in-memory data.

Countries:

- India
- United States
- United Kingdom

