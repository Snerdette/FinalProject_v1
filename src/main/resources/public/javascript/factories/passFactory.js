angular.module('myApp').factory('passFactory', ['$http', function($http){

	return {
		createPass: function(pass){
			return $http.post('pass', pass);
		},
		getPassList: function(pass){
			return $http.get('pass');
		},
		deletePass: function(passId){
			return $http.delete('/pass/' + passId);
		},
		updatePass: function(passId, pass){
			return $http.put('/pass/' + passId, pass);
		},
		getPassById: function(pass){
			return $http.get('/pass/'+ pass);
		}
	}	
}])
