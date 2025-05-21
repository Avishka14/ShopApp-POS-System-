# 🧾 POS System for Supermarket

Welcome to the **POS System for Supermarket**!  
This Java-based desktop application is designed to streamline point-of-sale (POS) operations in a retail environment—specifically tailored for supermarkets.

Developed as part of a **university Software Application Development module**, this project showcases a robust and scalable solution for managing sales, inventory, suppliers, and customer interactions.

---

## 🧩 Use Case: Purchase Transactions & Data Storage

### 👥 Actors
- **Customer** – Buys items from the supermarket.
- **Supplier** – Provides goods to the store.
- **Cashier** – Operates the POS system and facilitates transactions.

### ✅ Preconditions
- POS system is powered on.
- Cashier is logged in.

### 🔁 Workflow

#### 1. 🛒 Item Purchasing
- Cashier selects the customer from the customer list or inputs their mobile number.
- Products are added to the invoice table.
- Quantity and discounts are applied.
- Cashier clicks the **Print Invoice** button to generate a receipt.

#### 2. 📦 Goods Received Note (GRN)
- Cashier selects a supplier from Supplier Registration.
- Adds stock information and other relevant details.
- Clicks the **GRN** button to store the information in the database.

---

## 📦 Classes Overview

- **`Signin`**: Entry point; handles user login via email and password.
- **`CompanyRegistration`**: Manages CRUD operations for company details.
- **`CustomerRegistration`**: Handles customer data (insert, update, delete, sort).
- **`EmployeeRegistration`**: Manages employee info; includes child class `AddressView`.
- **`AddressView`**: Adds employee addresses; child of `EmployeeRegistration`.
- **`GRN`**: Tracks and stores received stock records.
- **`Home`**: Main user interface after login; navigates to GRN or Invoice.
- **`Invoice`**: Manages customer invoice creation and printing.
- **`Stock`**: Monitors and maintains current stock levels.
- **`SupplierRegistration`**: Manages supplier data.

---

## 🛠️ Technology Stack

- **Language**: Java  
- **Database**: MySQL  
- **Libraries/Frameworks**:
  - MySQL Connector/J
  - FlatLaf
  - OpenPDF
  - Apache PDFBox
  - JasperReports
  - Stax2
- **IDE**: NetBeans 20  
- **DB Tool**: MySQL Workbench

---

## 📁 Project Structure

```
├── build.xml
├── manifest.mf
├── README.md
├── nbproject/
├── src/
│   ├── gui/
│   │   ├── AddressView.form
│   │   ├── AddressView.java
│   │   ├── CompanyRegistration.form
│   │   ├── CompanyRegistration.java
│   │   ├── CustomerRegistration.form
│   │   ├── CustomerRegistration.java
│   │   ├── EmployeeRegistration.form
│   │   ├── EmployeeRegistration.java
│   │   ├── GRN.form
│   │   ├── GRN.java
│   │   ├── Home.form
│   │   ├── Home.java
│   │   ├── Invoice.form
│   │   ├── Invoice.java
│   │   ├── Signin.form
│   │   ├── Signin.java
│   │   ├── Stock.form
│   │   └── Stock.java
│   ├── model/
│   │   └── ... (Model classes here)
│   └── reports/
│       └── ... (Jasper report files here)
```

---

## 🚀 How to Build & Run

### 1. 📥 Clone the Repository

```
git clone https://github.com/yourusername/supermarket-pos.git
```

### 2. 🧑‍💻 Open in NetBeans

- Launch **NetBeans 20**
- Open the project folder

### 3. 🛢️ Configure MySQL

- Make sure MySQL is running.
- Import or create the required database schema.
- Update DB credentials if needed.

### 4. 🔨 Build the Project

Using NetBeans or Ant:

```
ant build
```

### 5. ▶️ Run the Application

Run the main class:

```
Signin.java
```

---

## © License

&copy; Avishka14 — For academic and educational purposes only.
