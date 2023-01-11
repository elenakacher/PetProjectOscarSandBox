# Automated test project for an online bookstore <a target="_blank" href="https://latest.oscarcommerce.com/"> Oscar Sandbox</a>

<a target="_blank">
  <img src="https://github.com/elenakacher/Project/blob/master/images/OscarSandbox.jpg">
</a>

The graduation paper of the Tel-Ran School testers' group. The whole body of work was divided into four parts: **Home Page, User, Product, Basket**. 
My colleague and I developed the **Basket** part. You can see the test plan <a target="_blank" href="https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit?usp=sharing&ouid=107532909200609964385&rtpof=true&sd=true"> here</a>.

<details><summary><b>Show Mind Map</b></summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/mindMap.jpg">
</a>

</details>

<details><summary><b>Show Mind Map</b></summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/mindMap.jpg">
</a>

</details>

#### List of checks implemented in the autotests:
- [x] Наличие требуемых заголовков в верхнем меню страницы
- [x] Наличие заданных пунктов подменю для меню "Молодым специалистам"
- [x] Наличие блока подписки на социальные сети в подвале сайта
- [x] Наличие имиджевого текста на первой странице
- [x] Выполнение поиска заданной вакансии. Проверка, что открылась соответствующая страница и содержимое строки поиска соответствует заданному

#### Список проверок ручного тестирования
- [x] Визуальная характеристика главной страницы сайта, соответствие единому корпоративному стилю
- [x] Адаптивность вёрстки
- [x] Соответствие вёрстки сайта общепринятым стандартам

## Проект реализован с использованием
Java Gradle IntelliJ IDEA Selenide Selenoid JUnit5 Jenkins Allure Report Allure TestOps Telegram Jira


# Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/09-ElenaSeversk-unit13/">Ссылка на проект в Jenkins</a>

### Параметры сборки

* login (default user1)
* password (default 1234)
* test_group (default ui_tests). Параметр определяет группу тестов для запуска.

### Для запуска автотестов в Jenkins
#### 1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/09-ElenaSeversk-unit13/">проект</a>

![This is an image](/design/images/jenkins1.png)

#### 2. Выбрать пункт **Собрать с параметрами**
#### 3. В случае необходимости изменить параметры, выбрав значения из выпадающих списков
#### 4. Нажать **Собрать**
#### 5. Результат запуска сборки можно посмотреть в отчёте Allure

![This is an image](/design/images/jenkins2a.png)

## Локальный запуск автотестов
Пример командной строки:
```bash
gradle clean ui_tests -Dlogin=user1 -Dpassword=1234 -DtestUrl=selenoid.autotests.cloud/wd/hub/
```

Получение отчёта:
```bash
allure serve build/allure-results
```

# Полная статистика по прохождению тестпланов, отчёты и приложения к ним хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/804">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

### Тест-планы проекта
![This is an image](/design/images/testplans.png)
### Кейсы тест-плана выполнения ручного тестирования
![This is an image](/design/images/manual.png)
### Кейсы тест-плана выполнения автотестирования
![This is an image](/design/images/auto.png)
### Общий список всех кейсов, имеющихся в системе (без разделения по тест-планам и виду выполнения тестирования)
![This is an image](/design/images/testcases.png)
### Пример dashboard с общими результатами тестирования
![This is an image](/design/images/dashboard_all.png)
### В том числе сводная статистика запусков
![This is an image](/design/images/dashboard_all2.png)

### Пример отчёта выполнения одного из автотестов
![This is an image](/design/images/onecasereport.png)
#### *После окончания выполнения автотестов по каждому из них в отчёте доступны скриншоты и исходный код страницы, лог консоли браузера и видеозапись выполнения теста.*

### Пример видеозаписи прохождения теста
![This is an image](/design/images/Video.gif)


## По результатам ручного тестирования выявлены дефекты, зафиксированные в соответствующих задачах AllureTestOps
### Тест план выполнения ручного тестирования
![This is an image](/design/images/testplan2.png)
### Сводные результаты ручного тестирования
![This is an image](/design/images/failedresult.png)
### Пример описания дефекта в Allure TestOps
![This is an image](/design/images/testops2.png)
### Список выявленных дефектов, открытых как задачи в Allure TestOps
![This is an image](design/images/defects.png)

# Результаты выполнения тестов и информация о выявленных дефектах интегрированы с Atlassian Jira
> <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-286">Ссылка на задачу в Jira</a> (запрос доступа admin@qa.guru)

Задачи на выявленные дефекты оформлены как подзадачи к данной. Связаны с соответствующими дефектами в Allure TestOps

![This is an image](/design/images/jira_n.png)

# Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](/design/images/bot.png)


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
