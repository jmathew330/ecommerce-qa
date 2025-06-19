# 🧪 E-Commerce Website Test Automation Project

This project is a test automation suite for the e-commerce site [Automation Exercise](https://automationexercise.com), built using **Java**, **Selenium WebDriver**, and **TestNG**. It covers core functionalities like login, logout, signup, and shopping cart behavior, following best practices in modular design and reusable page objects.

---

## 🚀 Features Tested

### 🔐 Login Module
- ✅ Login with valid credentials  
- ❌ Login with invalid credentials  
- ⛔ Login with blank email and password  
- 🔁 Logout functionality  
- 🔍 "Logged in as [username]" message validation

### 🛒 Cart Module
- ➕ Add product to cart as guest  
- ➖ Remove product from cart  
- 🔄 Update product quantity and verify total price  
- 💰 Price calculation validation: `Unit Price × Quantity = Total`
- 🧾 Message for guest users to log-in before checkout

---

## 🔧 Tech Stack

| Tool        | Purpose                     |
|-------------|-----------------------------|
| Java        | Programming Language        |
| Selenium    | Web UI Automation           |
| TestNG      | Test Execution Framework    |
| Maven       | Build and Dependency Tool   |
| Git         | Version Control             |
