angular.module('myApp').controller('editVehicleController', ['$scope', '$state', 'vehicleFactory', 'aVehicle',  function($scope, $state, vehicleFactory, aVehicle){
	
	$scope.vehicle = aVehicle.data;
	$scope.vehicleList = [];
	$scope.makeList = [];
	$scope.modelList = [];
	
	//Gets The List of vehicles.
	$scope.getVehicleList = vehicleFactory.getVehicleList().then(
			function(success){
				$scope.vehicleList = success.data;
				console.log("Success retrieving VehicleList");
			},
			function(error){
				$scope.vehicleList = error;
				console.log("Error retrieving VehicleList");
			}
	);
	
	//Gets Model List
	$scope.getModelList = vehicleFactory.getModelList().then(
			function(success){
				$scope.modelList = success.data;
				console.log("Success retrieving ModelList");
			},
			function(error){
				$scope.modelList = error;
				console.log("Error retrieving ModelList");
			}
	);
	
	//Gets Make List
	$scope.getMakeList = vehicleFactory.getMakeList().then(
			function(success){
				$scope.makeList = success.data;
				console.log("Success retrieving MakeList");
			},
			function(error){
				$scope.makeList = error;
				console.log("Error retrieving MakeList");
			}
	);
	

	//After Vehicle is edited, PUT data to Database
	$scope.updateVehicle = function(vehicle){
		vehicleFactory.updateVehicle(vehicle.id, vehicle).then(
				function(success){
					$scope.updateVehicleResult = success.data;
					console.log("success updating Vehicle");
					$state.go("viewVehicles");
				},
				function(error){
					$scope.updateVehicleResult = error;
					console.log("error updating Vehicle");
				}
		);
	};
	
}]);