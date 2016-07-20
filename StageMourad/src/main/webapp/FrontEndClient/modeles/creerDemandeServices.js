app.factory('TypeDemandeFactory', function($resource) {

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
app.factory('CreerDemandeFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/demande/:verb', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'getTypeDemand'
			},isArray:true

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

app.factory('CreerPrerequisFactory', function($resource) {

	return $resource('http://localhost:8081/stage/rest/prerequis/:verb', {}, {
		"get" : {
			'method' : 'GET',
			'params' : {
				verb : 'getTypeDemand'
			},isArray:true

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

app.service('fileUpload', ['$http','$location', function ($http,$location) {
    this.uploadFileToUrl = function(files, uploadUrl, idD, idTypeDocument){
         var file = new FormData();
        file.append('file', files);
        file.append('name', files.name);
        file.append('idD', idD);
        file.append('idTypeDocument', idTypeDocument);
     $http.post(uploadUrl,file, {
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
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);