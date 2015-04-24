(function(){
  'use strict';

  angular.module('angularSpringApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('customer.create', {
                parent: 'customer',
                url: '/createCustomer',
                data: {
                    pageTitle: 'customer.title.create'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/customer/create/create.html',
                        controller: 'CreateCustomerController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('customer');
                        return $translate.refresh();
                    }]
                }
            });
    });

})();