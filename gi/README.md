# StoreAdmin

A full-stack Java store-admin dashboard built with Spring Boot, JPA, H2, and a responsive browser UI. Manage catalogue products, prices, stock, and publication state.

## Run it

Install JDK 17+ and Maven 3.9+, then run:

```powershell
mvn spring-boot:run
```

Open http://localhost:8080.

## API

- `GET /api/products`
- `GET /api/products/summary`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

Request body for creating or updating a product:

```json
{"name":"Cotton crewneck","category":"Clothing","price":49.99,"stock":20,"status":"ACTIVE"}
```

Allowed statuses are `ACTIVE` and `DRAFT`. The H2 database persists in `data/`; its web console is available at `/h2-console`.
