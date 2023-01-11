## Automated test project for an online bookstore <a href="https://latest.oscarcommerce.com/" target="_blank"> Oscar Sandbox</a>
The graduation paper of the Tel-Ran School testers' group. 

<a target="_blank">
  <img src="https://github.com/elenakacher/Project/blob/master/images/OscarSandbox.jpg">
</a>


### **Objective of the project:**

Automating the testing of an online bookstore. Compilation of a set of autotests for smokey testing of the first version of the website. Identification of bugs and compilation of a set of autotests for regression testing. 

The whole body of work was divided into four parts: 
- **Home Page**
- **User**
- **Product**
- **Basket**
  
My colleague and I developed the **Basket** part. You can see the test plan <a href="https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit?usp=sharing&ouid=107532909200609964385&rtpof=true&sd=true" target="_blank"> here</a>.

The work with test-suites and test-cases was carried out in the **TestLink**.

<details><summary> Mind Map for the part <b>Basket </b></summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/mindMap.jpg">
</a>

</details>

During manual testing of the first version of the website, bugs were found, which I described in detail in the **Jira** software. An example of the description can be seen <a href="https://github.com/elenakacher/Project/blob/master/images/bugReports.pdf" target="_blank"> here</a>. I found a total of 10 bugs in the Basket section. 7 of them were fixed in the final version of the site and 2 are marked as features. 

## The automation of testing was implemented using
Selenium Java Gradle IntelliJ IDEA Jenkins Jira TestLink MindMup
<p align="left"> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/selenium.svg" alt="selenium" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/java-original-wordmark.svg" alt="java" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/gradle.svg" alt="gradle" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/intellij-idea.svg" alt="IntelliJ" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jenkins-original.svg" alt="jenkins" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jira.svg" alt="jira" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/testlink.png" alt="testlink" width="50" height="50"/> </a> 
<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/MindMup.png" alt="mindmup" width="50" height="50"/> </a>

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
