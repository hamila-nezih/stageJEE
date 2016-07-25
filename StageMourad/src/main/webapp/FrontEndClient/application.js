var app = angular.module('myApp', [ 'ngRoute', 'ngResource', 'ngMessages','ngCookies', 'ngMaterial']);

// ------------------------ routage

app.config(function($routeProvider,$httpProvider) {
	$routeProvider.when('/', {
		templateUrl : 'FrontEndClient/views/page-accueil.html',
		controller : 'pageAccueilCtrl'
	}).when('/page-accueil-connecter', {
		templateUrl : 'FrontEndClient/views/page-accueil-connecter.html',
		controller : 'pageAccueilConnecterCtrl'
	}).when('/historique-demande-enCours/:id/:idType', {
		templateUrl : 'FrontEndClient/views/historiqueDemandeEnCours.html',
		controller : 'historiqueDemandeEnCoursCtrl'
	}).when('/connexion', {
		templateUrl : 'FrontEndClient/views/connexion.html',
		controller : 'connexionCtrl'
	}).when('/creerDemande/:id', {
		templateUrl : 'FrontEndClient/views/creer-demande.html',
		controller : 'creerDemandeCtrl'
	}).when('/errors', {
		templateUrl : 'FrontEndClient/views/errors.html'
	}).when('/gerer-compte', {
		templateUrl : 'FrontEndClient/views/gerer-compte.html',
		controller : 'gererCompteCtrl'
	}).when('/demandes-en-cours', {
		templateUrl : 'FrontEndClient/views/demandes-en-cours.html',
		controller : 'DemandesEnCoursCtrl'
	}).when('/modifier-demande/:id/:idtype', {
		templateUrl : 'FrontEndClient/views/modifier-demande.html',
		controller : 'modifierDemandeCtrl'
	}).when('/demande/:id/:idtype', {
		templateUrl : 'FrontEndClient/views/demande.html',
		controller : 'demandeCtrl'
	}).when('/demandes-clotures', {
		templateUrl : 'FrontEndClient/views/demandes-clotures.html',
		controller : 'demandesCloturesCtrl'
	}).when('/historique-demande/:id', {
		templateUrl : 'FrontEndClient/views/historique-demande.html',
		controller : 'historiqueDemandeCtrl'
	}).when('/inscription', {
		templateUrl : 'FrontEndClient/views/inscription.html',
		controller : 'inscriptionCtrl'
	}).otherwise({
		redirectTo : '/'
	});
});
