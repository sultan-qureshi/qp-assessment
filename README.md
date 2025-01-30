# Grocery Booking API (Spring Boot)

## 📌 Overview
This is a **Java Spring Boot REST API** for a **Grocery Booking System** that allows:
- **Admin** to manage grocery inventory.
- **Users** to view and book multiple grocery items.

## 🚀 Tech Stack
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Security**
- **JDBC with H2 (in-memory) Database**
- **Lombok**
- **Swagger 3.0**

---

## 🛠️ Setup and Run

### 📝 Prerequisites
- **Java 17** installed
- **Maven** installed
- Any IDE (**IntelliJ, Eclipse, VS Code**) with Lombok support


### 🔽 1️⃣ Clone the Repository
```sh
git clone https://github.com/your-repo/grocery-booking.git
cd grocery-booking
```
### 🔨 2️⃣ Build the Project
```sh
mvn clean install 
```
### ▶️ 3️⃣ Run the Application
```sh
mvn spring-boot:run
```
### 🛢️ 4️⃣ Access H2 Console (Database)

- Open: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:grocerydb
- Username: sa
- Password: (leave empty)
- Click Connect
## 🔑 Authentication & Roles

#### Default Users:
| Role   | Username | Password    |
|--------|----------|-------------|
| Admin  | `admin`  | `admin123`  |
| User   | `user`   | `user123`   |

- **Admin APIs (`/admin/**`)** require an **Admin login**.
- **User APIs (`/user/**`)** require a **User login** or **Admin login**.
- **Swagger UI** will prompt for authentication.

## 📜 API Endpoints

#### 🛠️ Admin Endpoints (`/admin/**`)
| Method | Endpoint                                  | Description                          |
|--------|-------------------------------------------|--------------------------------------|
| `POST` | `/admin/add`                              | Add a new grocery item              |
| `GET`  | `/admin/items`                            | View all grocery items              |
| `PUT`  | `/admin/update/{id}`                      | Update grocery item details         |
| `DELETE` | `/admin/delete/{id}`                      | Remove a grocery item               |
| `PUT`  | `/admin/update-inventory/{id}?quantity=n` | Update inventory levels |

#### 🛒 User Endpoints (`/user/**`)
| Method | Endpoint                   | Description                       |
|--------|----------------------------|-----------------------------------|
| `GET`  | `/user/items`              | View available grocery items     |
| `POST` | `/user/order`              | Book multiple grocery items      |

#### 📌 Example Order Request:
```json
[
  { "id": 1, "name": "Apple", "price": 2.5, "quantity": 2 },
  { "id": 2, "name": "Milk", "price": 1.5, "quantity": 1 }
] 
```
## 📝 API Documentation (Swagger)
- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
## 📂 Project Structure
```
📦 grocery-booking ┣ 📂 src/main/java/com/example/grocerybooking ┃ ┣ 📂 controller ┃ ┃ ┣ 📜 AdminController.java ┃ ┃ ┣ 📜 UserController.java ┃ ┣ 📂 model ┃ ┃ ┣ 📜 GroceryItem.java ┃ ┃ ┣ 📜 User.java ┃ ┃ ┣ 📜 Order.java ┃ ┣ 📂 repository ┃ ┃ ┣ 📜 GroceryItemRepository.java ┃ ┃ ┣ 📜 UserRepository.java ┃ ┣ 📂 service ┃ ┃ ┣ 📜 GroceryService.java ┃ ┃ ┣ 📜 OrderService.java ┃ ┣ 📂 config ┃ ┃ ┣ 📜 SecurityConfig.java ┃ ┣ 📜 GroceryBookingApplication.java ┣ 📂 src/main/resources ┃ ┣ 📜 application.properties ┣ 📜 pom.xml ┣ 📜 README.md
```
## 📌 Future Enhancements
- ✅ Implement JWT Authentication.
- ✅ Store users in a relational database.
- ✅ Add Order History & Payment Integration.

## 👨‍💻 Author
- **Name**: ***Sultan Qureshi***
- **GitHub**: [GitHub Profile](https://github.com/sultan-qureshi)
- **LinkedIn**: [LinkedIn Profile](https://www.linkedin.com/in/sultanqureshi/)
