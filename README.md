## Дипломный проект по профессии «Тестировщик»

Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка. 

### Начало работы

Открыть на ПК терминал и клонировать проект git clone git@github.com:MariyaRuban/Diplom.git

### Prerequisites

Для использования необходим браузер Google Chrome, GitHub, IntelliJ Idea, Docker Desktop


### Установка и запуск

1. Открыть проект в IntelliJ Idea
2. Запустить контейнер docker-compose up
3. Запустить приложение для СУБД mysql   java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
4. Запустить тесты   ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
5. Сформировать отчёты   ./gradlew allureReport
6. Открыть отчёт   build/reports/allure-report/allureReport/index
7. Остановить контейнер docker compose down


3. Запустить приложение для СУБД postgresql   java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
4. Запустить тесты ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
5. Сформировать отчёты ./gradlew allureReport 
6. Открыть отчёт build/reports/allure-report/allureReport/index 
7. Остановить контейнер docker compose down



### [План автоматизации тестирования](https://github.com/MariyaRuban/Diplom/tree/main/docs/Plan.md)
### [Отчёт по итогам тестирования](https://github.com/MariyaRuban/Diplom/tree/main/docs/Report.md)
### [Отчёт по итогам автоматизации](https://github.com/MariyaRuban/Diplom/tree/main/docs/Summary.md)
