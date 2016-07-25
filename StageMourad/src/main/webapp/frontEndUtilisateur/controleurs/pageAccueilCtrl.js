app.controller('pageAccueilCtrl', [
		'$scope',
		'$location',
		'MsgConfig',
		'UtilisateurProperties', '$cookieStore',
		function($scope, $location, MsgConfig, UtilisateurProperties, $cookieStore) {
			
			
			if (angular.isUndefined($cookieStore.get('nom'))) {
				$location.path('/');
			} else {
			
				/* recuperation la liste des demandes disponible*/
	            $scope.listeDemandeDisponible = gererDemandeFactory1
				.get({},function(){},function(){$location.path('/errors');});
	            $scope.UtilisateurConnecterProperties = {
						nom : $cookieStore.get('nom'),
						prenom : $cookieStore.get('prenom'),
						role : $cookieStore.get('role')
					};
			};
			/* ng-click button path*/
			$scope.path = function(path){
				$location.path(path);
			}
		}]);