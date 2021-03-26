# Projet:   Compétitions Sportives


## Author :

	-BENABDALLAH Anisse
	-Larzul Hippolyte



## Objectifs du Projets :

L'objectif du projet est de créer et simuler une compétition sportive.

La compétition peut se dérouler sous deux formes différentes :  
* Les championnats qui se jouent en matchs aller/retour et se remportent au plus grand nombre de victoires.  
* Les tournois qui se déroulent sur plusieurs tours en éliminant les perdants de chaque tour.  
* Les Master qui divise les competieurs en groupes et lance des ligues , et aprés selectione les qualifiants au phases final avec une methode prédefinie , les qualifiants joue entre eux dans un tournoi le gagnant ramporte me Master. 

* Les matchs sont joués de manière aléatoire et équilibrée, et toujours remportés par un compétiteur.

* Il ya deux methode de selection dans le Master :
   - BestSecond : qui prend les meilleurs de chaque poule plus les meilleurs deuxiemes si necessaire.
   - BestThird : qui prend les deux meilleurs de chaque poule plus les meilleurs troisiemes si necessaire.

* Les competition peuvent etre assité par des Observers , on a deux type d'observers :
   - Journaliste : assiste a tout les match d'une competition et affiches les resultats de chaque match .
   - Bookmakers : assiste a tout les match d'une competition et memorise et affcihe les cotes de chaque competiteur apres chaque match .


## Commandes Pour Génerer la documentation:

Dans la racine du projet 

```bash
javadoc competition matchs methods Observers util -cp src -d docs
```


## Compilation Des Classes :

Dans la racine du Projet lancez les commandes : 


```bash 
 javac -d classes -cp classes src/util/*.java
 javac -d classes -cp classes src/Observers/*.java src/matchs/*.java src/competition/*.java src/methods/*.java

```



## Compilation et exécution des tests

Dans la racine du Projet lancez les commandes : 

```bash
 javac -classpath test-1.7.jar tests/competition/*.java -d classes

 java -jar test-1.7.jar competition.CompetitorTests
 java -jar test-1.7.jar competition.LeagueTest
 java -jar test-1.7.jar competition.TournamentTest
 java -jar test-1.7.jar competition.MatchClassiqueTest 
 java -jar test-1.7.jar competition.MasterTest
 java -jar test-1.7.jar competition.BestSecondTest
 java -jar test-1.7.jar competition.BestThirdTest
```




## Création du jar exécutable


Dans la racine lancez les commandes : 

```bash
jar cvfm competition.jar manifest -C classes competition -C classes util -C classes methods -C classes matchs -C classes Observers
```

tout en utilisant le dossier classes déjà créer et le fichier manifest qui contient :

```bash
 Main-Class: competition.CompetitionMain
```

## Lancer le Main 


Pour lancer le resultat du main dans la racine lancez les commandes :  

```bash
java -jar competition.jar
```
qui utlise le jar déjà créer 

 ou :

```bash
java -cp classes competition.CompetitionMain
```


## Fonctionement du Projet 


L'excution du Main par default crée une liste de competiteurs et lance un Master qui crée 4 groupe et utilse la methode de selection BestSecond, le master est assité par deux obesrver journalsite et bookmaker .

Pour lancer un Tournoi assurez vous que le nombre de competiteurs est une puissance de 2 (c'est déjà le cas dans le main)
sinon une exception sera levée, et décommentez les lignes de code qui lancent le tournoi, idem pour une league .
















