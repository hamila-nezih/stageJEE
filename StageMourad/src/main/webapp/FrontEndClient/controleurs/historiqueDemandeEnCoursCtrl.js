app.controller('historiqueDemandeEnCoursCtrl', [
		'$scope',
		'$location',
		'ListeDemandeDisponibleFactory',
		'HistoriqueDemandeEncoursFactory',
		'MsgConfig',
		'$cookieStore', '$routeParams',
		function($scope, $location, ListeDemandeDisponibleFactory,
				HistoriqueDemandeEncoursFactory, MsgConfig, $cookieStore, $routeParams) {
			
			/* recuperation nom et prenom*/
			$scope.ClientConnecterProperties ={
					nom : $cookieStore.get('nom'),
					prenom : $cookieStore.get('prenom')
			};
			/* recuperation la liste de type de demande disponible */
			$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
					.select({}, function(data) {}, function(status) {});
			$scope.idDemande = $routeParams.id ;
			$scope.idTyDemande = $routeParams.idType ;
			/* recuperation le type et la date de creation de la  demande  */
			$scope.demande = HistoriqueDemandeEncoursFactory
					.get({ id :$routeParams.id }, function(data) {
						console.log(data);
					}, function(status) {
						console.log("erreur");
					});
			
			/* recuperation le type et la date de creation de la  demande  */
			$scope.HistoriqueDemande = HistoriqueDemandeEncoursFactory
					.getHist({ id :$routeParams.id }, function(data) {
						console.log(data);
					}, function(status) {
						console.log("erreur");
					});
			$scope.demandeEncours = function(idDemande, idTypDemande) {
				$location.path('/demande/'+idDemande+"/"+idTypDemande);
			
			};
		}
		
		]);