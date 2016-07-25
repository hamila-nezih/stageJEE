app.service('UtilisateurProperties', function () {
    var nom = '';
    var prenom = '';
    var id = '';
    var role ='';

    return {
    	getRole: function () {
            return role;
        },
        setRole: function(value) {
        	role = value;
        },
        getNom: function () {
            return nom;
        },
        setNom: function(value) {
            nom = value;
        },
        getPrenom: function () {
            return prenom;
        },
        setPrenom: function(value) {
            prenom = value;
        },
        getId: function () {
            return id;
        },
        setId: function(value) {
            id = value;
        }
    };
});