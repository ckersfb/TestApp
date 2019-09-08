var stanicaApp = angular.module("stanicaApp", ['ngRoute']);

stanicaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	
	.when('/home', {
		templateUrl : '/app/html/home.html'
	})
		
		.when('/linije', {
			templateUrl : '/app/html/linije.html'
		})
		.when('/linije/edit/:id', {
			templateUrl : '/app/html/izmena-linije.html'
		})
		
		.otherwise({
			redirectTo: '/'
		});
}]);