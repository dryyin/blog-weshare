app.service('contactService',function($http){
	
	this.sendMessage = function(message){
		return $http.get('../contact/sendMessage?message='+message);
	}
});