app.factory('typeDemandeFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/utilisateur/:verb', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'getTypeDemand'
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


app.service('typePreresuisDemandeFactory', ['$http','$location', function ($http,$location) {
    this.TypePrerequisToUrl = function(tybeVariable,libelle,ordre,obligatoire,id){
         var file = new FormData();
        file.append('tybeVariable', tybeVariable);
        file.append('libelle', libelle);
        file.append('ordre', ordre);
        file.append('obligatoire', obligatoire);
        file.append('id', id);
        var url = 'http://localhost:8081/stage/rest/utilisateur/CreateTypePrerequisDemande';
     $http.post(url,file, {
            transformRequest: angular.identity,
            headers: {'Content-Type':undefined}
        })
        .success(function(){
        	console.log("success");
        })
        .error(function(){
        	console.log("erreur");

        }); 
    }
}]);
app.service('typeDocumentDemandeFactory', ['$http','$location', function ($http,$location) {
    this.TypeDocumentToUrl = function(libelle,ordre,obligatoire,id){
         var file = new FormData();
        file.append('libelle', libelle);
        file.append('ordre', ordre);
        file.append('obligatoire', obligatoire);
        file.append('id', id);
        var url = 'http://localhost:8081/stage/rest/utilisateur/CreateTypeDocumentDemande';
     $http.post(url,file, {
            transformRequest: angular.identity,
            headers: {'Content-Type':undefined}
        })
        .success(function(){
        	console.log("success");
        })
        .error(function(){
        	console.log("erreur");

        }); 
    }
}]);