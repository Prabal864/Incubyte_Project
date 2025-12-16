# Sweet Shop Backend (Incubyte_Project)

🌐 Live Deployment: https://sweetshop14.netlify.app

✅ This project is live and fully hosted

Frontend: Hosted on Netlify

Backend: Hosted on Droplet in DigitalOcean

🔗 The frontend communicates securely with the backend via REST APIs using JWT authentication.

A Spring Boot–based RESTful backend for managing sweets and user authentication/authorization.  
It provides:

- User registration & login with JWT-based authentication
- Role-based access control (e.g., admin vs normal user)
- CRUD operations for sweets
- Flexible search for sweets by name, category, and price range
- Database seeding with a pre-initialized admin user
- Docker & docker-compose support

---

## 1. Tech Stack

**Backend**

- Java 17
- Spring Boot 3.x
    - Spring Web (REST)
    - Spring Data JPA
    - Spring Security
    - Bean Validation (Jakarta Validation)
- JWT (via `io.jsonwebtoken:jjwt`)
- Lombok


### Frontend
- **React 19** - UI library
- **Vite** - Build tool and dev server
- **React Router** - Client-side routing
- **Axios** - HTTP client
- **CSS3** - Styling
- **Context API** - State management

**Database**

- PostgreSQL on DigitalOcean (primary runtime DB)

**Build & Tools**

- Maven
- Docker & docker-compose


## Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **Node.js 18+** and npm
- **PostgreSQL 12+**
- A code editor (VS Code, IntelliJ IDEA, etc.)

## Installation & Setup

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Prabal864/Incubyte_Project.git
   ```
2. **Build the backend**
   ```bash
   cd backend
   mvn clean install
   ```

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd ../frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure API endpoint (if needed)**
   
   The frontend is configured to connect to `http://localhost:8090` by default. If your backend runs on a different port, update `frontend/src/services/api.js`:
   ```javascript
   const API_BASE_URL = 'http://localhost:YOUR_PORT/api';
   ```

## Running the Application

### Start the Backend

```bash
cd backend
mvn spring-boot:run
```

The backend will start on `http://localhost:8090`

### Start the Frontend

In a new terminal:

```bash
cd frontend
npm run dev
```

The frontend will start on `http://localhost:5173` (or another port if 5173 is busy)



### Default Test Credentials

**✨ New Feature:** The application automatically creates default accounts on first startup!

#### Quick Login Options
The login page features convenient one-click login buttons:

- **👑 Login as Admin**
  - Username: `admin`
  - Password: `admin`
  - Full admin privileges (create, update, delete, restock)

- **👤 Login as User**
  - Username: `user`
  - Password: `user`
  - Standard user privileges (view, search, purchase)

These accounts are automatically created by the `DataInitializer` when the application starts. See [DEFAULT_ACCOUNTS.md](DEFAULT_ACCOUNTS.md) for details.

**Alternative:** You can also register new accounts via the registration form.

---

## 2. Project Structure

High-level module layout:

- `com.micronauticals.incubyte_project`
    - `config`
        - `DataInitializer` – seeds the database (e.g., creates default admin user)
        - `SecurityConfig` – configures Spring Security & JWT
    - `controller`
        - `AuthController` – authentication & user-related endpoints
        - `SweetController` – sweets CRUD & search endpoints
    - `dto` – request/response DTOs (e.g., login/register, sweets)
    - `model` – JPA entities (e.g., `User`, `Sweet`, `Role` or similar)
    - `repository`
        - `UserRepository` – user persistence
        - `SweetRepository` – sweets persistence and custom search queries
    - `security` – JWT filters, utilities, user details service, etc.
    - `service`
        - `AuthService` – authentication & token handling
        - `SweetService` – sweets business logic
    - `IncubyteProjectApplication` – Spring Boot main class

Other important files/folders:

- `src/main/resources/application.properties` – main configuration
- `sample-data.sql` – optional extra seed data (if enabled)
- `Dockerfile` – container image definition
- `docker-compose.yml` – multi-container setup (app + DB)
- `pom.xml` – Maven dependencies and build config

---

## 3. Features

### 3.1 Authentication & Authorization

- **JWT-based stateless auth**
    - Login returns a JWT token.
    - Token must be provided in `Authorization: Bearer <token>` header.
- **User roles** (e.g., `ROLE_ADMIN`, `ROLE_USER`)
    - Admin-only endpoints (e.g., creating/deleting sweets, user management).
    - Regular users can search and view sweets; certain write operations might be restricted.

### 3.2 Admin User (Pre-initialized)

On application startup, a **DataInitializer** component creates a default admin user if it doesn’t already exist.  
Typical behavior:

- **Username**: `admin`
- **Password**: `admin` (or another configured default)
- **Role**: `ADMIN`

The initializer checks whether the admin already exists; if so, it does nothing. This makes it **idempotent** and safe across restarts.

> **Security recommendation:**  
> In production, override the default admin password via environment variable or external configuration and change it immediately after first login.

---

## 4. Configuration

### 4.1 Application Properties

Example `application.properties` configuration (simplified and with placeholders):

---


## Testing

### Backend Tests

The backend includes comprehensive unit tests following TDD principles:

```bash
cd backend
mvn test
```

Test coverage includes:
- ✅ Entity model tests (User, Sweet)
- ✅ Service layer tests (AuthService, SweetService)
- ✅ Repository integration tests
- ✅ JWT authentication tests
- ✅ Business logic validation

**Test Results:**
```
Tests run: 23, Failures: 0, Errors: 0, Skipped: 0
```

## My AI Usage

### AI Tools Used

Throughout the development of this project, I utilized **GitHub Copilot Agent** as my primary AI assistant. This tool significantly enhanced my productivity and code quality.

### How I Used AI

#### 1. **Project Structure and Boilerplate Generation**
I used GitHub Copilot Agent to help generate the initial project structure for both the Spring Boot backend and React frontend. The AI assisted in:
- Creating the Maven `pom.xml` with appropriate dependencies
- Setting up the basic Spring Boot application structure
- Generating boilerplate code for entities, repositories, and services
- Creating the React project structure with Vite

**Impact**: This saved approximately 2-3 hours of manual setup and configuration work.

#### 2. **Test-Driven Development Implementation**
Following TDD principles, I used AI to:
- Generate initial test cases for entities (User, Sweet)
- Create test scenarios for service layer methods
- Suggest edge cases and validation tests
- Help structure Mockito-based unit tests

The AI suggested comprehensive test coverage including:
- Positive test cases (happy path)
- Negative test cases (error handling)
- Edge cases (boundary conditions)

**Impact**: The AI helped ensure 100% test coverage for critical business logic and caught potential bugs early in development.


#### 5. **Frontend Development**
For the React frontend, AI helped with:
- Creating reusable component structures
- Implementing React Context for state management
- Designing the authentication flow
- Writing responsive CSS with modern design patterns
- Implementing error handling and loading states

**Impact**: Accelerated frontend development by approximately 40-50% and resulted in a polished, user-friendly interface.

#### 6. **Code Review and Refactoring**
I used AI to:
- Review code for potential improvements
- Suggest refactoring opportunities
- Identify code duplication
- Improve code readability and maintainability

**Impact**: Resulted in cleaner, more maintainable code with better separation of concerns.

#### 7. **Documentation**
AI assisted in:
- Writing comprehensive JavaDoc comments
- Creating this README file
- Documenting API endpoints
- Writing clear commit messages

**Impact**: Improved project documentation quality and saved time on writing documentation.

### My Reflection on AI Impact

**Productivity Gains:**
The use of AI tools increased my development speed by approximately 40-50%. Tasks that would typically take hours were completed in minutes, especially for boilerplate code and repetitive patterns.

**Learning Enhancement:**
Rather than replacing my thinking, AI served as a knowledgeable pair programmer. It:
- Suggested best practices I might not have known
- Provided instant examples of patterns and implementations
- Helped me understand complex concepts (like JWT implementation)
- Offered alternative approaches to problems

**Quality Improvement:**
AI helped maintain consistent code quality by:
- Suggesting proper error handling
- Recommending validation checks
- Ensuring security best practices
- Maintaining consistent coding style

**Challenges and Limitations:**
While AI was incredibly helpful, I encountered situations where:
- AI suggestions needed to be reviewed and modified
- Complex business logic required human judgment
- Integration between different components needed manual verification
- Test failures required debugging and understanding beyond AI suggestions

**Workflow Integration:**
My typical workflow became:
1. Write failing tests first (TDD red phase)
2. Use AI to generate implementation suggestions
3. Review and modify AI suggestions
4. Run tests to verify (TDD green phase)
5. Refactor with AI suggestions (TDD refactor phase)
6. Commit with clear messages (often AI-assisted)

### Conclusion

AI tools like GitHub Copilot have become an invaluable part of my development toolkit. They don't replace the need for understanding and critical thinking, but they significantly enhance productivity and code quality when used effectively. The key is to view AI as a collaborative tool that augments human creativity and problem-solving rather than a replacement for developer skills.

**Transparency Note:** All commits in this project include co-authorship attribution to acknowledge AI assistance, as per the project requirements.
 arrange them corectly for the github readme and add a note that website is lively hoeted on netlify frontend and backend on render.com rest keep same arrange them 
