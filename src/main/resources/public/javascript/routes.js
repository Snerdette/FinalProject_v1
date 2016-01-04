(function() {
	angular.module("myApp").config(appConfig).run([ '$state', function($state) {
		$state.transitionTo('index');
	} ]);

	// Create Power page.
	function appConfig($stateProvider) {


		// Create a Customer.
		var createCustomer = {
			name : 'createCustomer',
			url : '/createCustomer/{cutomer}',
			templateUrl : '../templates/createCustomer.html',
			controller: 'customerController'
		
		};
		$stateProvider.state(createCutomer);
		
		
		// Create a Pass.
		var createPass = {
			name : 'createPass',
			url : '/createPass/{pass}',
			templateUrl : '../templates/createPass.html',
			controller: 'passController'
		
		};
		$stateProvider.state(createPass);
		
		// Create a Customer.
		var createVehicle = {
			name : 'createVehicle',
			url : '/createVehicle/{vehicle}',
			templateUrl : '../templates/createVehicle.html',
			controller: 'vehicleController'
		
		};
		$stateProvider.state(createVehicle);

		// Edit a Customer.
		var editCustomer = {
			name : 'editCustomer',
			url : '/editCustomer/{customer}',
			templateUrl : '../templates/editCustomer.html',
			controller: 'editCustomerController',
			resolve: {
				aCustomer: function(customerFactory, $stateParams) {
					return customerFactory.getCustomer($stateParams.customer);
				}
			}
		};
		$stateProvider.state(editCustomer);
		
		// Edit a Pass.
		var editPass = {
			name : 'editPass',
			url : '/editPass/{pass}',
			templateUrl : '../templates/editPass.html',
			controller: 'editPassController',
			resolve: {
				aPass: function(passFactory, $stateParams) {
					return passFactory.getPass($stateParams.pass);
				}
			}
		};
		$stateProvider.state(editPass);
		
		// Edit a Customer.
		var editCustomer = {
			name : 'editCustomer',
			url : '/editCustomer/{customer}',
			templateUrl : '../templates/editCustomer.html',
			controller: 'editCustomerController',
			resolve: {
				aCustomer: function(customerFactory, $stateParams) {
					return customerFactory.getCustomer($stateParams.customer);
				}
			}
		};
		$stateProvider.state(editCustomer);

	}
})();