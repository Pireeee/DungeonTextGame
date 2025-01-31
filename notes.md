## La classe Room a trop de responsabilités :
- Gestion de la grille
- Affichage
- Gestion des déplacements du joueur
- Gestion des trésors
- Elle devrait être divisée en plusieurs classes plus spécialisées


## Dans GameController.kt:
Le switch sur les commandes viole l'OCP car pour ajouter une nouvelle commande, il faut modifier la classe existante
Vous devriez le pattern Command

## Dans Dungeon.kt:
La méthode executeCommand est trop complexe avec beaucoup de conditions imbriquées. 
Elle pourrait être simplifiée en utilisant un pattern Command ou Strategy


## Dans PlayerService.kt:
La classe dépend directement de l'implémentation de Player au lieu de dépendre d'une abstraction


## Dans PlayerTest.kt:

Les tests ne couvrent pas tous les cas d'utilisation, notamment :
- Pas de tests pour les interactions avec les monstres
- Pas de tests pour la gestion de l'inventaire
- Pas de tests pour les modifications de stats

## Dans les classes de stats :
Il y a beaucoup de duplication dans la structure des stats. 
Une approche basée sur un builder ou une factory serait plus appropriée
