app.controller('pageAccueilCtrl', [
		'$scope',
		'ListeDemandeDisponibleFactory',
		'$location',
		'$window',
		'$http', '$cookieStore',
		function($scope, ListeDemandeDisponibleFactory, $location, $window, $http, $cookieStore) {

			
			$cookieStore.remove('prenom');
			$cookieStore.remove('role');
			$cookieStore.remove('id');
			$cookieStore.remove('nom');
			/* recuperation la liste de type de demande disponible */
			$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
					.select({}, function(data) {
						console.log(data);

					}, function(status) {
					});
			/* callback for ng-click 'viderChampRecheche': */
			$scope.viderChampRecheche = function() {
				document.getElementById("champRechecher").value = "";
				$scope.recherche='';
			};
			/*deconnection*/
			  $http.get('j_spring_security_logout');
			/*mes demandes*/
			$scope.mesDemandes = [
					{demande : 'Demandes En Cours'},
					{demande : 'Demandes cloturées'}
			]


		} ]);
