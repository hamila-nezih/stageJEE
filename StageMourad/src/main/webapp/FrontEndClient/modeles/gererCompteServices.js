app.factory('GererCompteFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/client/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'get'
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

app.factory('UpdateClientFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/client/:verb', {}, {
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


