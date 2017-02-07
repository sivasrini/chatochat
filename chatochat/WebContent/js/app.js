var app=angular.module('chat',[])
app.controller('mycon',function($scope,$http,$location,$window)
		
		{
	

	var url="http://"+$window.location.host+"/chatochat";
	
	$scope.login=function()
	
	{
               $http.post(url+'/index/'+$scope.username+'/'+$scope.password).success(function(data)
            	   
            	   
            	   {
            		   
            		   $window.location.href = "http://localhost:8087/fronttend/index.html";
            	   })
            		   
                     console.log(data);
               
	}
		}
	
		