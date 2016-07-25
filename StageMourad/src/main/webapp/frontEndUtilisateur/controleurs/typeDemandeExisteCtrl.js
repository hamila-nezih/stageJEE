app.controller('typeDemandesExisteCtrl', [
		'$scope',
		'$location',
		'MsgConfig',
		'historiqueTypeDemandes',
		'getDemandeParTypeFactory',
		'deleteTypeDemandeFactory',
		'$mdDialog',
		'$mdMedia',
		'UtilisateurProperties','$cookieStore',
		function($scope, $location, MsgConfig,historiqueTypeDemandes, getDemandeParTypeFactory,
				deleteTypeDemandeFactory, $mdDialog, $mdMedia,UtilisateurProperties, $cookieStore) {
			
			
			if (angular.isUndefined($cookieStore.get('nom'))) {
				$location.path('/');
			} else {
				//recuperation la liste de type de demande avec leur historique pour la fonction recherche
				$scope.listeTypeDemande = historiqueTypeDemandes.get({},function(){},function(){$location.path('/errors');});
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
		
			//recuperation la liste de type de demande avec leur historique
			$scope.listeTypeDemande = historiqueTypeDemandes.get({},
					function(data){
				         console.log(data);
				         }
					);
			
  			// A confirm dialog  pour la fonction supprimer 
			$scope.supprimer = function(id,ev) {
				
				/* recuperation la demande (id=idDemande) */
				 getDemandeParTypeFactory.get({id : id},
						function(data){
					             if((data.length) == 0){
					 				var confirm = $mdDialog
									.confirm()
									.title('Supprimer un type de demande')
									.textContent('Êtes-vous sûr vous voulez supprimer ce type?')
									.ariaLabel('Lucky day')
									.targetEvent(ev)
									.cancel('Annuler')
									.ok('Ok');
									
							$mdDialog
									.show(confirm)
									.then(function() {
										deleteTypeDemandeFactory.supprimer({id : id},function(){
											$scope.listeTypeDemande = historiqueTypeDemandes.get({});
										});													
													},
											function() {}
										);
					             }else{
					            	 var confirm = $mdDialog
										.alert()
										.title('Suppression impossible')
										.textContent('Des demandes de ce type existent, vous ne pouvez pas le supprimer.')
										.ariaLabel('Lucky day')
										.targetEvent(ev)
										.ok('Ok');
										
								$mdDialog
										.show(confirm)
										.then(function() {},
												function() {}
											);
					            	 
					             }
					}
				);


			};   
			/* callback for ng-click 'modifier type demande': */
			$scope.editTypeDemande = function(typeDemandeID) {
				$location.path('/modifier-type-demandes/'+typeDemandeID);
			};
   			
			
		}]);