# Test for HerokuApp

This repository contains the code for testing Herokuapp using gherkin syntax.

## Get the code

Git:

    git clone https://github.com/radhadeshmukh/tests-for-herokuapp
    cd tests-for-herokuapp


Or simply [download a zip](https://github.com/radhadeshmukh/tests-for-herokuapp/archive/main.zip) file.

## Use Maven

Open a command window and run:

    ./mvn test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the 
`Testrunner` class tells JUnit to kick off Cucumber.


## Using Junit to run the tests

- Import the code into an IDE like Eclipse or Netbeans.
- Right click on the project.
- Select "Run As" "Junit Test".
- The tests will start their execution.

## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.features="..." -Dcucumber.glue="..." test


## What tests are being checked?

- Dynamic loading
- Javascript alerts
- Form authentication using a combination of correct as well as incorrect username and passwords.

## Where are the feature files?

There are in total three feature files located inside `src/test/java/features` directory. These feature files are being loaded in the runner class using `@CucumberOptions` annotation. 

```
@CucumberOptions(features = {"src/test/java/features/"}, glue ="StepDefination")

```
