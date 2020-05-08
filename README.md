# INF112 Robois
Simple implementation of the board game RoboRally.

[![Build Status](https://travis-ci.com/inf112-v20/Robois.svg?branch=master)](https://travis-ci.com/inf112-v20/Robois)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/34362d2c0c724fc9b1520d8c402d5465)](https://www.codacy.com/gh/inf112-v20/Robois?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v20/Robois&amp;utm_campaign=Badge_Grade)

## Project Setup

**The game requires Maven to build**

Download: `https://maven.apache.org/download.cgi`

**You will also need Java 13 to run**

### Linux/Mac

**1.** Clone the repository
```
https://github.com/inf112-v20/Robois.git
```

**2.** Build the game with dependencies
```
cd Robois
mvn clean verify assembly:single
```

**3.** Run game
```
java -jar target/mvn-app-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Windows

**1.** Intall Java IDE (etc. vs code/IntelliJ IDEA)

**2.** Import the project from `pom.xml` file using `File>New>Project from Version Control...`

**3.** Run the game with Main.java. Located in `main/java/inf112/skeleton/app

## How to Play

### Gameplay

Select cards you want to execute by clicking on the cards with your mouse. 
You can return cards by clicking on a card you previously selected.
Press on the blue arrow to confirm selection and start a game round.

### Test Controls

>**Important!:** Before test controls can be used you have to set
>
>```java
>26 | private final boolean debugging = true;
>```
>
>In the class `src/main/java/inf112.skeleton.app/Game.java`

#### Movement

- Forward: **W**
- Backward: **S**
- Turn right: **D**
- Turn left: **A**

#### Gameboard

- Run phase: **Space**
- Refresh cards: **O**


## Known bugs
Currently throws "WARNING: An illegal reflective access operation has occurred", 
when the java version used is >8. This has no effect on function or performance, and is just a warning.