angular.module('myApp').controller('editCustomerController', ['$scope', '$state', 'customerFactory', 'aCustomer', function($scope, $state, customerFactory, aCustomer){
	
	$scope.customer = aCustomer.data;
	$scope.customerList = [];
	
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
	
	//After Customer is edited, PUT data to Database
	$scope.updateCustomer = function(customer){
		customerFactory.updateCustomer(customer.id, customer).then(
				function(success){
					$scope.updateCustomerResult = success.data;
					console.log("success updating Customer");
					$state.go("dashboard");
				},
				function(error){
					$scope.updateCustomerResult = error;
					console.log("error updating Customer");
				}
		);
	};
	
}]);