
(function(){
	'use strict';
	
	angular.module('angularSpringApp')
	    .config(function ($stateProvider) {
	        $stateProvider
	            .state('customer', {
	                abstract: true,
	                parent: 'site'
	            });
	    });

})();