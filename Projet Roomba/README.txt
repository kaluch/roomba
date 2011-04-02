I � Bilan

Afin de respecter le cahier des charges, nous avons mod�lis� notre programme selon l�UML fourni en annexe.
Les obstacles et les taches peuvent �tre circulaires, carr�s ou rectangulaires. Ces param�tres passent par l�interface graphique ou console.
L�environnement comprend une ar�ne qui peut �tre carr� ou circulaire. Le param�trage est fait dans l�interface graphique, mais pour qu�il soit effectif en console, il doit �tre modifi� dans le code.
Le robot peut �tre carr�, circulaire ou rectangulaire et contenir des capteurs � souhait. Pour simplifier l�exercice, nous avons cr�� une classe roomba qui cr�e un roomba aux caract�ristiques du vrai roomba. Cependant il est possible de simuler un autre robot en cr�ant une nouvelle classe.
Le robot contient des capteurs qui sont de trois types : capteur de contact type poussoir, capteur de tache et capteur de distance laser. Il peuvent �tre ajout�s au robot en modifiant le code, et peuvent servir dans la mod�lisation de comportement. Il est aussi facile d�ajouter un nouveau type de capteur � partir de la classe abstraite Capteur 

II � Tester un comportement

1 � Ajouter un nouveau comportement
Afin d'�tre correctement int�gr� au projet, tout nouveau comportement doit �tre plac� dans le package "com.roomba.comportement.Comportement"
De plus, la nouvelle classe "NouveauComportement" doit �tendre la classe "com.roomba.Comportement". Cette derni�re impl�mentant Cloneable, tout nouveau comportement doit r�-impl�menter la fonction "public Object clone()".
Ceci est obligatoire afin de permettre une r�initialisation des parametres initiaux du nouveau comportement.
Pour finir, la classe "NouveauComportement" devra impl�menter la m�thode abstraite "public void calcul(ArrayList<Capteur>)", et devra pour cela importer le package "java.util.ArrayList;"

Fonctionnement d'une classe Comportement : 
Le roomba command� par un comportement appelera � chaque pas de temps la fonction "public void calcul(ArrayList<Capteur>)", celle-ci devra mettre � jour les attributs : 
"protected double iL"
"protected double iR", qui sont pr�sent dans la classe "com.roomba.comportement.Comportement". Ces deux valeurs repr�sentent l'intensit� du courant envoy� aux moteurs attribu� aux roues, respectivment Left et Right.
La vitesse des roues �tant directement proportionnelle � cette intensit�. La vitesse maximale de chaque roue est de 1m/s.

2 � Configurer le Roomba
Un nouveau comportement pouvant s'appuyer sur l'ajout de nouveau capteur, il est possible, et m�me obligatoire pour le bon fonctionnement du comportement, d'ajouter ces capteurs au roomba avant de lancer la simulation.
Pour cela, l'utilisateur devra ajouter ces lignes dans la classe "com.roomba.main.RoombaMain", dans la partie "configuration du roomba" : 
"roomba.addCapteur(new NouveauCapteur(new FormeDuCapteur(*),*);"
La classe "NouveauCapteur" devra r�pondre aux normes explicit�es dans la partie III.3. La classe "FormeDuCapteur" peut �tre soit une forme pr�-existente ("Carre","Rectangle","Cercle"), soit une nouvelle forme respectant les normes explicit�s dans la partie III.1 .
3 � Tester un comportement
Afin de tester un nouveau comportement respectant les r�gles pr�d�finies, l'utilisateur doit l'instancier dans la classe "com.roomba.main.RoombaMain", dans la partie "Instance du comportement test". le nom de la variable "comportTest" ne doit pas �tre chang� car utilis� dans la suite de la classe.

III � Ajouter des fonctionnalit�s

1 � Ajouter une nouvelle forme
Afin d'�tre correctement int�gr�e au projet, toute nouvelle forme doit �tre plac�e dans le package "com.roomba.shape".
De plus, la nouvelle classe "NouvelleForme" doit �tendre la classe "com.roomba.shape.Forme", cette derni�re impl�mentant "Cloneable", la classe "NouvelleForme" devra r�-impl�menter la fonction "public Object clone()".
Ceci est obligatoire afin de pouvoir enregistrer l'�tat initiale d'un environnement, utilis� dans l'interface graphique.
La classe NouvelleForme devra donc impl�menter l'ensemble des m�thodes abstraites de "com.roomba.shape.Forme". Voir la JavaDoc pour la fonction de chaque m�thode.

2 � Ajouter une nouvelle interface
Afin d'�tre correctement int�gr�e au projet, toute nouvelle interface �tre plac� dans le package "com.roomba.ui".
De plus, la nouvelle classe "NouvelleInterface" doit �tendre la classe "com.roomba.ui.Interface".
La classe "NouvelleInterface" doit donc impl�menter les m�thodes abstraites de la classe "com.roomba.ui.Interface". Voir la JavaDoc pour la fonction de chaque m�thode.

3 � Ajouter un nouveau capteur
Afin d'�tre correctement int�gr� au projet, tout nouveau capteur doit �tre plac� dans le package "com.roomba.robot".
De plus, la nouvelle classe "NouveauCapteur" doit �tendre la classe "com.roomba.robot.Capteur".
La classe "NouveauCapteur" doit donc impl�menter l'ensemble des m�thodes abstraites de "com.roomba.robot.Capteur". Voir la JavaDoc pour la fonction de chaque m�thode.