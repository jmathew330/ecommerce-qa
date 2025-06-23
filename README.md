# 🧪 E-Commerce Website Test Automation Project

This project is a test automation suite for the e-commerce site [Automation Exercise](https://automationexercise.com), built using **Java**, **Selenium WebDriver**, and **TestNG**. It covers core functionalities like login, logout, signup, and shopping cart behavior, following best practices in modular design and reusable page objects.

---

## 🚀 Features Tested

### 🔐 Login & Signup Module
- ✅ Login with valid credentials  
- ❌ Login with invalid credentials  
- 🔁 Logout functionality  
- ✉️ Signup with new email  
- ⚠️ Signup with existing email  
- 🔍 "Logged in as" message verification

### 🛒 Cart Module
- ➕ Add product to cart as guest  
- ➖ Remove product from cart  
- 🔁 Update product quantity and verify total price  
- 💰 Price calculation: Unit Price × Quantity = Total  
- 🚫 Guest checkout redirect to Login/Signup page  
- 🗑️ Verify cart is empty after removing all products

### 📬 Contact Us Module
- 🧾 "Get in Touch" section is present  
- ✅ Success message after submitting valid contact details

### ⭐ Product Review
- 📝 Verify success message after submitting a product review

### 📰 Subscription
- 📝 Verify success message on newsletter subscription

---

## 🔧 Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Framework:** TestNG  
- **Build Tool:** Maven  
- **Test Reporting:** ExtentReports  
- **Design Pattern:** Page Object Model (POM)  
- **IDE:** Eclipse  
- **Version Control:** Git  
- **Browser:** ChromeDriver
