# SecureAccess: A Java-Based Secure System

**SecureAccess** is a secure authentication system built in Java, designed to provide a basic yet effective login mechanism with encryption and user role control. This project demonstrates core concepts in secure coding, password hashing, and simple UI-based authentication using Java.

> 🔒 Educational project to explore secure user authentication in Java.

---

## 📦 Features

- Java-based GUI using Swing
- Login form with input validation
- Secure user authentication
- SHA-256 password hashing
- Admin and user roles
- Basic user management via file-based storage

---

## 🖥️ Technologies Used

- Java SE (Swing for GUI)
- Java IO for file handling
- SHA-256 hashing for password security

---

## 📂 Project Structure

```
SecureAccess-A-Java-Based-Secure-System/
├── LoginForm.java          # Main login form
├── RegisterForm.java       # User registration GUI
├── SecureUtils.java        # Password hashing and utility functions
├── User.java               # User model
├── users.txt               # User database (username:hashedPassword:role)
└── README.md               # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)

### Running the Project

1. **Clone the repository**:

```bash
git clone https://github.com/ZiadMahmoud2003/SecureAccess-A-Java-Based-Secure-System.git
```

2. **Open the project** in your IDE.

3. **Compile and run** `LoginForm.java`.

4. Use the GUI to register a new user or log in.

---

## 🔐 Security Features

- Passwords are never stored in plaintext.
- User passwords are hashed using SHA-256 before being written to `users.txt`.
- Role-based login system (Admin/User).
- Input validation to reduce injection risk.

---

## 🛡️ Example User File (`users.txt`)

```
ziad:5e884898da28047151d0e56f8dc6292773603d0d6aabbddbc...
admin:6cb75f652a9b52798eb6cf2201057c73e...
```

Format:
```
username:hashedPassword:role
```

---

