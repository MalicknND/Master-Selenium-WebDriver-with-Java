# Master Selenium WebDriver with Java

Projet d'apprentissage base sur le cours Udemy **Selenium WebDriver: Selenium Automation Testing with Java for Beginners** de Dmitry Shyshkin.

Ce depot accompagne ma progression dans le cours **Boost Your QA Career with Selenium WebDriver and Java - No Experience Needed!**. L'objectif est de passer du test manuel au test automatise avec **Java**, **Selenium WebDriver**, **TestNG** et le modele **Page Object Model**.

## Objectifs du cours

- Apprendre les bases de Java utiles pour l'automatisation de tests.
- Comprendre Selenium WebDriver et l'automatisation d'applications web reelles.
- Identifier les elements HTML avec les locators Selenium : `id`, `linkText`, XPath, CSS selectors, etc.
- Executer des tests sur plusieurs navigateurs comme Chrome et Firefox.
- Structurer les tests avec TestNG : annotations, groupes, parametres et suites XML.
- Construire progressivement un framework d'automatisation maintenable.
- Se preparer aux entretiens QA Automation avec un projet concret a presenter.

## Technologies

- Java 21
- Maven
- Selenium WebDriver 4.44.0
- TestNG 7.12.0
- Maven Surefire Plugin 3.5.5
- ChromeDriver et FirefoxDriver via Selenium Manager

## Structure du projet

```text
.
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── com/practicetestautomation/pageObjects
│   │           ├── BasePage.java
│   │           ├── ExceptionsPage.java
│   │           ├── LoginPage.java
│   │           └── SuccessfullLoginPage.java
│   └── test
│       ├── java
│       │   └── com/practicetestautomation/tests
│       │       ├── exceptions/ExeptionsTests.java
│       │       └── login/LoginTests.java
│       └── ressources
│           └── TestSuites
│               ├── debugSuite.xml
│               ├── fullRegressionSuite.xml
│               └── smokeTestSuite.xml
└── target
    └── surefire-reports
```

## Page Object Model

Le projet utilise maintenant des page objects pour isoler les interactions Selenium des tests :

- `BasePage` : navigation, URL courante, source de page, attentes explicites et helpers d'affichage.
- `LoginPage` : ouverture de la page de login, saisie des identifiants, soumission et lecture des messages d'erreur.
- `SuccessfullLoginPage` : verification de la page apres connexion et presence du bouton `Log out`.
- `ExceptionsPage` : actions sur la page d'exemples d'exceptions Selenium.

Cette structure rend les tests plus lisibles et limite la duplication des locators et des attentes explicites.

## Tests actuellement implementes

### Login

Les tests de login ciblent :

```text
https://practicetestautomation.com/practice-test-login/
```

Scenarios couverts :

- Connexion positive avec l'utilisateur `student` et le mot de passe `Password123`.
- Verification de l'URL apres connexion.
- Verification du message de succes.
- Verification du bouton `Log out`.
- Connexion negative avec un nom d'utilisateur incorrect.
- Connexion negative avec un mot de passe incorrect.
- Verification des messages d'erreur.

### Exceptions Selenium

Les tests d'exceptions ciblent :

```text
https://practicetestautomation.com/practice-test-exceptions/
```

Scenarios couverts :

- `NoSuchElementException` : attendre l'apparition de la ligne 2 apres clic sur `Add`.
- `TimeoutException` : utiliser une attente explicite pour un element ajoute dynamiquement.
- `ElementNotInteractableException` : remplir et sauvegarder la ligne 2 apres son affichage.
- `InvalidElementStateException` : activer le champ de la ligne 1 avec `Edit`, modifier puis sauvegarder.
- `StaleElementReferenceException` : verifier la disparition des instructions apres modification de la page.

## Prerequis

Avant d'executer le projet, installer :

- Java 21 ou plus recent
- Maven
- Chrome et/ou Firefox

Verifier les versions :

```bash
java -version
mvn -version
```

## Executer les tests

Lancer la suite de regression complete :

```bash
mvn test
```

Lancer la suite smoke :

```bash
mvn test -DsuiteXmlFile=smokeTestSuite.xml
```

Lancer explicitement la suite de regression :

```bash
mvn test -DsuiteXmlFile=fullRegressionSuite.xml
```

Lancer la suite de debug :

```bash
mvn test -DsuiteXmlFile=debugSuite.xml
```

## Suites TestNG

Les suites sont configurees dans :

```text
src/test/ressources/TestSuites/
```

Le fichier `pom.xml` utilise la propriete Maven `suiteXmlFile` :

```xml
<suiteXmlFile>src/test/ressources/TestSuites/${suiteXmlFile}</suiteXmlFile>
```

Par defaut, la suite executee est :

```text
fullRegressionSuite.xml
```

Suites disponibles :

- `fullRegressionSuite.xml` : scenarios principaux de regression sur le login.
- `smokeTestSuite.xml` : tests marques avec le groupe TestNG `smoke`.
- `debugSuite.xml` : suite reduite pour lancer rapidement un test cible.

## Navigateurs

Les methodes `setUp()` acceptent un parametre TestNG `browser`.

Valeurs gerees actuellement :

- `chrome`
- `firefox`

Si une autre valeur est fournie, le test affiche un message de configuration manquante et utilise Chrome par defaut.

## Rapports

Apres execution, les rapports TestNG/Surefire sont disponibles dans :

```text
target/surefire-reports/
```

Fichiers utiles :

- `index.html`
- `emailable-report.html`
- `testng-results.xml`

## Progression prevue

- Continuer la migration des tests vers le Page Object Model.
- Centraliser la configuration des navigateurs.
- Ajouter davantage de tests fonctionnels.
- Renforcer les suites TestNG par groupes et par navigateurs.
- Nettoyer les noms de classes et fichiers contenant des fautes de frappe.
- Ameliorer la lisibilite et la maintenabilite du framework.

## Note personnelle

Ce depot sert de support pratique pendant ma formation Selenium WebDriver avec Java. Il documente mon apprentissage pas a pas : bases Java, premiers tests Selenium, suites TestNG, gestion des erreurs, execution multi-navigateurs et construction d'un framework QA Automation.
