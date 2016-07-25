app.controller('historiqueDemandeCtrl', [
		'$scope',
		'historiqueDemandeFactory',
		'historiquePrerequisFactory',
		'historiqueDocumentsFactory',
		'ListeDemandeDisponibleFactory',
		'$routeParams',
		'fileUpload',
		'$location',
		'$window',
		'$http','$cookieStore',
		function($scope, historiqueDemandeFactory, historiquePrerequisFactory,
				historiqueDocumentsFactory, ListeDemandeDisponibleFactory, $routeParams, fileUpload,
				$location, $window, $http, $cookieStore) {
			
			/* recuperation nom et prenom*/
			$scope.ClientConnecterProperties ={
					nom : $cookieStore.get('nom'),
					prenom : $cookieStore.get('prenom')
			};
			
			$scope.listeDemandeDisponible = ListeDemandeDisponibleFactory
			.select({}, function(data) {
				console.log(data);

			}, function(status) {

			});

			/* recuperation la demande (id=idDemande) */
			$scope.demandeHistorique = historiqueDemandeFactory.get({
				id : $routeParams.id
			}, function(data) {

			}, function(status) {

			});

			/* recuperation les prerequis (id=idDemande) */
			$scope.prerequisHistorique = historiquePrerequisFactory.get({
				id : $routeParams.id
			}, function(data) {
				console.log(data);
			}, function(status) {

			});

			/* recuperation les documents (id=idDemande) */
			$scope.documentsHistorique = historiqueDocumentsFactory.get({
				id : $routeParams.id
			}, function(data) {
				console.log(data);
			}, function(status) {

			});
			/* fonction afficher/chaher prerequis */
			$scope.afficherPrerequis = true;
			$scope.afficherPrerequisFonction = function() {
				$scope.afficherPrerequis = false;

			};
			$scope.cacherPrerequisFonction = function() {
				$scope.afficherPrerequis = true;

			};
			/* fonction afficher/chaher prerequis */
			$scope.afficherDocument = true;
			$scope.afficherDocumentFonction = function() {
				$scope.afficherDocument = false;

			};
			$scope.cacherDocumentFonction = function() {
				$scope.afficherDocument = true;

			};
			/*
			 * Download //
			 */
			$scope.download = function(idDocument, nameFile) {
				var url = 'http://localhost:8081/stage/rest/demande/downloadFile/'
						+ idDocument;
				$http.get(url, {
					responseType : 'arraybuffer'
				}).success(function(data, status, headers, config) {
					var ieEDGE = navigator.userAgent.match(/Edge/g);
					var ie = navigator.userAgent.match(/.NET/g); // IE
					// 11+
					var oldIE = navigator.userAgent.match(/MSIE/g);
					var name = nameFile;
					var blob = new window.Blob([ data ], {
						type : 'application/pdf'
					});
					if (ie || oldIE || ieEDGE) {
						var fileName = name;
						window.navigator.msSaveBlob(blob, fileName);
					} else {
						var file = new Blob([ data ], {
							type : 'application/pdf'
						});
						var fileURL = URL.createObjectURL(file);
						var a = document.createElement('a');
						a.href = fileURL;
						a.target = '_blank';
						a.download = name;
						document.body.appendChild(a);
						a.click();
					}
				});
			};

		} ]);