angular.module('myApp').factory('customerFactory', ['$http', function($http){

	return {
		createCustomer: function(customer){
			return $http.post('customer', customer);
		},
		getCustomerList: function(customer){
			return $http.get('customer');
		},
		deleteCustomer: function(customerId){
			return $http.delete('/customer/' + customerId);
		},
		updateCustomer: function(customerId, customer){
			return $http.put('/customer/' + customerId, customer);
		},
		getCustomerById: function(customer){
			return $http.get('/customer/'+ customer);
		}
	}	
}])
