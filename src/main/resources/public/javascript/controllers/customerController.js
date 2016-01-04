angular.module('myApp').controller('CustomerController', ['$scope', '$state', 'customerFactory',   function($scope, $state, customerFactory){
	
	$scope.customer = {};
	var isValid = true;
	$scope.customerList = [];
	$scope.customerEditData = {};
	$scope.isEditing = false;
	
	//Gets powers to add to hero powers.
	$scope.getAllCustomers = customerFactory.getAllcustomers().then(
			function(success){
				$scope.customerList = success.data;
				console.log("Success retrieving CustomerList");
			},
			function(error){
				$scope.customerList = error;
				console.log("Error retrieving CustomerList");
			}
	);
	
//	$scope.customer. = [];	
	
	//takes in all data from createCustomer view and passes it to the database.
	$scope.createCustomer = function(customer){
		if(isValid){
			customer.fName = $scope.customer.fName;
			customer.lName = $scope.customer.lName;
			customer.email = $scope.customer.email;
			customer.phone = $scope.customer.phone;

			customerFactory.createCustomer(customer).then(
				function(success){
					console.log("Success Creating Customer");
					$scope.createCustomerResult = success
					$state.go("viewCustomers");
				},
				function(error){
					console.log("Error Creating Customer");
					$scope.createCustomerResult = error;
				}
			);
		}
		
	};
	

	$scope.getCustomerData = function(customer){
		$state.go("editCustomer", {customer: customer});
	}
	
	
	$scope.deleteHero = function(heroId){
		heroFactory.deleteHero(heroId).then(
				function(success){
					$scope.deleteHeroResult = success
					console.log("success deleting hero");
					$state.go("viewHeroes", {}, {reload:true});
				},
				function(error){
					$scope.deleteHeroResult = error;
					console.log("error deleting Hero");
				}
		);
	};
	
	/*$scope.powers = [];*/
	

}]);
