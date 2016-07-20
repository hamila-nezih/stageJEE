app.factory('DemandeEncoursFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getDemandesEncours'
			}

		},
		"update" : {
			'method' : 'Put',
			'params' : {
				verb : 'update'
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

app.factory('UpdateDemandeFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb', {}, {
	
		"update" : {
			'method' : 'Put',
			'params' : {
				verb : 'update'
			}
		}
	})
});