angular.module('myApp').controller('editVehicleController', ['$scope', '$state', 'vehicleFactory', 'aVehicle',  function($scope, $state, vehicleFactory, aVehicle){
	
	
	$scope.vehicle = aVehicle.data;
	$scope.vehicleList = [];

	
	
	//Gets The List of vehicles.
	$scope.getAllVehicles = vehicleFactory.getAllVehicle().then(
			function(success){
				$scope.vehicleList = success.data;
				console.log("Success retrieving VehicleList");
			},
			function(error){
				$scope.vehicleList = error;
				console.log("Error retrieving VehicleList");
			}
	);

	//After Vehicle is edited, PUT data to Database
	$scope.updateVehicle = function(vehicle){
		vehicleFactory.updateVehicle(vehicle.id, vehicle).then(
				function(success){
					$scope.updateVehicleResult = success.data;
					console.log("success updating Vehicle");
					$state.go("dashboard");
				},
				function(error){
					$scope.updateVehicleResult = error;
					console.log("error updating Vehicle");
				}
		);
	};
	
}]);