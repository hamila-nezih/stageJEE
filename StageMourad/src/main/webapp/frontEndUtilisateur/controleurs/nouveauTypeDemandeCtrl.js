app
		.controller(
				'nouveauTypeDemandeCtrl',
				[
						'$scope',
						'$location',
						'MsgConfig',
						'typeDemandeFactory',
						'typeDocumentDemandeFactory',
						'typePreresuisDemandeFactory',
						'historiqueTypeDemandes',
						'$cookieStore',
						function($scope, $location, MsgConfig,
								typeDemandeFactory, typeDocumentDemandeFactory,
								typePreresuisDemandeFactory,
								historiqueTypeDemandes, $cookieStore) {

							if (angular.isUndefined($cookieStore.get('nom'))) {
								$location.path('/');
							} else {
								// recuperation la liste de type de demande avec
								// leur historique pour la fonction recherche
								$scope.listeTypeDemande = historiqueTypeDemandes
										.get({}, function() {
										}, function() {
											$location.path('/');
										});

								$scope.UtilisateurConnecterProperties = {
									nom : $cookieStore.get('nom'),
									prenom : $cookieStore.get('prenom'),
									role : $cookieStore.get('role')
								};
							}
							/* ng-click button path */
							$scope.path = function(path) {
								$location.path(path);
							}
							/* Prerequis */
							$scope.rowCollectionPrerequis = [];
							$scope.ordreCollectionPrerequis = [ {
								ordre : 1
							} ];
							var ord = 1;
							$scope.defaultValue = 1;

							function generateRandomItemPrerequis(libelle, type,
									oblogatoire, ordre) {

								return {
									tybeVariable : type,
									libelle : libelle,
									obligatoire : oblogatoire,
									ordre : ordre
								}
							}

							// add to the real data holder
							$scope.addRandomItemPrerequis = function addRandomItemPrerequis() {
								if (document.getElementById('libelle').value != "") {
									var libelle = document
											.getElementById('libelle').value;
									document.getElementById('libelle').value = "";
									var type = document.getElementById('type').value;
									var oblogatoire = document
											.getElementById('obligatoire').value;
									var ordre = document
											.getElementById('ordre').value;

									for (var i = 0; i < (parseInt(ord) - parseInt(1)); i++) {
										if (parseInt($scope.rowCollectionPrerequis[i].ordre) >= parseInt(ordre)) {

											$scope.rowCollectionPrerequis[i].ordre = parseInt($scope.rowCollectionPrerequis[i].ordre)
													+ parseInt(1);
										}
									}

									$scope.rowCollectionPrerequis
											.push(generateRandomItemPrerequis(
													libelle, type, oblogatoire,
													ordre));
									ord++;
									$scope.defaultValue = ord;

									$scope.ordreCollectionPrerequis.push({
										ordre : ord
									});
								}
							};

							// remove to the real data holder
							$scope.removeItemPrerequis = function removeItemPrerequis(
									row) {

								ord--;
								$scope.defaultValue = ord;
								var index = $scope.rowCollectionPrerequis
										.indexOf(row);
								var order1 = $scope.rowCollectionPrerequis[index].ordre;

								for (var i = 0; i < (parseInt(ord)); i++) {
									if (parseInt($scope.rowCollectionPrerequis[i].ordre) > parseInt(order1)) {

										$scope.rowCollectionPrerequis[i].ordre = parseInt($scope.rowCollectionPrerequis[i].ordre)
												- parseInt(1);
									}
								}
								$scope.ordreCollectionPrerequis.splice(ord, 1);

								if (index !== -1) {
									$scope.rowCollectionPrerequis.splice(index,
											1);
								}
							}

							/** ***********************Documents********************* */

							$scope.defaultValueDocument = 1;
							$scope.rowCollectionDocument = [];
							$scope.ordreCollectionDocument = [ {
								ordre : 1
							} ];
							var ordDocument = 1;

							function generateRandomItemDocument(libelle,
									oblogatoire, ordre) {

								return {
									libelle : libelle,
									obligatoire : oblogatoire,
									ordre : ordre
								}
							}

							// add to the real data holder
							$scope.addRandomItemDocument = function addRandomItemDocument() {
								if (document.getElementById('libelleDocument').value != "") {
									var libelle = document
											.getElementById('libelleDocument').value;
									document.getElementById('libelleDocument').value = "";
									var oblogatoire = document
											.getElementById('obligatoireDocument').value;
									var ordre = document
											.getElementById('ordreDocument').value;

									for (var i = 0; i < (parseInt(ordDocument) - parseInt(1)); i++) {
										if (parseInt($scope.rowCollectionDocument[i].ordre) >= parseInt(ordre)) {

											$scope.rowCollectionDocument[i].ordre = parseInt($scope.rowCollectionDocument[i].ordre)
													+ parseInt(1);
										}
									}
									$scope.rowCollectionDocument
											.push(generateRandomItemDocument(
													libelle, oblogatoire, ordre));
									ordDocument++;
									$scope.defaultValueDocument = ordDocument;
									$scope.ordreCollectionDocument.push({
										ordre : ordDocument
									});
								}
							};

							// remove to the real data holder
							$scope.removeItemDocument = function removeItemDocument(
									row) {

								ordDocument--;
								$scope.defaultValueDocument = ordDocument;
								var index = $scope.rowCollectionDocument
										.indexOf(row);
								var order1 = $scope.rowCollectionDocument[index].ordre;

								for (var i = 0; i < (parseInt(ordDocument)); i++) {
									if (parseInt($scope.rowCollectionDocument[i].ordre) > parseInt(order1)) {

										$scope.rowCollectionDocument[i].ordre = parseInt($scope.rowCollectionDocument[i].ordre)
												- parseInt(1);
									}
								}
								$scope.ordreCollectionDocument.splice(
										ordDocument, 1);

								if (index !== -1) {
									$scope.rowCollectionDocument.splice(index,
											1);
								}
							}
							/**
							 * ******************enregistrement du nouveau
							 * typedemande *************************
							 */

							// creation de nouveau type demande
							var idType;

							$scope.enregister = function() {
								typeDemandeFactory
										.creer(
												$scope.typeDemande,
												function(data) {
													console
															.log($scope.typeDemande);
													idType = data.id;
													console.log(data.id);
													for (var i = 0; i < $scope.rowCollectionPrerequis.length; i++) {
														var obligatoire = false;
														if ($scope.rowCollectionPrerequis[i].obligatoire == 'oui')
															obligatoire = true

														var tybeVariable = $scope.rowCollectionPrerequis[i].tybeVariable;
														var libelle = $scope.rowCollectionPrerequis[i].libelle;
														var ordre = $scope.rowCollectionPrerequis[i].ordre;
														var obligatoire = obligatoire;
														var id = data.id;
														typePreresuisDemandeFactory
																.TypePrerequisToUrl(
																		tybeVariable,
																		libelle,
																		ordre,
																		obligatoire,
																		id);

													}
													;
													for (var i = 0; i < $scope.rowCollectionDocument.length; i++) {
														var obligatoire = false;
														if ($scope.rowCollectionDocument[i].obligatoire == 'oui')
															obligatoire = true
														var libelle = $scope.rowCollectionDocument[i].libelle;
														var ordre = $scope.rowCollectionDocument[i].ordre;
														var obligatoire = obligatoire;
														typeDocumentDemandeFactory
																.TypeDocumentToUrl(
																		libelle,
																		ordre,
																		obligatoire,
																		id);

													}
													;
													$location
															.path("/type-demandes-existe");

												}, function() {
													$location.path('/errors');
												});

							}

						} ]);