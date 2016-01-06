angular.module('myApp').factory('modelFactory', ['$http', function($http){
	
	return {
		getModelList: function(model){
			return $http.get('model');
		},
		getMakeById: function(make){
			return $http.get('/make/' + make)
		}
	}
}])