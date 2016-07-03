'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', function ($scope, Auth, $location, $log) {


    $scope.logout = function(){
      $log.debug("logout...");
      Auth.logout();
      $location.path('/login');
    }

  });
