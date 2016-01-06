angular.module('myApp').controller('vehicleController', ['$scope', '$state', 'vehicleFactory', function($scope, $state, vehicleFactory){
	
	$scope.vehicle = {};
	$scope.vehicleList = [];
	$scope.makeList = [];
	$scope.modelList = [];
	var isValid = true;
	
	
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
	
	//Creating a Vehicle.
	$scope.createVehicle = function(vehicle){
		if(isValid){
			vehicle.make = $scope.vehicle.make;
			vehicle.model = $scope.vehicle.model;
			vehicle.color = $scope.vehicle.color;
			vehicle.plateNumber = $scope.vehicle.plateNumber;
			vehicle.plateState = $scope.vehicle.plateState;
			passFactory.createPass(pass).then(
				function(success){
					console.log("Success Creating Pass");
					$scope.createPassResult = success
					$state.go("viewPasss");
				},
				function(error){
					console.log("Error Creating Pass");
					$scope.createPassResult = error;
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
					$state.go("dashboard", {}, {reload:true});
				},
				function(error){
					$scope.deleteVehicleResult = error;
					console.log("error deleting Vehicle");
				}
		);
	};
	
	//Grabbing Vehicle Data for Edit vehicle Page.
	$scope.getVehicleData = function(vehicle){
		$state.go("editVehicle", {vehicle: vehicle});
	}

}]);
