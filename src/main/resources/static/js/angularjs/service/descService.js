app.service('descService',function ($http) {
    this.finDesc = function (id) {
        return $http.get('../article/findesc?aId='+id);
    }
})