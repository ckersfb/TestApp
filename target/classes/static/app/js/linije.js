stanicaApp.controller("linijeCtrl", function($scope, $http, $location){
	var baseUrl = "/api/linije";
	var baseUrl2 = "/api/prevoznici";
	
	$scope.pageNum = 0;
    $scope.totalPages = 1
	
	$scope.linije = [];
	$scope.prevoznici = [];
	
	
	$scope.searchParams = {};
	$scope.searchParams.destinacija = "";
	$scope.searchParams.prevoznikId = "";
	$scope.searchParams.cenakarte = "";
	
	var getLinije = function(){
		
		 var config = {params: {}};

	       

	        if($scope.searchParams.destinacija != ""){
	            config.params.destinacija = $scope.searchParams.destinacija;
	        }

	        if($scope.searchParams.prevoznikId != ""){
	            config.params.prevoznikId = $scope.searchParams.prevoznikId;
	        }

	        if($scope.searchParams.cenakarte != ""){
	            config.params.cenakarte = $scope.searchParams.cenakarte;
	        }
	        
	        config.params.pageNum = $scope.pageNum;
		
	        $http.get(baseUrl, config).then(
	    			function success(res){
	    				$scope.linije = res.data;
	    				$scope.totalPages = res.headers("totalPages");
	    			},
	    			function error(){
	    				alert("Neupešno dobavljanje linija.");
	    			}
	    		);
	    	}
	
	getLinije();
	
	var getPrevoznici = function(){
		var promise = $http.get(baseUrl2);
		promise.then(
			function success(res){
				//console.log(res);
				$scope.prevoznici = res.data;
			},
			function error(res){
				//console.log(res);
				alert("Couldn't fetch prevoznici!");
			}
		);
	};
	getLinije();
	getPrevoznici();
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
		getLinije();
	}
	
	  $scope.nazad = function(){
	        if($scope.pageNum > 0) {
	            $scope.pageNum = $scope.pageNum - 1;
	            getLinije();
	        }
	    };

	    $scope.napred = function(){
	        if($scope.pageNum < $scope.totalPages - 1){
	            $scope.pageNum = $scope.pageNum + 1;
	            getLinije();
	        }
	    };
	
	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getLinije();
			},
			function error(){
				alert("Neuspešno brisanje linije.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/linije/edit/" + id);
	}
	
	$scope.dodaj = function(){
        $http.post(baseUrl, $scope.novaLinija)
            .then(
            	function success(res){
            		getLinije();
	
            		$scope.novaLinija.brojmesta = "";
            	    $scope.novaLinija.cenakarte = "";
            	    $scope.novaLinija.vremepolaska = "";
            	    $scope.novaLinija.destinacija = "";
            	    $scope.novaLinija.prevoznikId = "";
            	},
            	function error(res){
            		alert("Neuspesno dodavanje!");
            	}
            );
    };
	
	
});
