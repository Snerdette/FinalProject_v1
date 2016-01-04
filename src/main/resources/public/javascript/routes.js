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