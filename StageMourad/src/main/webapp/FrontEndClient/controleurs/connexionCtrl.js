app.controller('connexionCtrl', [
		'$scope',
		'$location',
		'ListeDemandeDisponibleFactory',
		'ConnexionFactory',
		'MsgConfig','$http', '$cookieStore',
		function($scope, $location, ListeDemandeDisponibleFactory,
				ConnexionFactory, MsgConfig, $http, $cookieStore) {
		
			/* recuperation la liste de type de demande disponible */
			$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
					.select({}, function(data) {
					}, function(status) {
					});

			/* callback for 'message' */
			$scope.msg = MsgConfig;

			$scope.erreur = false;
			$scope.login = '';
			$scope.password = '';
			$cookieStore.remove('prenom');
			$cookieStore.remove('role');
			$cookieStore.remove('id');
			$cookieStore.remove('nom');
			/*
			 * callback connexion
			 */
			$scope.connexion = function() {
				var data = "j_username="+$scope.login+"&j_password="+$scope.password+"&submit=Login";
				$http.post('j_spring_security_check', data, {
					  headers: {
					    'Content-Type': 'application/x-www-form-urlencoded',
					  }
				}).success(function(data, status, headers, config) {
					console.log("success", data);
					ConnexionFactory.get({
						login : $scope.login,
						password : $scope.password
					}, function(data) {
						if (data.length == 0) {
							$scope.erreur = true;
						} else{
							$cookieStore.put('nom',data[0]['nom']);
							$cookieStore.put('prenom',data[0]['prenom']);
							$cookieStore.put('id',data[0]['id']);
							$location.path('/page-accueil-connecter');
						}
					}, function(status) {
						$location.path('/errors');
					});
				}).
			    error(function(data, status, headers, config){
			    	console.log("erreur");
			    	$scope.erreur = true;
			    });
			};

		} ]);
