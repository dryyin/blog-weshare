app.service('userService',function ($http) {

    this.getAllUsers = function (page,rows) {
        return $http.get('../user/findall?page='+page+'&rows='+rows);
    }

})