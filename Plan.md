# Планирование
## 1. Перечень автоматизируемых сценариев.
#### Предусловие
Валидные данные:
- Номер карты - 4444 4444 4444 4441 статус APPROVED. 4444 4444 4444 4442 статус DECLINED.
- Месяц – значение текущего месяца, цифры в формате ХХ от 01 до 12. Если Год указан больше текущего, то можно использовать любой месяц.
- Год – значение текущего года и больше в формате ХХ. От текущего и +5 лет.
- Владелец - значение латинскими буквами, допустимы пробелы и дефисы.
- CVC/CVV - 3 цифры от 001 до 999.

### Сценарии тестирования UI
Выполнить для каждого сценария по очереди:
###### 1) Открыть в браузере главную страницу сайта http://localhost:8080/
###### 2) 
* ######  а) Нажать кнопку "Купить"
* ######  б) Нажать кнопку "Купить в кредит"
###### 3) Нажать кнопку "Продолжить"

#### Проверка
1. Оплата тура картой APPROVED с использованием валидных данных   
ОР: Успешно.Операция одобрена банком

2. Оплата тура картой DECLINED с использованием валидных данных  
ОР: Ошибка! Банк отказал в проведении операции
  
3. Оплата тура картой с пустыми полями   
ОР: Форма не отправилась. Под полями высвечиваются ошибки заполнения

4. Оплата тура картой из 17 любых цифр  
ОР: Не получается ввести больше 16 цифр

5. Оплата тура картой из 15 любых цифр   
ОР: Форма не отправилась. "Неверный формат"

6. Оплата тура картой из 16 любых цифр   
ОР: Ошибка! Банк отказал в проведении операции

7. Оплата тура картой с пустым полем "Номер карты"   
ОР: Форма не отправилась. Под пустым полем высвечивается ошибки заполнения

8. Оплата тура картой с пустым полем "Месяц"   
ОР: Форма не отправилась. Под пустым полем высвечивается ошибки заполнения

9. Оплата тура картой с значением 00 в поле "Месяц"   
ОР: Ошибка! Банк отказал в проведении операции

10. Оплата тура картой с значением 13 в поле "Месяц"    
ОР: Ошибка! Банк отказал в проведении операции

11. Оплата тура картой с пустым полем "Год"    
ОР: Форма не отправилась. Под пустым полем высвечивается ошибки заполнения

12. Оплата тура картой с значением 00 в поле "Год"   
ОР: Форма не отправилась. Под полем "Год" высвечивается "Истёк срок действия"

13. Оплата тура картой с значением на 10 лет больше текущего в поле "Год"   
ОР: Форма не отправилась. Под полем "Год" высвечивается "Неверно указан срок действия карты"

14. Оплата тура картой с пустым полем "Владелец"   
ОР: Форма не отправилась. Под пустым полем высвечивается ошибки заполнения

15. Оплата тура картой с спецсимволами в поле "Владелец"   
ОР: Ошибка! Банк отказал в проведении операции

16. Оплата тура картой с 1 символом на латинице в поле "Владелец"   
ОР: Ошибка! Банк отказал в проведении операции

17. Оплата тура картой с пустым полем "CVC/CVV"   
ОР: Форма не отправилась. Под пустым полем высвечивается ошибки заполнения

18. Оплата тура картой с двумя любыми цифрами в поле "CVC/CVV"  
ОР: Форма не отправилась. Под полем "CVC/CVV" высвечивается "Неверный формат"

### Сценарии тестирования API
1. Отправка POST-запроса с валидными данными и номером карты "APPROVED".  
Ожидаемый результат: 200 OK, статус "APPROVED".

2. Отправка POST-запроса с валидными данными и номером карты "DECLINED".   
Ожидаемый результат: 200 OK, статус "DECLINED".

3. Отправка пустого POST-запроса.   
Ожидаемый результат: 400 Bad Request 

4. Отправка POST-запроса с валидными данными без номера карты.  
Ожидаемый результат: 400 Bad Request

5. Отправка POST-запроса с валидными данными без указания месяца.   
Ожидаемый результат: 400 Bad Request

6. Отправка POST- запроса с валидными данными без указания года.   
Ожидаемый результат: 400 Bad Request 

7. Отправка POST- запроса с валидными данными без указания владельца карты.  
Ожидаемый результат: 400 Bad Request 
8. Отправка POST- запроса с валидными данными без указания CVC/CVV.  
Ожидаемый результат: 400 Bad Request

## 2. Перечень используемых инструментов с обоснованием выбора.

- **IntelliJ IDEA** - среда разработки
- **Gradle** - инструмент автоматизации сборки и управления зависимостями
- **JUnit5** - платформа для написания автотестов и их запуска
- **DBeaver** - программа для работы с СУБД
- **Selenide** - фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver
- **Faker** - библиотека для генерации данных
- **Docker** - система контейнеризации
- **Allure** - инструмент построения отчётов автотестов
- **GitHub** - хранения кода, результатов тестирования

## 3. Перечень и описание возможных рисков при автоматизации.

- Технические проблемы
- Дефицит времени - человеческий фактор
- Отсутствие документации

## 4. Интервальная оценка с учётом рисков в часах.

- Планирование автоматизации тестирования - 10 часов
- Непосредственно сама автоматизация - 40 часов
- Подготовка баг-репортов и отчётных документов по итогам
  автоматизированного тестирования - 10 часов
- Подготовка отчётных документов по итогам автоматизации - 6 часа
Итого: 66 часов.

## 5. План сдачи работ: когда будут готовы автотесты, результаты их прогона.
- Планирование 03.04.2024
- Автотесты 11.04.2024
- Отчёты 12.04.2024
- Итог 15.04.2024