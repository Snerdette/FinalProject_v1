angular.module('myApp').factory('modelFactory', ['$http', function($http){
	
	return {
		getModelList: function(model){
			return $http.get('model');
		},
		getMake: function(make){
			return $http.get('/make/' + make)
		}
	}
}])