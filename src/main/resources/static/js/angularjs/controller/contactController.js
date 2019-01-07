app.controller('contactController',function($scope, contactService){

	$scope.sendMessage = function(){
		contactService.sendMessage($scope.message).success(
				function(response){
					 $('.chat-thread').append('<li class="left">' + response.text + '</li>');
					 $('.chat-thread').scrollTop($('.chat-thread')[0].scrollHeight);
				}
		);
	}

})