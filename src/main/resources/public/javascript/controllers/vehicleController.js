angular.module('myApp').controller('vehicleController', ['$scope', '$state', 'vehicleFactory', 'makeFactory', 'modelFactory', function($scope, $state, vehicleFactory, makeFactory, modelFactory){
	
	$scope.vehicle = {};
	var isValid = true;
	$scope.vehicleList = [];
	$scope.vehicleEditData = {};
	$scope.makeList = [];
	$scope.modelList = [];
	
	//Gets The Data of vehicles.
	$scope.getAllVehicles = vehicleFactory.getAllVehicles().then(
			function(success){
				$scope.vehicleList = success.data;
				console.log("Success retrieving VehicleList");
			},
			function(error){
				$scope.vehicleList = error;
				console.log("Error retrieving VehicleList");
			}
	);
	
	//Gets Model Data
	$scope.getAllModels = modelFactory.getAllModels().then(
			function(success){
				$scope.modelList = success.data;
				console.log("Success retrieving ModelList");
			},
			function(error){
				$scope.modelList = error;
				console.log("Error retrieving ModelList");
			}
	);
	
	//Gets Make Data
	$scope.getAllMakes = makeFactory.getAllMakes().then(
			function(success){
				$scope.makeList = success.data;
				console.log("Success retrieving MakeList");
			},
			function(error){
				$scope.makeList = error;
				console.log("Error retrieving MakeList");
			}
	);
	
	//Creating a Vehicle.
	$scope.createVehicle = function(vehicle){
		if(isValid){
			vehicle.make = $scope.vehicle.make;
			vehicle.model = $scope.vehicle.model;
			vehicle.color = $scope.vehicle.color;
			vehicle.plateNumber = $scope.vehicle.plateNumber;
			vehicle.plateState = $scope.vehicle.plateState;
			vehicleFactory.createVehicle(vehicle).then(
				function(success){
					console.log("Success Creating Vehicles");
					$scope.createVehicleResult = success
					$state.go("viewVehicles");
				},
				function(error){
					console.log("Error Creating Vehicle");
					$scope.createVehicleResult = error;
				}
			);
		}
	};
	
	//Deleting a Vehicle.
	$scope.deleteVehicle = function(vehicleId){
		vehicleFactory.deleteVehicle(vehicleId).then(
				function(success){
					$scope.deleteVehicleResult = success
					console.log("success deleting Vehicle");
					$state.go("viewVehicles", {}, {reload:true});
				},
				function(error){
					$scope.deleteVehicleResult = error;
					console.log("error deleting Vehicle");
				}
		);
	};
	
	//Grabbing Vehicle Data for Edit vehicle Page.
	$scope.getVehicleData = function(vehicle){
		console.log(vehicle);
		$state.go("editVehicle", {vehicle: vehicle});
	}
	
	

}]);
