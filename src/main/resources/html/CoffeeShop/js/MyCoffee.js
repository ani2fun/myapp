var app = angular.module('MyCoffeeApp', ['ngResource']);

app.controller('OrderController', function ($scope, $resource) {

    $scope.types = [{name: 'Americano', family: 'Coffee'},
        {name: 'Latte', family: 'Coffee'},
        {name: 'Cappuccino', family: 'Coffee'},
        {name: 'Tea', family: 'That Other Drink'}];

    $scope.sizes = ['Large', 'Medium', 'Small'];


    $scope.giveMeCoffee = function () {

        $scope.drink.coffeeShopId = 1;

        var CoffeeOrder = $resource('/service/mycoffeeshop/order');

        CoffeeOrder.save($scope.drink);
    }

});