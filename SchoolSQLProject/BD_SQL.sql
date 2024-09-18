SELECT isbn, titre, scenariste, dessinateur, editeur FROM bd2.albums;

SELECT al.isbn, al.titre, al.scenariste, al.dessinateur, ed.nom FROM bd2.albums al, bd2.editeurs ed WHERE al.editeur = ed.id_editeur;

SELECT al.isbn, al.titre, ed.nom FROM bd2.albums al, bd2.editeurs ed WHERE al.editeur = ed.id_editeur AND ed.pays = 'be';

SELECT al.isbn, al.titre, ed.nom FROM bd2.albums al, bd2.editeurs ed WHERE ed.pays = 'be';

SELECT al.isbn, al.titre ,ed.nom FROM bd2.albums al, bd2.editeurs ed WHERE al.editeur = ed.id_editeur AND al.serie = 'Astérix' AND ed.nom != 'Dargaud';

