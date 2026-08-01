# DevOps Fundamentals — Cognizant Digital Nurture 5.0 (Week 7)

## &#x20;Overview

This repository documents my learning from **Week 7 (DevOps)** of Cognizant's **Digital Nurture 5.0 — Java Full Stack Engineer** program. It covers the core DevOps concepts, tools, and practices that support the software delivery lifecycle for full-stack Java applications — from version control and build automation through CI/CD, containerization, and monitoring.

\---

## &#x20;What is DevOps?

DevOps is a set of practices, culture, and tooling that unifies **software development (Dev)** and **IT operations (Ops)**. Its goal is to shorten the development lifecycle while delivering features, fixes, and updates frequently and reliably — through automation, continuous feedback, and collaboration between teams.

Core pillars:

* **Culture** — shared ownership between dev and ops teams
* **Automation** — build, test, and deployment pipelines
* **Continuous Integration / Continuous Delivery (CI/CD)**
* **Monitoring \& Feedback** — observability into production systems
* **Infrastructure as Code (IaC)**

\---

## &#x20;The DevOps Lifecycle

```
Plan → Code → Build → Test → Release → Deploy → Operate → Monitor → (back to Plan)
```

|Phase|Typical Tools|
|-|-|
|Plan|Jira, Trello|
|Code|Git, GitHub|
|Build|Maven, Gradle|
|Test|JUnit, SonarQube|
|Release|Jenkins, GitHub Actions|
|Deploy|Docker, Kubernetes|
|Operate|Ansible, Terraform|
|Monitor|Prometheus, Grafana, ELK Stack|

\---

## &#x20;Version Control with Git \& GitHub

* **Git** — distributed version control system for tracking code changes
* **GitHub** — remote hosting platform for Git repositories, enabling collaboration

### Core Git Commands

```bash
git init                      # initialize a new repo
git clone <url>                # clone a remote repo
git status                     # check current state
git add .                      # stage changes
git commit -m "message"        # commit staged changes
git push origin main           # push to remote
git pull origin main           # pull latest changes
git branch feature-x           # create a branch
git checkout feature-x         # switch branch
git merge feature-x            # merge branch into current
```

### Branching Strategy (Git Flow)

* `main` — production-ready code
* `develop` — integration branch
* `feature/\*` — new features
* `release/\*` — release preparation
* `hotfix/\*` — urgent production fixes

### Best Practices

* Write clear, atomic commits
* Use `.gitignore` to exclude build artifacts, IDE files, `target/`, `node\_modules/`
* Open Pull Requests for code review before merging
* Resolve merge conflicts carefully, never force-push to shared branches

\---

## &#x20;Build Automation — Maven

Maven manages Java project builds, dependencies, and packaging via `pom.xml`.

```bash
mvn clean install     # clean, compile, test, package
mvn test               # run unit tests
mvn package            # produce .jar/.war
mvn spring-boot:run    # run a Spring Boot app
```

Key Maven lifecycle phases: `validate → compile → test → package → verify → install → deploy`

\---

## &#x20;Code Quality — SonarQube

SonarQube performs static code analysis to catch bugs, vulnerabilities, code smells, and measure test coverage before code reaches production. It's typically wired into a CI pipeline so every build gets a quality gate check.

\---

## &#x20;CI/CD — Continuous Integration \& Continuous Delivery

* **CI (Continuous Integration)** — developers merge code frequently; each merge triggers an automated build + test
* **CD (Continuous Delivery/Deployment)** — validated code is automatically prepared (and optionally deployed) to staging/production

### Example: GitHub Actions Workflow

```yaml
name: Java CI with Maven

on:
  push:
    branches: \[ "main" ]
  pull\_request:
    branches: \[ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build with Maven
        run: mvn -B clean install
      - name: Run Tests
        run: mvn test
```

### Jenkins (Pipeline as Code)

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { git 'https://github.com/user/repo.git' }
        }
        stage('Build') {
            steps { sh 'mvn clean package' }
        }
        stage('Test') {
            steps { sh 'mvn test' }
        }
        stage('Deploy') {
            steps { sh 'docker build -t myapp .' }
        }
    }
}
```

\---

## &#x20;Containerization — Docker

Docker packages an application with all its dependencies into a portable, consistent **container**.

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/myapp.jar app.jar
EXPOSE 8080
ENTRYPOINT \["java", "-jar", "app.jar"]
```

```bash
docker build -t myapp:1.0 .
docker run -p 8080:8080 myapp:1.0
docker ps                       # list running containers
docker images                   # list images
docker-compose up -d            # run multi-container apps
```

\---

## &#x20;Orchestration — Kubernetes (Basics)

Kubernetes automates deployment, scaling, and management of containerized applications across clusters.

Core objects:

* **Pod** — smallest deployable unit (one or more containers)
* **Deployment** — manages replica sets and rolling updates
* **Service** — stable network endpoint for a set of pods
* **ConfigMap / Secret** — externalized configuration and credentials

```bash
kubectl apply -f deployment.yaml
kubectl get pods
kubectl scale deployment myapp --replicas=3
kubectl rollout status deployment myapp
```

\---

## &#x20;Infrastructure as Code (IaC)

Tools like **Terraform** and **Ansible** let you define and provision infrastructure through code rather than manual setup — making environments reproducible, versioned, and auditable.

\---

## &#x20;Monitoring \& Logging

* **Prometheus + Grafana** — metrics collection and dashboarding
* **ELK Stack** (Elasticsearch, Logstash, Kibana) — centralized log aggregation and search
* **Health checks / Actuator** — Spring Boot's `/actuator/health` endpoint for liveness/readiness probes

\---

## &#x20;Key Takeaways

* DevOps bridges development and operations through automation and shared accountability
* Git/GitHub is the foundation for collaborative, version-controlled development
* Maven + SonarQube ensure builds are reliable and code stays clean
* CI/CD pipelines (Jenkins / GitHub Actions) automate testing and delivery
* Docker + Kubernetes standardize how applications are packaged, shipped, and scaled
* Monitoring closes the feedback loop, turning production insight back into planning

\---

## &#x20;About This Repo

Compiled as part of self-study to cover the **Week 7 – DevOps** module of Cognizant's **Digital Nurture 5.0 (Java Full Stack Engineer)** program, since official course materials for this week were not provided. Content is based on standard industry DevOps practices relevant to a Java full-stack workflow.

\---

## &#x20;Author

**Name:** Pratyush Kumar Mohanty
**Roll No:** 23053320
**University:** KIIT (Kalinga Institute of Industrial Technology)
**Registered Email:** pratyushmohanty12345@gmail.com

