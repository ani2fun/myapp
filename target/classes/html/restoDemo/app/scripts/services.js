'use strict';

angular.module('confusionApp')
        .constant("baseURL","https://quiet-mesa-68785.herokuapp.com/service/")
        .service('menuFactory', ['$resource','baseURL', function($resource,baseURL) {
    
        
                this.getDishes = function(){
                    
                     return $resource(baseURL+"dishes/:id",null,  {'update':{method:'PUT' }});
                    
                };

                this.getPromotion = function(){
                    
                    return $resource(baseURL+"promotions/:id",null,  {'update':{method:'PUT' }});
                    
                };            
              
                        
        }])

        .factory('corporateFactory', ['$resource','baseURL', function($resource,baseURL) {
    
            var corpfac = {};
    
            corpfac.getLeaders = function(){
              
                return $resource(baseURL + "leadership/:id",null,{'update':{method:'PUT'} });
            };
    
               return corpfac;
        }])


;
