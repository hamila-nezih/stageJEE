app.factory('TypeDemandeFactory1', function($resource) {

	return $resource('http://localhost:8081/stage/rest/typeDemande/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'getTypeDemand'
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