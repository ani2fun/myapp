'use strict';

angular.module('confusionApp')

        .controller('MenuController', ['$scope', 'menuFactory', function($scope, menuFactory) {
            
            $scope.tab = 1;
            $scope.filtText = '';
            $scope.showDetails = false;
            
            $scope.showMenu = false;
            $scope.message = "Loading ...";
                        
                    menuFactory.getDishes().query(function(response){
                    
                        $scope.dishes = response;
                        $scope.showMenu = true;
                },
                function(response) {
                    $scope.message = "Error: "+response.status + " " + response.statusText;
                });

                        
            $scope.select = function(setTab) {
                $scope.tab = setTab;
                
                if (setTab === 2) {
                    $scope.filtText = "appetizer";
                }
                else if (setTab === 3) {
                    $scope.filtText = "mains";
                }
                else if (setTab === 4) {
                    $scope.filtText = "dessert";
                }
                else {
                    $scope.filtText = "";
                }
            };

            $scope.isSelected = function (checkTab) {
                return ($scope.tab === checkTab);
            };
    
            $scope.toggleDetails = function() {
                $scope.showDetails = !$scope.showDetails;
            };
        }])


            .controller('DishDetailController', ['$scope', '$stateParams', 'menuFactory', function($scope, $stateParams, menuFactory) {
            
            
            $scope.showDish = false;
            $scope.message="Loading ...";
           
            $scope.dish = menuFactory.getDishes().get({id:parseInt($stateParams.id,10)})
            .$promise.then(
                            function(response){
                                $scope.dish = response;
                                $scope.showDish = true;
                            },
                            function(response) {
                                $scope.message = "Error: "+response.status + " " + response.statusText;
                            }
            );
            
        }])

       .controller('DishCommentController', ['$scope', 'menuFactory', function($scope,menuFactory) {
            
            $scope.mycomment = {rating:5, comment:"", author:"", date:""};
            
            $scope.submitComment = function () {
                                $scope.mycomment.date = new Date().toISOString();
                                console.log($scope.mycomment);
                
                                $scope.dish.comments.push($scope.mycomment);

                                menuFactory.getDishes().update({id:$scope.dish.id},$scope.dish);
                
                                $scope.commentForm.$setPristine();
                                $scope.mycomment = {rating:5, comment:"", author:"", date:""};
            };
        }])


        .controller('ContactController', ['$scope', function($scope) {

            $scope.feedback = {mychannel:"", firstName:"", lastName:"", agree:false, email:"" };
            
            var channels = [{value:"tel", label:"Tel."}, {value:"Email",label:"Email"}];
            
            $scope.channels = channels;
            $scope.invalidChannelSelection = false;
                        
        }])

        .controller('FeedbackController', ['$scope','feedbackFactory', function($scope,feedbackFactory) {
               
             $scope.sendFeedback = function() {
                
                console.log("sendFeedback is started: then value of ($scope.feedback) is:");
                console.log($scope.feedback);
                
                if ($scope.feedback.agree && ($scope.feedback.mychannel == "")) {
                    $scope.invalidChannelSelection = true;
                    console.log('incorrect');
                }
                else {
                    $scope.invalidChannelSelection = false;
                 
                    $scope.feedbackValues = feedbackFactory.getFeedback()
                        .query( 
                        function(response){ 
                            $scope.feedbackValues = response;
                            }, 
                        function(response) { 
                            $scope.message = "Error: "+response.status + " " + response.statusText;
                          });
                    
                    
					console.log("Before feedbackValues being Pushed: ");
					console.log($scope.feedbackValues);
					$scope.feedbackValues.push($scope.feedback);
					console.log("After feedbackValues Pushed: ");
                    console.log($scope.feedbackValues);
                    console.log("Value of $scope.feedback");
                    console.log($scope.feedback);
                    console.log("Calling feedbackFactory.getFeedback().save($scope.feedback); ");
                    feedbackFactory.getFeedback().save($scope.feedback);
                    

                    $scope.feedback = {mychannel:"", firstName:"", lastName:"", agree:"", email:"" };
                    $scope.feedback.mychannel="";
                    $scope.feedbackForm.$setPristine();
                    console.log("Form being set to pristine: ");
                    console.log($scope.feedback);
                }
            };
        }])

       
        // implement the IndexController and About Controller here

      .controller('IndexController',['$scope','corporateFactory','menuFactory',function($scope,corporateFactory, menuFactory ){
          
          
           $scope.showLeader = false;
            $scope.leader = corporateFactory.getLeaders().get({id:3})
                .$promise.then(
                function(response){
                    $scope.leader = response;
                    $scope.showLeader = true;
                },
                function(response){
                     $scope.message = "Error: "+response.status + " " + response.statusText;
                });
          
           $scope.showPromotion = false;
            
            $scope.promotion = menuFactory.getPromotion().get({id:0})
                .$promise.then(
                function(response){
                    $scope.promotion = response;
                    $scope.showPromotion = true;
                },
                function(response){ 
                $scope.message = "Error: " + response.status + " " + response.statusText;
                });
          
             
            $scope.showDish = false;
            $scope.message="Loading ...";
            
            $scope.dish = menuFactory.getDishes().get({id:0})
                        .$promise.then(
                            function(response){
                                $scope.dish = response;
                                $scope.showDish = true;
                            },
                            function(response) {
                                $scope.message = "Error: "+response.status + " " + response.statusText;
                            }
                        );

      }])

      .controller('AboutController', ['$scope', 'corporateFactory',function($scope,corporateFactory){
          $scope.showLeaders=false; 
          $scope.message="Loading ...";
          $scope.leaders = corporateFactory.getLeaders()
              .query(
              function(response){
                  
                  $scope.leaders = response;
                  
              },function(response){
                   $scope.message = "Error: "+response.status + " " + response.statusText;
              });
         
          
      }])


;
