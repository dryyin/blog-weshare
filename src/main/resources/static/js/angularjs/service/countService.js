app.service('countService',function ($http) {

    this.getBaseParam = function () {
        return $http.get('../count/basedata');
    }

})