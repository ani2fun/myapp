var coffeeApp = angular.module('coffeeApp', ['ngResource']);


/*coffeeApp.factory('CoffeeOrder', function ($resource) {


    //return $resource('service/coffeeshop/:id/order/', {id: '@coffeeShopId'},{},{'save':{method:'POST' }});
    return $resource("http://localhost:8080/CoffeeShop/service/coffeeshop/",{id: '@coffeeShopId'},{});

   // var coffeeFactory={};


 //   return coffeeFactory;
});*/

coffeeApp.controller('OrderController', function ($scope , $resource) {
    $scope.types = [{name: 'Americano', Family: 'Coffee'},
        {name: 'Latte', family: 'coffee'},
        {name: 'Tea', family: 'The other drink'},
        {name: 'Cappucino', family: 'coffee'}];

    $scope.sizes = ['Large', 'Medium', 'Small'];


    $scope.giveMeCoffee = function () {
        $scope.drink.coffeeShopId = 1;
        var CoffeeOrder = $resource('/service/coffeeshop/order/');
        CoffeeOrder.save($scope.drink);
    }
});
