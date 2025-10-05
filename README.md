# SpringBootCRUD

# Spring Boot E-Commerce CRUD Application

A simple Spring Boot project demonstrating **CRUD operations** for an E-commerce system.  
This project allows you to **add, fetch, search, and order products** using REST APIs.

---

## Features

- Add new products  
- Get all products  
- Fetch product by ID  
- Search products by name  
- Order a product  
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

## Setup and Run

### 1. Clone the repository
```bash
git clone https://github.com/Janavi-S05/SpringBootCRUD.git


| Method | Endpoint                    | Description            |
| ------ | --------------------------- | ---------------------- |
| `POST` | `/product`                 | Add a new product      |
| `GET`  | `/products`                 | Get all products       |
| `GET`  | `/product/{id}`             | Get product by ID      |
| `GET`  | `/products/{productId}/image` |  |
| `GET` | `/product/search`               | Search product by keyword |
| `POST` | `/orders`                   | Place an order         |
| `PUT` | `/product/{id}`               | Update the product details         |
| `PUT` | `/product/{id}`               | Update the product details |

