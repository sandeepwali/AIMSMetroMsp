var app = angular.module('aimsServer', []);
			app.controller('GatewayController', function($scope, $http) {
				$http.get("http://localhost:8080/Gateway/Info")
					 .success(function (response) {
						 $scope.gateways = response;
					 });
			});