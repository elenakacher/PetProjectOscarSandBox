## **Automated test project for an online bookstore** <a href="https://latest.oscarcommerce.com/" target="_blank"> <b> Oscar Sandbox </b></a>
The graduation paper of the Tel-Ran School testers' group. 

<a target="_blank">
  <img src="https://github.com/elenakacher/Project/blob/master/images/OscarSandbox.jpg">
</a>


### **Objective of the project**

Automating the testing of an online bookstore. Compilation of a set of autotests for smokey testing of the first version of the website. Identification of bugs and compilation of a set of autotests for regression testing. 

### **Description**

The whole body of work was divided into four parts: 
- **Home Page**
- **User**
- **Product**
- **Basket**
  
My colleague and I developed the **Basket** part. You can see the **Test plan** <a href="https://docs.google.com/spreadsheets/d/1E53fUlBurmhZyhmSGJSuPg5L7KQCmIgu/edit?usp=sharing&ouid=107532909200609964385&rtpof=true&sd=true" target="_blank"> here</a>.

The work with test-suites and test-cases was carried out in the **TestLink**.

<details><summary> Mind Map for the part <b>Basket </b></summary>

<a target="_blank" width="50%" heidth="50%">
  <img src="https://github.com/elenakacher/Project/blob/master/images/mindMap.jpg">
</a>

</details>

## **Manual testing**
During manual testing of the first version of the website, bugs were found, which I described in detail in the **Jira** software. An example of the description can be seen <a href="https://github.com/elenakacher/Project/blob/master/images/bugReports.pdf" target="_blank"> here</a>. I found a total of 10 bugs in the Basket section. 7 of them were fixed in the final version of the site and 2 are marked as features. 

## **Automated testing**

### **UI testing**
UI testing was carried out on the Homepage, Book page and the Products page.
- Check of the broken links on the Homepage
- Check of the Breadcrumbs on Products and Book page 
- Check of defined submenu items for the Catalogue menu on the Products page
- Check of the required information on the Book page

### **Functional testing. What's special:**

- Page Object
- Parameterized assembly
- DataProvider for loading data from files
- Logger for generating reports
- Autotests are run on the Jenkins server
  
The automation of testing was implemented using:
| Selenium | Java | Gradle | IntelliJ IDEA | Jenkins | Jira | TestLink | MindMup
|--------|:-------|:-------|:-------|:-------|:-------|:-------|:-------| 
|<a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/selenium.svg" alt="selenium" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/java-original-wordmark.svg" alt="java" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/gradle.svg" alt="gradle" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/intellij-idea.svg" alt="IntelliJ" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jenkins-original.svg" alt="jenkins" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/jira.svg" alt="jira" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/testlink.png" alt="testlink" width="40" height="40"/> </a> | <a target="_blank" rel="noreferrer"> <img src="https://github.com/elenakacher/Project/blob/master/images/MindMup.png" alt="mindmup" width="40" height="40"/> </a>
