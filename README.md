# Spring Boot E-Commerce CRUD Application

A simple Spring Boot project demonstrating **CRUD operations** for an E-commerce system.  
This project allows you to **add, fetch, search, and order products** using REST APIs.

---

## Features

- Add new products  
- Get all products  
- Fetch product by ID  
- Search products by keyword  
- Place an order
- Uses MySQL as the database  
- JPA for ORM (Object Relational Mapping)  
- Lombok for boilerplate code reduction  

---

## Tech Stack

- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

---
## API Endpoints

| Method  | Endpoint                     | Description            |
| ------  | -----------------------------| ---------------------- |
| `POST`  | `/product`                   | Add a new product      |
| `GET`   | `/products`                  | Get all products       |
| `GET`   | `/product/{id}`              | Get product by ID      |
| `GET`   | `/products/{productId}/image`| Fetch a product from DB|
| `GET`   | `/product/search?filter`     | Search product         |
| `PUT`   | `/product/{id}`              | Update product details |
| `DELETE`| `/product/{id}`              | Delete product         |
| `POST`  | `/orders/place`              | Place an order         |
| `GET`   | `/orders`                    | Fetch all orders       |
