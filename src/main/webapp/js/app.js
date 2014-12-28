/*global angular */

/**
 * @type {angular.Module}
 */
angular.module('todomvc', ['ngRoute', 'igCharLimit'])
	.config(function ($routeProvider) {
		'use strict';

		var routeConfig = {
			controller: 'TodoCtrl',
			templateUrl: 'index.html',
			resolve: {
				store: function (todoStorage) {
					// Get the API module
					return todoStorage.then(function (module) {
						module.get();
						return module;
					});
				}
			}
		};

		$routeProvider
			.when('/', routeConfig)
			.when('/:status', routeConfig)
			.otherwise({
				redirectTo: '/'
			});
	});
