# 🚀 TrustScore

**TrustScore** is a full-stack credit scoring web application that predicts loan eligibility based on a user’s past loans and outstanding balances.  
⚠️ This is for demonstration purposes only and **not** an official Credit Bureau statement.

---

## ✨ Features
- 📊 Predicts **loan eligibility** using a simple scoring algorithm.  
- 🔐 User authentication (JWT + MongoDB).  
- ⚡ REST API built with Spring Boot for backend logic.  
- 🗄️ Database integration with **MongoDB Atlas** (cloud hosted).  
- 🎨 Frontend built with **React.js** + CSS for a modern, responsive UI.  
- ☁️ Deployed on **AWS ECS + CloudFront + S3** with CI/CD via GitHub Actions.  

---

## 🏗️ Architecture

- **Frontend**: React.js, CSS  
- **Backend**: Java, Spring Boot  
- **Database**: MongoDB Atlas  
- **Cloud & Deployment**:  
  - AWS ECS Fargate (Backend)  
  - AWS S3 + CloudFront (Frontend)  
  - AWS ALB (Load Balancing)  
  - GitHub Actions for CI/CD  

---

## 🔑 API Endpoints

### Health Check
```http
GET /actuator/health
