angular.module('myApp').factory('makeFactory', ['$http', function($http){
	
	return {
		getAllMakes: function(make){
				return $http.get('make');
		},
		getModel: function(model){
			return $http.get('/model/' + model)
		}
	}
	
}])