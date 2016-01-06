angular.module('myApp').factory('vehicleFactory', ['$http', function($http){

	return {
		createVehicle: function(vehicle){
			return $http.post('vehicle', vehicle);
		},
		getVehicleList: function(vehicle){
			return $http.get('vehicle');
		},
		getMakeList: function(make){
			return $http.get('make');
		},
		getModelList: function(model){
			return $http.get('model');
		},
		deleteVehicle: function(vehicleId){
			return $http.delete('/vehicle/' + vehicleId);
		},
		updateVehicle: function(vehicleId, vehicle){
			return $http.put('/vehicle/' + vehicleId, vehicle);
		},
		getVehicle: function(vehicle){
			return $http.get('/vehicle/'+ vehicle);
		}
	}	
}])
