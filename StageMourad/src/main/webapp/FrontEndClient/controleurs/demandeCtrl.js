app
		.controller(
				'demandeCtrl',
				[
						'$scope',
						'TypeDemandeFactory',
						'DocumentsFactory',
						'CreerPrerequisFactory',
						'PrerequisFactory',
						'ListeDemandeDisponibleFactory',
						'$routeParams',
						'$location',
						'historiqueDemandeFactory', '$cookieStore',
						function($scope, TypeDemandeFactory,
								DocumentsFactory, CreerPrerequisFactory,
								PrerequisFactory,ListeDemandeDisponibleFactory, $routeParams, 
								$location, historiqueDemandeFactory, $cookieStore) {
							
							
							
							$scope.idDemande = $routeParams.id ;
							$scope.idTyDemande = $routeParams.idtype ;

							/* recuperation nom et prenom*/
							$scope.ClientConnecterProperties ={
									nom : $cookieStore.get('nom'),
									prenom : $cookieStore.get('prenom')
							};
							$scope.ok = function(){
								$location.path('/historique-demande-enCours/' + $routeParams.id+"/"+$routeParams.idtype);								
							};
							/* recuperation la liste de type de demande disponible */
							$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
									.select({}, function(data) {}, function(status) {});
							/*************/
							
							/** **************** */
							
							$scope.options = [ 'homme', 'femme' ];
							/* recuperation la demande (id=idDemande) */
							$scope.demandeHistorique = historiqueDemandeFactory.get({
								id : $routeParams.id
							}, function(data) {
								console.log(data);

							}, function(status) {

							});

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
						}]);
							