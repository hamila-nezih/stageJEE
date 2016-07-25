app.factory('historiqueTypeDemandes', function($resource) {

	return $resource('http://localhost:8081/stage/rest/utilisateur/:verb', {}, {
		"get" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getAllHistoriqueTypeDemandes'
			}

		},
		"creer" : {
			'method' : 'POST',
			'params' : {
				verb : 'CreateTypeDemande'
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
app.factory('deleteTypeDemandeFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'deleteTypeDemande'
			}
		},
		"supprimer" : {
			'method' : 'DELETE',
			'params' : {
				verb : 'deleteTypeDemande',
				id : '@id'
			}
		}
	})
});

app.factory('getDemandeParTypeFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getDemandeParType'
			}
		},
		"download" : {
			method : 'GET',
			responseType : 'arraybuffer',
			cache : false,
			params : {
				verb : 'downloadFile'
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
