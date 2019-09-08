stanicaApp.controller("editLinijaCtrl", function($scope, $http, $routeParams, $location){
	
	var linijaUrl = "/api/linije/" + $routeParams.id;
	var prevozniciUrl = "/api/prevoznici";

	$scope.prevoznici = [];
	
	$scope.linija = {};
	$scope.linija.brojmesta = "";
	$scope.linija.cenakarte = "";
	$scope.linija.vremepolaska = "";
	$scope.linija.destinacija = "";
	$scope.linija.prevoznikId = "";
	
	$scope.prevoznici = [];	
	
	var getPrevoznici = function(){
		$http.get(prevozniciUrl).then(
			function success(res){
				$scope.prevoznici = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje prevoznika.");
			}
		);
	}
	
	
	
	
	var getLinije = function(){
		$http.get(linijaUrl).then(
			function success(res){
				$scope.linija = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje linije.");
			}
		);
	}
	getPrevoznici();
	getLinije();
	
	
	
	$scope.doEdit = function(){
		$http.put(linijaUrl, $scope.linija).then(
			function success(){
				$location.path("/linije");
			},
			function error(){
				alert("Neuspešno čuvanje linije.");
				
				
			}
		);
	}
	
	
});




