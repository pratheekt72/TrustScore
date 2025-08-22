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

## Installation & Setup (Local)

1. Clone Repository
   git clone https://github.com/pratheekt72/TrustScore.git
   cd TrustScore
2. Backend Setup
   cd backend

# Build & run Spring Boot
./mvnw spring-boot:run


---

## Frontend & SetUp

cd frontend

# Install dependencies
npm install

# Run dev server
npm start

How to deploy on the Frontend.

npm run build
aws s3 sync build/ s3://trustscore-pratheek-frontend
aws cloudfront create-invalidation --distribution-id E9PTRG8LU6AOE --paths "/*"

How to deploy on the backend

ssh -i counterpart.pem ubuntu@13.223.137.245

CI/CD with GitHub Actions

frontend.yml → builds React app and deploys to S3/CloudFront.

backend.yml → builds Docker image, pushes to ECR, redeploys ECS service automatically.

Author

Pratheek Thummalapalli

🌐 LinkedIn

📧 pratheekthummalapalli2023@gmail.com

