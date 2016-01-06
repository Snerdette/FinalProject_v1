angular.module('myApp').factory('makeFactory', ['$http', function($http){
	
	return {
		getMakeList: function(make){
				return $http.get('make');
		},
		getModelById: function(model){
			return $http.get('/model/' + model)
		}
	}
	
}])