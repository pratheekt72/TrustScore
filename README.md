TrustScore

TrustScore is a full-stack credit scoring web application that predicts loan eligibility based on a user’s past loans and outstanding balances.

⚠️ This is for demonstration purposes only and not an official Credit Bureau statement.

✨ Features

📊 Predicts loan eligibility using a simple scoring algorithm.

🔐 User authentication (JWT + MongoDB).

⚡ REST API built with Spring Boot for backend logic.

🗄️ Database integration with MongoDB Atlas (cloud hosted).

🎨 Frontend built with React.js + CSS for a modern, responsive UI.

☁️ Deployed on AWS ECS + CloudFront + S3 with CI/CD via GitHub Actions.

🏗️ Architecture

Frontend: React.js, CSS

Backend: Java, Spring Boot

Database: MongoDB Atlas

Cloud & Deployment:

AWS ECS Fargate (Backend)

AWS S3 + CloudFront (Frontend)

AWS ALB (Load Balancing)

GitHub Actions (CI/CD)

🛠️ Installation & Setup (Local)
1. Clone Repository
git clone https://github.com/pratheekt72/TrustScore.git
cd TrustScore

2. Backend Setup
cd backend
./mvnw clean install
./mvnw spring-boot:run


Backend will be available at: http://localhost:8080

3. Frontend Setup
cd frontend
npm install
npm start


Frontend will be available at: http://localhost:3000

☁️ Deployment
Frontend → AWS S3 + CloudFront
npm run build
aws s3 sync build/ s3://trustscore-pratheek-frontend
aws cloudfront create-invalidation --distribution-id E9PTRG8LU6AOE --paths "/*"

Backend → AWS ECS (Fargate)
docker build -t trustscore-backend .

aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <account-id>.dkr.ecr.us-east-1.amazonaws.com
docker tag trustscore-backend:latest <account-id>.dkr.ecr.us-east-1.amazonaws.com/trustscore-backend:latest
docker push <account-id>.dkr.ecr.us-east-1.amazonaws.com/trustscore-backend:latest


Update ECS service with new image and verify via ALB health check at /health.

🎥 Demo
Example Input

User ID: pthumma1

Credit Score: 720

Income: $55,000

Loan Amount: $100,000

Employment Status: Employed

Example Output
User pthumma1: Eligible for loan ✅


📸 Screenshots:

Input Form
<img width="1684" height="902" alt="image" src="https://github.com/user-attachments/assets/38f5f4de-25d6-4185-9d2c-544a6c016842" />

Output Form
<img width="1620" height="863" alt="image" src="https://github.com/user-attachments/assets/3de572e1-fa51-4a5b-b2c1-679199a9b104" />







