# Laboratoire 3 : JSON -> KML
## But
- Parsing JSON (geojson)
- Création d’un fichier KML « Keyhole Markup Language »

## A faire
Le bureau d’ingénieurs dans lequel vous travaillez a reçu le mandat de mettre à disposition le démonstrateur http://geojson.io pour le format geojson. Le travail qui vous est confié consiste à mettre à disposition les classes Java nécessaires.

Sur la base de ces classes, écrire le code transformant un fichier geojson en KML utilisé par exemple par l’application GoogleEarth. L’interface utilisateur n’est pas demandée.

Pour les parsing, vous devez utiliser uniquement les classes JSON pour le parsing du fichier et JDOM2 pour l’écriture du fichier KML. Pour raccourcir le travail, nous nous contenterons de traiter les éléments présents dans le fichier countries.geojson et nécessaires à la conversion en KML. Ce fichier provient du site https://datahub.io/core/geo-countries.

Pour vérifier votre travail, prévoir l’affichage suivant lors du parsing du fichier.

```
(ABW) Aruba
    - 26 coordinates
(AIA) Anguilla
    - 24 coordinates
    - 4 coordinates
etc ...
```

GoogleEarth et le site http://geojson.io permettent de générer des fichiers KML pour vous donner une idée des éléments nécessaires à générer pour obtenir le résultat escompté.

## A rendre
- Toutes les classes de votre projet
- Le fichier KML créé
- Un rapport signé des membres du groupe contenant
    - Un descriptif des classes Java créées
    - Les principales difficultés rencontrées dans ce travail
    - Les problèmes connus et non corrigés s’il y en a
    - Une copie d’écran de l’affichage lors du parsing du fichier geojson
    - Une copie d’écran représentative après chargement de votre fichier KML dans l’ application GoogleEarth
    - Vos apprentissages
    - Conclusions
