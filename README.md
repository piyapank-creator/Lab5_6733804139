# Forex REST API

โปรเจกต์นี้เป็น REST API ที่พัฒนาด้วย Spring Boot สำหรับจัดการข้อมูล Coffee โดยใช้ List ในหน่วยความจำ (Memory) ในการเก็บข้อมูล

## โครงสร้างโปรเจกต์

```
src
└── main
    ├── java
    │   └── com.xauusd.forex
    │       ├── controller
    │       ├── model
    │       └── service
    └── resources
```

- **controller** : รับ HTTP Request และส่ง Response กลับ
- **service** : ประมวลผล Business Logic
- **model** : เก็บโครงสร้างข้อมูล (Model)

---

## ความต้องการของระบบ

- Java 17 หรือใหม่กว่า
- Apache Maven

ตรวจสอบเวอร์ชัน

```bash
java -version
mvn -v
```

---

## วิธีรันโปรเจกต์

เปิด Command Prompt หรือ Terminal ที่โฟลเดอร์โปรเจกต์

```bash
cd forex
```

รันโปรแกรม

```bash
mvn spring-boot:run
```

หรือ

```bash
mvn clean spring-boot:run
```

หาก Build สำเร็จ ระบบจะทำงานที่

```
http://localhost:8080
```

---

## ตัวอย่างการเรียก API

### 1. ดึงข้อมูลทั้งหมด

```
GET /coffee
```

ตัวอย่าง

```
http://localhost:8080/coffee
```

---

### 2. ดึงข้อมูลตาม ID

```
GET /coffee/{id}
```

ตัวอย่าง

```
http://localhost:8080/coffee/1
```

---

### 3. เพิ่มข้อมูล

```
POST /coffee
```

Request Body

```json
{
  "name": "Latte",
  "price": 75
}
```

---

### 4. แก้ไขข้อมูล

```
PUT /coffee/{id}
```

ตัวอย่าง

```
PUT /coffee/1
```

Request Body

```json
{
  "name": "Iced Latte",
  "price": 80
}
```

---

### 5. ลบข้อมูล

```
DELETE /coffee/{id}
```

ตัวอย่าง

```
DELETE /coffee/1
```

---

## หมายเหตุ

- ข้อมูลถูกเก็บไว้ในหน่วยความจำ (Memory)
- เมื่อปิดโปรแกรมหรือ Restart Server ข้อมูลทั้งหมดจะหายไป
- หากต้องการเก็บข้อมูลถาวร ควรเชื่อมต่อฐานข้อมูล เช่น MySQL หรือ PostgreSQL