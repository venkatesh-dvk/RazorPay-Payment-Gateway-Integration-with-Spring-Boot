💰 Spring Boot Backend with RazorPay Integration
This repository contains a complete, functional demonstration of integrating the RazorPay payment gateway into a secure backend service built with Spring Boot and Java.

The primary purpose of this project is to showcase the essential server-side logic required for Order Creation, which is the critical first step before a payment can be initiated by the client. It also includes a simple HTML/JavaScript UI to fully test the end-to-end payment flow.

✨ Key Features
Secure Order Creation: Implements the RazorPay Order API using the official Java SDK.

Configuration Management: Securely loads API keys from application.properties using Spring's @Value.

Currency Handling: Correctly converts the amount from the major unit (e.g., ₹) to the smallest unit (paise) as required by RazorPay.

Client Interface: A simple, responsive HTML/JS page to initiate transactions and launch the RazorPay checkout popup.

🛠️ Tech Stack
| Component           | Technology                     | Description                                               |
| :------------------ | :----------------------------- | :-------------------------------------------------------- |
| **Backend**         | Java 17+, Spring Boot          | Core framework for the payment API.                       |
| **Payment Gateway** | RazorPay                       | Used for transaction processing and order management.     |
| **Frontend**        | HTML, JavaScript, Tailwind CSS | Simple, single-page application for testing the workflow. |

🚀 Getting Started
1. Prerequisites
Java Development Kit (JDK) 17+

Maven or Gradle (for dependency management)

Test RazorPay Key ID and Key Secret (available on your RazorPay dashboard).

2. Configuration
Update your src/main/resources/application.properties with your RazorPay credentials:

spring.application.name=Rayzorpay

# Replace with your actual Test Keys
razorpay.api.key="YOUR_RAZORPAY_KEY"
razorpay.api.secret="YOUR_RAZORPAY_SECRET_CODE"

3. Running the Application
Start Backend: Run the Spring Boot application using your IDE or by executing:

mvn spring-boot:run

The server will start on http://localhost:8080.

Start Frontend: Open the index.html file in your web browser.

💻 API Endpoint
The following endpoint is used to initiate the payment process by creating an order on the RazorPay server.

| Method   | Path                        | Request Parameters                  | Description                                         |
| :------- | :-------------------------- | :---------------------------------- | :-------------------------------------------------- |
| **POST** | `/api/payments/createOrder` | `amount`, `currency`, `recipientId` | Creates and returns a RazorPay Order object (JSON). |

Example Workflow
The user enters the amount on index.html and clicks "Initiate Payment".

The client-side JavaScript sends an asynchronous POST request to http://localhost:8080/api/payments/createOrder.

The Spring Boot service calls the RazorPay API, converts the amount to the smallest unit (e.g., ₹500 becomes 50000), and creates a unique order ID.

The server sends the new order_id back to the client.

The client-side RazorPay SDK uses the order_id to open the secure payment popup.

🔒 Security Note (Crucial for Production)
This demo currently handles Order Creation but NOT Payment Verification.

For any production environment, it is CRITICALLY IMPORTANT to implement a second backend API endpoint (e.g., /api/payments/verify) that verifies the razorpay_signature using the Key Secret. This step ensures that the payment confirmation received from the client is authentic and has not been tampered with.

👤 Author
Venkateshwarlu Devarakonda

https://www.linkedin.com/in/venkateshwarlu-devarakonda/

https://github.com/venkatesh-dvk
