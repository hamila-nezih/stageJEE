app.factory('TraiterDemandeFactory1', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb', {}, {
		"update" : {
			'method' : 'PUT',
			isArray : true,
			'params' : {
				verb : 'update'
			}

		}
	})
});


app.factory('PrerequisFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb/:idDmd', {}, {
		"get" : {
			'method' : 'GET',
			isArray:true , 
			'params' : {
				verb : 'getPrerequis'
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
app.factory('DocumentsFactory', function($resource) {
	return $resource('http://localhost:8081/stage/rest/demande/:verb/:idDmd', {}, {
		"get" : {
			'method' : 'GET',
			isArray:true , 
			'params' : {
				verb : 'getDocuments'
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