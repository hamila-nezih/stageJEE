app.factory('ListeDemandeDisponibleFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/client/:verb', {}, {
		"select" : {
			'method' : 'GET',
			isArray : true,
			'params' : {
				verb : 'getTTDmd'
			}
		}
		
	})
});