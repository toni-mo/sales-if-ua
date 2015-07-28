angular.module('newApp', [])
			.controller('MainCtrl', [function() {
				var self = this;
					self.shops_list = [
						{id: 1, label: 'Rozetka', done: 'http://rozetka.com.ua/'},
						{id: 2, label: 'Eldorado', done: 'http://www.eldorado.com.ua/'},
						{id: 3, label: 'Allo', done: 'http://allo.ua/'}
					];
					self.characteristics_list = [
						{id: 1, label: 'Supports for multiple SIM cards', done: 'value'},
						{id: 2, label: 'Operating System', done: 'value'},
						{id: 3, label: 'Processor', done: 'value'},
						{id: 3, label: 'Sizes', done: 'value'},
						{id: 3, label: 'Display', done: 'value'},
						{id: 3, label: 'Camera', done: 'value'},
						{id: 3, label: 'Memory', done: 'value'}
					];
					self.video = [
						{text: 'YouTube video player', done: 'https://www.youtube.com/embed/mZ-0RbT4KEk?enablejsapi=1&amp;origin=http%3A%2F%2Frozetka.com.ua'},
					];	
			}]);