app.controller(
				'inscriptionCtrl',[
						'$scope',
						'MsgConfig',
						'ClientFactory',
						'ListeDemandeDisponibleFactory',
						'$location','$cookieStore','$http' ,
						function($scope, MsgConfig, ClientFactory, ListeDemandeDisponibleFactory, $location,
								 $cookieStore, $http) {
							
							/* recuperation la liste de type de demande disponible */
							$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
									.select({}, function(data) {}, function(status) {
										$location.path('/errors');
									});


							/* callback for 'message' */
							$scope.msg = MsgConfig;

							/*
							 * callback for create new client
							 */
							$scope.createNewClient = function() {
								ClientFactory.create($scope.client, function(data) {
									$cookieStore.put('nom',$scope.client.nom);
									$cookieStore.put('prenom',$scope.client.prenom);
									$cookieStore.put('id',data[0]['id']);
									var data = "j_username="+$scope.client.mail+"&j_password="+$scope.client.motsPasse+"&submit=Login";
									$http.post('j_spring_security_check', data, {
										  headers: {
										    'Content-Type': 'application/x-www-form-urlencoded',
										  }
									});
									$location.path('/page-accueil-connecter');
								}, function(status) {
									$location.path('/errors');
								});
							}
							/* recuperation le date du systeme */
							var today = new Date();
							var dd = today.getDate();
							var mm = today.getMonth() + 1; // January is 0!

							var yyyy = today.getFullYear();
							if (dd < 10) {
								dd = '0' + dd
							}
							if (mm < 10) {
								mm = '0' + mm
							}
							$scope.today = yyyy + '-' + mm + '-' + dd;
							/**/

							
							/**/
						} ]);
