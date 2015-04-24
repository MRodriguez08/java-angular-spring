(function() { 
	'use strict';

	angular.module('angularSpringApp')
    .controller('CreateCustomerController', ['$scope', '$log', '$state', 'CustomerService', function ( $scope, $log, $state, CustomerService) {
    	
    	$scope.error = false;
    	$scope.succes = false;
    	$scope.processing = true;
    	$scope.model = {};
    	
    	
    	$scope.create = function () {
            
    		CustomerService.create($scope.model).then(function (response) {
    			bootbox.dialog({
    				  message: "Cliente ingresado con exito",
    				  title: "Clientes",
    				  buttons: {
    				    success: {
    				      label: "Aceptar",
    				      className: "btn-success",
    				      callback: function() {		
    				    	  $state.reload();
    				    	  $scope.model = {};
    				      }
    				    }
    				  }
    			});		    	
    		}).catch(function(response) {
    			switch(response.status) {
	    		    case 500:
	    		    	alert('Error interno de la aplicacion');
	    		        break;
	    		    case 400:
	    		    	$scope.error = true;
	    		    	$scope.errorMessage = response.data.message;
	    		        break;
	    		    default:
	    		        
	    		}
    			$scope.processing = false;
            });
    		
    		
    		
        };
        
    }]);
})() ;