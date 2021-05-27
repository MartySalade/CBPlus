Ce projet est destiné à la candidature de stage pour l'entreprise CB+.

# Rappel de la demande :

- Rentrer une date d'expiration pour un GTIN (nuémros après le barcode)
- Afficher une liste des tous les dates d'expirations des produits du magasin
- Quand un GITN est reentré dans le magasin, l'application doit détecter que le produit existe et juste changer la date de péremption du produit existant
- Les données duy magasin ne doivent pas être persistentes quand l'application redémarre
- Design et interface graphique libre


# Produit fourni :

- Une application native respectant les points ci-dessus (codé en Java).
- Interface grpahique qui tente de respecter les principes du 'flat design'.
- Ajout d'informations sur le produit ajouté dans la liste (Nom du produit et son type (en plus de la date d'expiration et du GTIN)
- Possibilité de trier les produits dans la liste par date de péremption en affichant en premier les produits qui périment rapidement
- Possibiliter de visiter le site CB+ facilement depuis l'application

# Choix Techniques

- Utilisation d'une ListView pour afficher les différents produits. L'utilisation d'un RecyclerView aurait été plus approprié si beaucoup de produits étaient rentrés. Or comme à la fermeture de l'application, les produits disparaissent, une ListView convient pour ce projet.
- Utilisation d'un template pour chaque élément de la ListView (4 TextViews et 1 ImageView) qui viendra être rempli à chaque ajout de produit
- Utilisation d'un adapter pour transformer les données de l'Objet Product en affichage sur la View
- Utilisation de couleurs : 
  - différents teintes de vert pour le fond animé 
  - blanc / noir pour le texte et les informations à l'écran
- Utilisation de FlatIcons pour décrire les produits et pour suivre l'ambiance FlatDesign de l'application

# Perspective d'amélioration du projet :

- Modification / Suppression des produits dans la liste
- Ajout d'une base de donnée pour sauvegarder les produits même quand l'application redémarre
- Utilisation de l'appareil photo pour prendre en photo directement le produit ajouté
- Utilisation d'une GridView pour les produits permettant un affichage plus esthétique et plus poussé
