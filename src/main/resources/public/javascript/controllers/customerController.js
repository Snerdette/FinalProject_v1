angular.module('myApp').controller('customerController', ['$scope', '$state', 'passFactory', 'vehicleFactory', 'customerFactory', function($scope, $state, passFactory, customerFactory, vehicleFactory){
	
	$scope.customer = {};
	var isValid = true;
	$scope.passList = [];
	$scope.customerList = [];
	$scope.vehicleList = [];
	
	//Gets The List of customers.
	$scope.getCustomerList = customerFactory.getCustomerList().then(
			function(success){
				$scope.customerList = success.data;
				console.log("Success retrieving CustomerList");
			},
			function(error){
				$scope.customerList = error;
				console.log("Error retrieving CustomerList");
			}
	);
	
	//Creating a Customer.
	$scope.createCustomer = function(customer){
		if(isValid){
			customer.firstName = $scope.customer.firstName;
			customer.lastName = $scope.customer.lastName;
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
	
	//Deleting a customer.
	$scope.deleteCustomer = function(customerId){
		customerFactory.deleteCustomer(customerId).then(
				function(success){
					$scope.deleteCustomerResult = success
					console.log("success deleting customer");
					$state.go("viewCustomers", {}, {reload:true});
				},
				function(error){
					$scope.deleteCustomerResult = error;
					console.log("error deleting Customer");
				}
		);
	};
	
	//Grabbing Customer Data for Edit customer Page.
	$scope.getCustomerData = function(customer){
		$state.go("editCustomer", {customer: customer});
	}

}]);
