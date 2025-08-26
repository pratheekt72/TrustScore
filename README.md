# 🚀 **TrustScore**

**TrustScore** is a full-stack credit scoring web application that predicts loan eligibility based on a user’s past loans and outstanding balances.  

⚠️ This is for **demonstration purposes only** and not an official Credit Bureau statement.

---

## ✨ **Features**
- 📊 **Loan Eligibility Prediction** using a simple scoring algorithm  
- 🔐 **User Authentication** (JWT + MongoDB)  
- ⚡ **REST API** built with Spring Boot for backend logic  
- 🗄️ **Database Integration** with MongoDB Atlas (cloud hosted)  
- 🎨 **Modern Frontend** built with React.js + CSS  
- ☁️ **Deployed** on AWS ECS + CloudFront + S3 with CI/CD via GitHub Actions  

---

## 🏗️ **Architecture**
- **Frontend**: React.js, CSS  
- **Backend**: Java, Spring Boot  
- **Database**: MongoDB Atlas  
- **Cloud & Deployment**:  
  - AWS ECS Fargate (Backend)  
  - AWS S3 + CloudFront (Frontend)  
  - AWS ALB (Load Balancing)  
  - GitHub Actions (CI/CD)  

---

## 🛠️ **Installation & Setup (Local)**

### 🔹 Clone Repository

git clone https://github.com/pratheekt72/TrustScore.git

cd TrustScore
cd backend
./mvnw clean install
./mvnw spring-boot:run

cd frontend
npm install
npm start

npm run build
aws s3 sync build/ s3://trustscore-pratheek-frontend
aws cloudfront create-invalidation --distribution-id E9PTRG8LU6AOE --paths "/*"


docker build -t trustscore-backend .

aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <account-id>.dkr.ecr.us-east-1.amazonaws.com
docker tag trustscore-backend:latest <account-id>.dkr.ecr.us-east-1.amazonaws.com/trustscore-backend:latest
docker push <account-id>.dkr.ecr.us-east-1.amazonaws.com/trustscore-backend:latest


➡️ Update ECS service with new image and verify via ALB health check at **/health**.

---

## 🎥 **Demo**

### 🔹 Example Input
- **User ID**: `pthumma1`  
- **Credit Score**: `720`  
- **Income**: `$55,000`  
- **Loan Amount**: `$100,000`  
- **Employment Status**: `Employed`  

### 🔹 Example Output


---

## 📸 **Screenshots**

**Input Form**  
<img width="1684" height="902" alt="image" src="https://github.com/user-attachments/assets/38f5f4de-25d6-4185-9d2c-544a6c016842" />

**Output Form**  
<img width="1620" height="863" alt="image" src="https://github.com/user-attachments/assets/3de572e1-fa51-4a5b-b2c1-679199a9b104" />

*The purpose of the screenshots are because it costs money to keep certain important AWS Services for the project to be running 24/7. To
save money, I took screenshots of when the Project was active and running*
---

## 🚀 **Future Improvements**
- Replace simple eligibility rules with ML-based scoring models  
- Add user dashboard with credit history visualization  
- Improve authentication with refresh tokens + role-based access  
- Deploy fully on HTTPS with custom domain (Route53 + ACM)  
- Make UI mobile-friendly with React Native  

---

## 👤 **Contributors**
- [@pratheekt08](https://github.com/pratheekt08)  
- [@pratheekt72](https://github.com/pratheekt72)  

---

## 📊 **Languages**
- **Java** – 69.9%  
- **JavaScript** – 18.8%  
- **HTML** – 7.1%  
- **CSS** – 3.9%  
- **Dockerfile** – 0.3%  











