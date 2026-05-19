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
- ChromeDriver, FirefoxDriver via Selenium Manager

## Structure du projet

```text
.
├── pom.xml
├── src
│   └── test
│       ├── java
│       │   └── com/practicetestautomation/tests/login/LoginTests.java
│       └── ressources
│           └── TestSuites
│               ├── fullRegressionSuite.xml
│               └── smokeTestSuite.xml
└── target
    └── surefire-reports
```

## Tests actuellement implementes

Le fichier `LoginTests.java` contient les premiers tests sur la page :

```text
https://practicetestautomation.com/practice-test-login/
```

Scenarios couverts :

- Connexion positive avec l'utilisateur `student` et le mot de passe `Password123`.
- Connexion negative avec un nom d'utilisateur incorrect.
- Connexion negative avec un mot de passe incorrect.
- Verification de l'URL apres connexion.
- Verification du message de succes.
- Verification du bouton `Log out`.
- Verification des messages d'erreur.

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

## Navigateurs

La methode `setUp()` accepte un parametre TestNG `browser`.

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

- Ajouter davantage de tests fonctionnels.
- Remplacer progressivement les `Thread.sleep()` par des attentes explicites.
- Introduire le Page Object Model.
- Centraliser la configuration des navigateurs.
- Ajouter des tests cross-browser plus complets.
- Ameliorer la lisibilite et la maintenabilite du framework.

## Note personnelle

Ce depot sert de support pratique pendant ma formation Selenium WebDriver avec Java. Il documente mon apprentissage pas a pas : bases Java, premiers tests Selenium, suites TestNG, gestion des erreurs, execution multi-navigateurs et construction d'un framework QA Automation.
