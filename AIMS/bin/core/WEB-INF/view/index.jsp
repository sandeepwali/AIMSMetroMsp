<!DOCTYPE html>
<html data-ng-app="aimsServer">
	<head>
		<meta charset="utf-8"/>
		<title>Welcome to AIMS!</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	</head>
	<body>
		<div data-ng-controller="AccessPointController">
			<ul>
				<li>Welcome to AIMS!</li>
				<li data-ng-repeat="gateway in gateways">
					id: {{ gateway.id + ', IP Address: ' + gateway.ipAddress }}
				</li>
			</ul>
		</div>
		<script>
			var app = angular.module('aimsServer', []);
			app.controller('AccessPointController', function($scope, $http) {
				$http.get("http://localhost/core/AccessPoints")
					 .success(function (response) {
						 $scope.gateways = response;
					 });
			});
		</script>
	</body>
</html>