app.controller('gererDemandeCtrl', [
		'$scope',
		'$location',
		'MsgConfig',
		'gererDemandeFactory1','DemandeProperties','UtilisateurProperties', '$cookieStore',
		function($scope, $location, MsgConfig,gererDemandeFactory1,DemandeProperties,UtilisateurProperties, $cookieStore) {
			
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
			}
			
            $scope.editDemande = function(libelle, titre, etat, date, id) {		
            	DemandeProperties.setDateCreation(date);
            	DemandeProperties.setLibelle(libelle);
            	DemandeProperties.setTitre(titre);
            	DemandeProperties.setEtat(etat);
            	$location.path("/traiter-demande/"+id);
			} 

			/* ng-click button path*/
			$scope.path = function(path){
				$location.path(path);
			}
		}]);