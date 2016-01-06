angular.module('myApp').factory('vehicleFactory', ['$http', function($http){

	return {
		createVehicle: function(vehicle){
			return $http.post('vehicle', vehicle);
		},
		getVehicleList: function(vehicle){
			return $http.get('vehicle');
		},
		deleteVehicle: function(vehicleId){
			return $http.delete('/vehicle/' + vehicleId);
		},
		updateVehicle: function(vehicleId, vehicle){
			return $http.put('/vehicle/' + vehicleId, vehicle);
		},
		getVehicleById: function(vehicle){
			return $http.get('/vehicle/'+ vehicle);
		}
	}	
}])
