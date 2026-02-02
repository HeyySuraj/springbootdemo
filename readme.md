# ☕ Java Spring Boot – How It Works (Big Picture)

This README gives you a **clear mental model** of how a Java + Spring Boot application runs — from source code to serving HTTP requests. It’s designed to be **easy to read, visual, and beginner‑friendly**, while still being technically accurate.

---

## 📦 Prerequisites

Make sure these are installed:

* **Java JDK** (8 / 11 / 17)
* **Maven**

Verify installation:

```bash
java -version
mvn -version
```

Run a Spring Boot app:

```bash
mvn spring-boot:run
```

---

## 1️⃣ How a Java Program Runs (Big Picture)

Java follows a **hybrid model** — compiled **and** interpreted.

```
Source Code (.java)
        ↓ javac (compile)
Bytecode (.class)
        ↓ JVM
Machine Code (via JIT)
        ↓
Program Runs
```

👉 Java is **not purely compiled** like C/C++ and **not purely interpreted** like Python.

✨ This is why Java is called:

> **Write Once, Run Anywhere**

---

## 2️⃣ Entry Point – Where Does Java Start?

Every Java program starts from:

```java
public static void main(String[] args)
```

### In Spring Boot

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

⚠️ **Important**

* Java still starts from `main()`
* Spring Boot just **takes control inside it**

---

## 3️⃣ What Does “Compile” Mean in Java?

Compilation command:

```bash
javac DemoApplication.java
```

This converts:

```
.java  →  .class
```

### What is inside `.class`?

* **Bytecode** (NOT machine code)
* OS‑independent instructions

💡 That’s why the same `.class` file runs on:

* Windows
* Linux
* macOS

---

## 4️⃣ JVM – The Heart of Java

**JVM (Java Virtual Machine)** is like:

> 🖥️ A mini computer running inside your computer

### JVM Responsibilities

* Load `.class` files
* Convert bytecode → machine code (**JIT compiler**)
* Manage memory (**Garbage Collection**)
* Manage threads
* Execute your program

When you run:

```bash
java DemoApplication
```

What actually happens:

```
Start JVM
 → Load classes
 → Call main()
 → Run application
```

---

## 5️⃣ How Spring Boot Starts a Server 🚀

This is the magic part.

### Step‑by‑Step Startup Flow

```
1️⃣ JVM starts
2️⃣ main() is executed
3️⃣ SpringApplication.run()
4️⃣ Spring Boot:
   - Creates ApplicationContext
   - Scans components
   - Creates beans
   - Reads application.properties
5️⃣ Embedded web server starts
```

### Embedded Server 🤯

Spring Boot **bundles a web server inside the JAR**:

* Tomcat (default)
* Jetty
* Netty

So you **DO NOT install Tomcat separately**.

Inside your JAR:

```
- spring-boot
- spring-web
- tomcat-core
```

---

## 6️⃣ How Ports Work (8080 etc.)

By default:

```properties
server.port=8080
```

### What happens internally?

```
Spring Boot starts
 → Tomcat binds to port 8080
 → OS reserves port 8080
 → Java process listens
```

When you open:

```
http://localhost:8080
```

Flow:

```
Browser
 → OS
 → Port 8080
 → Java Process
 → Tomcat
 → Spring
```

---

## 7️⃣ Request Flow Inside Spring Boot

Example controller:

```java
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hi";
    }
}
```

### Request Lifecycle

```
HTTP Request
 → Tomcat
 → DispatcherServlet
 → Controller Method
 → Response
```

🧠 Everything runs **inside the JVM**.

---

## 8️⃣ What Does `java -jar app.jar` Actually Do?

Command:

```bash
java -jar demo.jar
```

### Inside the JAR

```
- .class files
- Spring Boot framework
- Embedded Tomcat
- Dependencies
- META-INF/MANIFEST.MF
```

### Manifest Entry

```
Main-Class: org.springframework.boot.loader.JarLauncher
```

### JVM Flow

```
1️⃣ JVM reads MANIFEST.MF
2️⃣ Finds Main-Class
3️⃣ Calls main()
4️⃣ Spring Boot starts
```

---

## 9️⃣ Mental Model (Easy to Remember 🧠)

Think of a Spring Boot app like this:

```
🏭 JVM         → Factory
🔌 Port        → Factory Gate
👷 Spring      → Workers
📦 Controller  → Machines
📨 Request     → Raw Material
📤 Response    → Finished Product
```

---

## ✅ Summary

* Java starts from `main()`
* JVM runs everything
* Spring Boot configures your app
* Embedded Tomcat handles HTTP
* Controllers handle requests

Once you understand this flow, **Spring Boot becomes simple and predictable** ✨

---

Happy Coding ☕🚀
