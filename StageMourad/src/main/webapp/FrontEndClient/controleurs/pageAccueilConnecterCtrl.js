app.controller('pageAccueilConnecterCtrl', [
		'$scope',
		'ListeDemandeDisponibleFactory',
		'$location',
		'$cookieStore',
		function($scope, ListeDemandeDisponibleFactory, $location,$cookieStore) {
			
			/* recuperation nom et prenom*/
			$scope.ClientConnecterProperties ={
					nom : $cookieStore.get('nom'),
					prenom : $cookieStore.get('prenom')
			};

			/* recuperation la liste de type de demande disponible */
			$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
					.select({}, function(data) {
						console.log(data);

					}, function(status) {
						$location.path('/errors');
					});
			/* callback for ng-click 'viderChampRecheche': */
			$scope.viderChampRecheche = function() {
				document.getElementById("champRechecher").value = "";
			}
			/*mes demandes*/
			$scope.mesDemandes = [
					{demande : 'Demandes En Cours', lien : '#/demandes-en-cours'},
					{demande : 'Demandes cloturées', lien : '#/demandes-clotures'}
			]

		} ]);
