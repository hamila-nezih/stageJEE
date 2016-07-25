app.controller('demandesCloturesCtrl', [
		'$scope',
		'DemandesCloturesFactory',
		'ListeDemandeDisponibleFactory',
		'fileUpload',
		'$location',
		'$http','$cookieStore',
		function($scope, DemandesCloturesFactory,ListeDemandeDisponibleFactory,
				fileUpload, $location, $http, $cookieStore) {


			/* recuperation nom et prenom*/
			$scope.ClientConnecterProperties ={
					nom : $cookieStore.get('nom'),
					prenom : $cookieStore.get('prenom')
			};
			
			/* recuperation la liste des demandes disponible*/
            $scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
			.select({}, function(data) {
			}, function(status) {

			});
			/* recuperation la liste de demande creer par le client(id=idClient) */
			$scope.demandesClotures = DemandesCloturesFactory.get({
				id : $cookieStore.get('id')
			}, function(data) {
				// selectionner le bouton radio
				console.log(data);
			}, function(status) {

			});

			/* callback for ng-click 'editDemande': */
			$scope.historique = function(DemandeId) {
				$location.path('/historique-demande/' + DemandeId);
			};

		} ]);