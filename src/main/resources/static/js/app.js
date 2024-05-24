var app = angular.module("MyApp",['ui.router']);
    /* la configuration des routes avec le module ui-router
    de Angular */
	app.config(function($stateProvider,$urlRouterProvider) {
		// Configuration des routes pour la navigation
		$stateProvider.state("home",{
			url: "/",
			templateUrl: "views/entreprises.html",
			controller: "MyController"
		});
		$stateProvider.state("entreprises",{
			url: "/entreprises",
			templateUrl: "views/entreprises.html",
			controller: "MyController"
		});
		$stateProvider.state("taxes",{
		   url: "/taxes",
		   templateUrl: "views/taxes.html",
		   controller: "TaxeController"
		});	
	});

app.controller("TaxeController",function(){
	
});
	
	
app.controller("MyController",function($scope,$http){
	$scope.pageEntreprises = [];
	$scope.motCle="";
	$scope.pageCourante = 0;
	$scope.size=2;
	$scope.pages = [];

		$http({
	        method : "GET",
	        url : "http://127.0.0.1:8080/listeEntreprises?page="+$scope.pageCourante+"&size="+$scope.size
	    })
	    .then(function mySuccess(response) {
	        $scope.pageEntreprises = response.data;
	        $scope.pages = new Array(response.data.totalPages);
	    }, function myError(response) {
	        $scope.error = response.statusText;
	    });
		$scope.chercher = function(){
			$http({
		        method : "GET",
		        url : "http://127.0.0.1:8080/listeEntreprises?page="+$scope.pageCourante+"&size="+$scope.size
		    })
		    .then(function mySuccess(response) {
		        $scope.pageEntreprises = response.data;
		        $scope.pages = new Array(response.data.totalPages);
		    }, function myError(response) {
		        $scope.error = response.statusText;
		    });
		}
		
		$scope.goToPage = function(p){
			$scope.pageCourante = p;
			$scope.chercher();
		}
	 
	});

