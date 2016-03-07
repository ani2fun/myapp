var coffeeApp = angular.module('coffeeApp', ['ngResource','ui.bootstrap']);

coffeeApp.controller('OrderController', function ($scope , $resource) {
    $scope.types = [{name: 'Americano', Family: 'Coffee'},
        {name: 'Latte', family: 'coffee'},
        {name: 'Tea', family: 'The other drink'},
        {name: 'Cappucino', family: 'coffee'}];

    $scope.sizes = ['Large', 'Medium', 'Small'];

    $scope.messages = [];

    $scope.giveMeCoffee = function () {
        $scope.drink.coffeeShopId = 1;
        var CoffeeOrder = $resource('/service/coffeeshop/order/');
        CoffeeOrder.save($scope.drink, function(order){
            $scope.messages.push({type: 'success', msg:'Order Sent ! OrderId : ' + order.id})

        });

        $scope.closeAlert = function(index){
            $scope.messages.splice(index,1);
        };

    };

    console.log("Messages array: " + $scope.messages);

});
