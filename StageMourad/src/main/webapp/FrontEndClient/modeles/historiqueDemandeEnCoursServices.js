app.factory('HistoriqueDemandeEncoursFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb/:id', {}, {
		"get" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getHistoriqueDemandeEncours'
			}

		},
		"getHist" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getDemandeEncoursHistorique'
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