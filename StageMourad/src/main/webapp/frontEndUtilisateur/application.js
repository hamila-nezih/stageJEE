var app = angular.module('myApp', [ 'ngRoute', 'ngResource', 'ngMessages','ngCookies', 'ngMaterial']);

// ------------------------ routage

app.config(function($routeProvider,$httpProvider) {
	$routeProvider.when('/', {
		templateUrl : 'frontEndUtilisateur/views/connexion.html',
		controller : 'connexionCtrl'
	}).when('/creation-nouveau-type', {
		templateUrl : 'frontEndUtilisateur/views/creation-nouveau-type.html',
		controller : 'nouveauTypeDemandeCtrl'
	}).when('/gerer-demande', {
		templateUrl : 'frontEndUtilisateur/views/gerer-demande.html',
		controller : 'gererDemandeCtrl'
	}).when('/traiter-demande/:id', {
		templateUrl : 'frontEndUtilisateur/views/traiter-demande.html',
		controller : 'traiterDemandeCtrl'
	}).when('/type-demandes-existe', {
		templateUrl : 'frontEndUtilisateur/views/type-demande-existe.html',
		controller : 'typeDemandesExisteCtrl'
	}).when('/modifier-type-demandes/:id', {
		templateUrl : 'frontEndUtilisateur/views/modifier-type-demande.html',
		controller : 'modifierTypeDemandesCtrl'
	}).when('/page-accueil', {
		templateUrl : 'frontEndUtilisateur/views/page-accueil.html',
		controller : 'pageAccueilCtrl'
	}).when('/errors', {
		templateUrl : 'frontEndUtilisateur/views/errors.html'
	}).otherwise({
		redirectTo : '/'
	});
});
