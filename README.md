

---

# SpringMartX 🛍️  
**SpringMartX** is a comprehensive e-commerce application built using **Spring Boot**, **Spring Security**, and other modern technologies in the Java ecosystem. The project demonstrates how to implement an e-commerce platform with features like category-based product management, user authentication, authorization, and payment integration.  

---

## Features ✨  
### 1. **Product Management**  
   - **Category-Based Products**: Products are organized into categories, allowing for better browsing and filtering.  
   - CRUD operations for products, enabling easy management of inventory.  
   - Dynamic product listing by category for users to explore products more effectively.  

### 2. **User Authentication & Authorization**  
   - Secure user registration and login using **Spring Security**.  
   - Role-based access control (Admin and User roles):  
     - **Admin**: Manage products, categories, and user data.  
     - **User**: Browse, add to cart, and purchase products.  
   - **JWT (JSON Web Token)** implementation for secure API communication.  

### 3. **Shopping Cart**  
   - Add, update, and remove products in the cart.  
   - Persistent cart linked to the logged-in user.  

### 4. **Order Management**  
   - Place orders for items in the shopping cart.  
   - Track order details, including status and payment information.  

### 5. **Payment Integration**  
   - Integration with payment gateways to facilitate transactions.  
   - Mock payment setup to simulate real-world payment workflows.  

---

## Technologies Used 🛠️  
- **Backend Framework**: Spring Boot  
- **Security**: Spring Security with JWT Authentication  
- **Database**: MySQL for storing user, product, and order information  
- **Build Tool**: Maven  
- **REST API**: For all backend operations  
- **Validation**: Bean Validation for input validation  

---

## How to Run the Project 🚀  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/Parthkarma/SpringMartX.git  
   ```  

2. Navigate to the project directory:  
   ```bash  
   cd SpringMartX  
   ```  

3. Configure the database:  
   - Update the `application.properties` file with your MySQL database credentials.  

4. Build and run the application:  
   ```bash  
   mvn spring-boot:run  
   ```  

5. Access the application:  
   - API Documentation: `http://localhost:8080/swagger-ui.html`  
   - Frontend (if applicable): `http://localhost:8080`  

---

## API Endpoints 📡  
| Endpoint                  | Method | Description                                | Authorization |
|---------------------------|--------|--------------------------------------------|---------------|
| `/api/auth/register`      | POST   | Register a new user                        | Public        |
| `/api/auth/login`         | POST   | Login and generate JWT token               | Public        |
| `/api/products`           | GET    | Get all products                           | User/Admin    |
| `/api/products/{id}`      | GET    | Get product by ID                          | User/Admin    |
| `/api/products`           | POST   | Add a new product                          | Admin         |
| `/api/products/{id}`      | PUT    | Update product details                     | Admin         |
| `/api/products/{id}`      | DELETE | Delete a product                           | Admin         |
| `/api/categories`         | GET    | Get all categories                         | User/Admin    |
| `/api/cart`               | GET    | View the shopping cart                     | User          |
| `/api/orders`             | POST   | Place an order for the items in the cart   | User          |

---

## Future Enhancements 🔮  
- **Frontend Development**: Add a responsive UI with frameworks like React or Angular.  
- **Advanced Search**: Implement search functionality with filters and sorting.  
- **Notifications**: Send email notifications for order confirmations and updates.  
- **Admin Dashboard**: Create a dedicated admin panel for managing the platform.  

---

## Contribution Guidelines 🤝  
1. Fork the repository.  
2. Create a new feature branch:  
   ```bash  
   git checkout -b feature-name  
   ```  
3. Commit your changes:  
   ```bash  
   git commit -m "Add your message here"  
   ```  
4. Push the changes to your forked repository.  
5. Open a pull request and describe your changes.  

---


