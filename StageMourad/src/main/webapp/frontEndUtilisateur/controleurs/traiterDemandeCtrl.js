app
		.controller(
				'traiterDemandeCtrl',
				[
						'$scope',
						'$location',
						'MsgConfig',
						'DocumentsFactory',
						'PrerequisFactory',
						'DemandeProperties',
						'$routeParams',
						'$http',
						'TraiterDemandeFactory1','UtilisateurProperties','gererDemandeFactory1','$cookieStore',
						function($scope, $location, MsgConfig,
								DocumentsFactory, PrerequisFactory,
								DemandeProperties, $routeParams, $http,
								TraiterDemandeFactory1,UtilisateurProperties, gererDemandeFactory1, $cookieStore) {
							
							
							if (angular.isUndefined($cookieStore.get('nom'))) {
								$location.path('/');
							} else {
								/* recuperation la liste des demandes disponible*/
					            $scope.listeDemandeDisponible = gererDemandeFactory1
								.get({});

								$scope.UtilisateurConnecterProperties = {
									nom : $cookieStore.get('nom'),
									prenom : $cookieStore.get('prenom'),
									role : $cookieStore.get('role')
								};
							}
							
							

							/* ng-click button path*/
							$scope.path = function(path){
								$location.path(path);
							}

							$scope.DemandeProperties = {
								libelle : DemandeProperties.getLibelle(),
								titre : DemandeProperties.getTitre(),
								etat : DemandeProperties.getEtat(),
								date : DemandeProperties.getDateCreation()
							};
							/** **************** */
							$scope.options = [ 'homme', 'femme' ];

							/*
							 * recuperation les prerequis de type de la demande
							 * 
							 */
							$scope.prerequisDemande = PrerequisFactory.get({
								idDmd : $routeParams.id
							}, function(data) {
								console.log("prerequis")
								console.log(data);
								if (data[0][1] == 'homme') {
									$scope.selected = 'homme';
								} else {
									$scope.selected = 'femme';
								}
							}, function(status) {
							});

							/*
							 * recuperation les Documents
							 * 
							 */
							$scope.DocumentsDemande = DocumentsFactory.get({
								idDmd : $routeParams.id
							}, function(data) {
								console.log(data)
							}, function(status) {
							});

							/*
							 * Download //
							 */
							$scope.download = function(idDocument, nameFile) {
								var url = 'http://localhost:8081/stage/rest/demande/downloadFile/'
										+ idDocument;
								$http
										.get(url, {
											responseType : 'arraybuffer'
										})
										.success(
												function(data, status, headers,
														config) {
													var ieEDGE = navigator.userAgent
															.match(/Edge/g);
													var ie = navigator.userAgent
															.match(/.NET/g); // IE
													// 11+
													var oldIE = navigator.userAgent
															.match(/MSIE/g);
													var name = nameFile;
													var blob = new window.Blob(
															[ data ],
															{
																type : 'application/pdf'
															});
													if (ie || oldIE || ieEDGE) {
														var fileName = name;
														window.navigator
																.msSaveBlob(
																		blob,
																		fileName);
													} else {
														var file = new Blob(
																[ data ],
																{
																	type : 'application/pdf'
																});
														var fileURL = URL
																.createObjectURL(file);
														var a = document
																.createElement('a');
														a.href = fileURL;
														a.target = '_blank';
														a.download = name;
														document.body
																.appendChild(a);
														a.click();
													}
												});
							};
							/* enregistrer */
							$scope.enregister = function() {
								if (document.getElementById('commentaire').value != ""
										&& document.getElementById('etat') != "") {
									/* recuperation le date du systeme */
									var today = new Date();
									var dd = today.getDate();
									var mm = today.getMonth() + 1; // January
																	// is 0!

									var yyyy = today.getFullYear();
									if (dd < 10) {
										dd = '0' + dd
									}
									if (mm < 10) {
										mm = '0' + mm
									}
									$scope.today = yyyy + '-' + mm + '-' + dd;
									var demande = {
										id : $routeParams.id,
										commentaire : document
												.getElementById('commentaire').value,
										etat : document.getElementById('etat').value,
										dateModification : $scope.today
									};
									TraiterDemandeFactory1.update(demande);
									$location.path("/gerer-demande");
								}
								;
							}

						} ]);