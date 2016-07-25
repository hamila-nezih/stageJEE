app.factory('gererDemandeFactory1', function($resource) {

	return $resource('http://localhost:8081/stage/rest//utilisateur/:verb', {}, {
		"get" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getAllDemandesEnAttente'
			}

		},
		"creer" : {
			'method' : 'POST',
			'params' : {
				verb : 'create'
			}
		},
		"supprimer" : {
			'method' : 'DELETE',
			isArray : true,
			'params' : {
				verb : 'supprimer',
				id : '@id'
			}
		}
	})
});

app.service('DemandeProperties', function () {
    var libelle = '';
    var titre = '';
    var etat = '';
    var dateCreation = '';

    return {
        getDateCreation: function () {
            return dateCreation ;
        },
        setDateCreation: function(value) {
        	dateCreation = value;
        },
        getLibelle: function () {
            return libelle ;
        },
        setLibelle: function(value) {
        	libelle = value;
        },
        getTitre: function () {
            return titre;
        },
        setTitre: function(value) {
        	titre = value;
        },
        getEtat: function () {
            return etat;
        },
        setEtat: function(value) {
        	etat = value;
        }
    };
});