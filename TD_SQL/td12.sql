SELECT titre FROM `Film`;
SELECT nom,prenom FROM `Internaute` WHERE region='auvergne';
SELECT titre,annee FROM `Film`WHERE genre='drame' ORDER BY annee ASC;
SELECT titre,annee FROM `Film`WHERE genre='drame' ORDER BY annee DESC;
SELECT nom,anneeNaiss FROM `Artiste` WHERE anneeNaiss<1950;
SELECT titre, annee FROM `Film` WHERE annee<1980 AND annee>1960; 
SELECT genre FROM `Film`; 
SELECT nom FROM `Artiste` WHERE anneeNaiss=NULL;
SELECT nom,prenom,nomrole FROM `Artiste`,`Role`WHERE `Artiste`.idArtiste=`Role`.idActeur AND Role.nomrole='Morpheus';
SELECT nom, prenom FROM Artiste, Film WHERE Artiste.idArtiste = Film.idMES AND
Film.titre = 'Alien';
SELECT DISTINCT nom, prenom, titre FROM Internaute, Notation, Film WHERE
Internaute.email=Notation.email AND Notation.idFilm=Film.idFilm AND note=4 ;
SELECT Film.titre, Role.nomRole FROM Artiste, Role, Film WHERE
Artiste.idArtiste=Role.idActeur AND Role.idFilm=Film.idFilm AND Artiste.nom='Willis'
AND Artiste.prenom='Bruce' ;
 