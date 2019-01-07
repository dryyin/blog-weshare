app.service('artService',function ($http) {

    this.getAllArticles = function (page,rows) {
        return $http.get('../article/admin/findall?page='+page+'&rows='+rows);
    }

    this.del = function (id) {
        return $http.get('../article/article/del?id='+id);
    }

    this.findone = function (id) {
        return $http.get('../article/findesc?aId='+id);
    }

})