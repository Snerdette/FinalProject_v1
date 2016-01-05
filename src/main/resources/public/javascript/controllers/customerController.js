angular.module('myApp').controller('customerController', ['$scope', '$state', 'customerFactory', function($scope, $state, customerFactory){
	
	$scope.currencyVal;
	$scope.customer = {};
	var isValid = true;
	$scope.customerList = [];
	
	//Gets The List of customers.
	$scope.getAllCustomers = customerFactory.getAllCustomers().then(
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
			customer.fName = $scope.customer.firstName;
			customer.lName = $scope.customer.lastName;
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
	/*
	//Phone Number Input Validation
	myApp.directive('phoneInput', function($filter, $browser) {
	    return {
	        require: 'ngModel',
	        link: function($scope, $element, $attrs, ngModelCtrl) {
	            var listener = function() {
	                var value = $element.val().replace(/[^0-9]/g, '');
	                $element.val($filter('tel')(value, false));
	            };

	            // This runs when we update the text field
	            ngModelCtrl.$parsers.push(function(viewValue) {
	                return viewValue.replace(/[^0-9]/g, '').slice(0,10);
	            });

	            // This runs when the model gets updated on the scope directly and keeps our view in sync
	            ngModelCtrl.$render = function() {
	                $element.val($filter('tel')(ngModelCtrl.$viewValue, false));
	            };

	            $element.bind('change', listener);
	            $element.bind('keydown', function(event) {
	                var key = event.keyCode;
	                // If the keys include the CTRL, SHIFT, ALT, or META keys, or the arrow keys, do nothing.
	                // This lets us support copy and paste too
	                if (key == 91 || (15 < key && key < 19) || (37 <= key && key <= 40)){
	                    return;
	                }
	                $browser.defer(listener); // Have to do this or changes don't get picked up properly
	            });

	            $element.bind('paste cut', function() {
	                $browser.defer(listener);
	            });
	        }

	    };
	});
	myApp.filter('tel', function () {
	    return function (tel) {
	        console.log(tel);
	        if (!tel) { return ''; }

	        var value = tel.toString().trim().replace(/^\+/, '');

	        if (value.match(/[^0-9]/)) {
	            return tel;
	        }

	        var country, city, number;

	        switch (value.length) {
	            case 1:
	            case 2:
	            case 3:
	                city = value;
	                break;

	            default:
	                city = value.slice(0, 3);
	                number = value.slice(3);
	        }

	        if(number){
	            if(number.length>3){
	                number = number.slice(0, 3) + '-' + number.slice(3,7);
	            }
	            else{
	                number = number;
	            }

	            return ("(" + city + ") " + number).trim();
	        }
	        else{
	            return "(" + city;
	        }

	    };
	});*/

}]);
