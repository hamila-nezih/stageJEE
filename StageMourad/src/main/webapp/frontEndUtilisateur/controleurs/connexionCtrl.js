app.controller('connexionCtrl', [
		'$scope',
		'$location',
		'MsgConfig',
		'UtilisateurProperties',
		'$http',
		'$cookieStore',
		function($scope, $location, MsgConfig, UtilisateurProperties, $http, $cookieStore) {
			
			$scope.msg = MsgConfig;
			$scope.erreur = false;
			$cookieStore.remove('prenom');
			$cookieStore.remove('role');
			$cookieStore.remove('id');
			$cookieStore.remove('nom');
			/*deconnection*/
			  $http.get('j_spring_security_logout');
			$scope.connexion = function() {
				var data = "j_username="+$scope.login+"&j_password="+$scope.password+"&submit=Login";
				$http.post('j_spring_security_check', data, {
					  headers: {
					    'Content-Type': 'application/x-www-form-urlencoded',
					  }
				}).success(function(data, status, headers, config) {
					console.log("success", data);
					var role = document.getElementById('login').value;
					if (role == 'agent'){
						$cookieStore.put('nom',"Agent");
						$cookieStore.put('prenom',"Agent");
						$cookieStore.put('role',"Agent");
						$cookieStore.put('id',"1");
						$location.path('/gerer-demande');
					}else if (role == 'administratif'){
						$cookieStore.put('nom',"Administratif");
						$cookieStore.put('prenom',"Administratif");
						$cookieStore.put('role',"administratif");
						$cookieStore.put('id',"1");
						$location.path('/creation-nouveau-type');
					}else if (role == 'bigBoss'){
						$cookieStore.put('nom',"Big");
						$cookieStore.put('prenom',"Boss");
						$cookieStore.put('role',"bigBoss");
						$cookieStore.put('id',"1");
						$location.path('/creation-nouveau-type');
					}
					
				}
				).
			    error(function(data, status, headers, config){
			    	console.log("erreur");
			    	$scope.erreur = true;
			    });
			}
		}]);

			