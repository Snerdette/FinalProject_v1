angular.module('myApp').factory('makeFactory', ['$http', function($http){
	
	return {
		getAllMakes: function(make){
				return $http.get('make');
		},
		getMake: function(make){
			return $http.get('/make/' + make);
		}
	}
	
}])