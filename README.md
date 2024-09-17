# POS System for Supermarket

Welcome to the **POS System for Supermarket** project! This Java-based application is designed to streamline point-of-sale operations in a retail environment, specifically tailored for supermarket use. Developed as part of a university Software Application Development module, this project showcases a robust and scalable solution for managing sales, inventory, and customer interactions in a supermarket setting.

## Use Case

### Purchase Transactions and Data Storing

#### Actors

- **Customer**: The individual who purchases items.
- **Supplier**: The person or entity supplying goods to the store.
- **Cashier**: The person managing the POS system and facilitating transactions.

#### Description

This use case outlines the process of a customer purchasing items at the supermarket, including applying discounts, processing payments, and printing a receipt. Additionally, it covers the process of adding stock information and updating the Goods Received Note (GRN) in the system.

#### Preconditions

- The POS system is powered on and operational.
- The cashier is logged into the system.

#### Basic Flow

**1. Item Purchasing**

- **Item Adding to the Invoice**:
  1. The cashier selects the customer from the Customer Registration or enters the customer's mobile number.
  2. The cashier adds products to the invoice table.
  3. Additional data including quantity and discounts are added.
  4. The cashier triggers the print invoice button to generate a receipt for the customer.

- **Item Adding to the GRN**:
  1. The cashier selects the supplier from Supplier Registration.
  2. Stock information and other relevant details are added.
  3. The GRN button is triggered to store the information in the database.

## Classes Used

- **SignIn**: Contains the main method and serves as the entry point. Handles user email and password input.

- **CompanyRegistration**: Manages the storage of company information, including CRUD operations and data loading from the MySQL database.

- **CustomerRegistration**: Responsible for managing customer data in the database. Provides functionality to insert, update, delete, and sort customer records. Displays data from the MySQL database.

- **EmployeeRegistration**: Stores employee information in the database. Contains a child class, `AddressView`, for managing employee addresses.

- **AddressView**: A child class of `EmployeeRegistration` used to add addresses for employees.

- **GRN**: Manages the storage of Goods Received Notes (GRN), tracking records of received stock.

- **Home**: Manages the GUI transition between the GRN and Invoice interfaces. The main class users see after logging in.

- **Invoice**: Handles the printing of invoices for customers.

- **Stock**: Maintains a record of stock levels in the database.

- **SupplierRegistration**: Manages supplier information in the database.

## Technology Stack

- **Programming Language**: Java
- **Database**: MySQL
- **Libraries/Frameworks**: 
  - MySqlConnectorJ
  - FlatLaf
  - OpenPdf
  - PDFBox
  - JasperReports
  - Stax2
- **Development Environment**: NetBeans 20, MySQL Workbench
