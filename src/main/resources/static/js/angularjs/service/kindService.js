app.service('kindService',function ($http) {

    this.getAllParentKinds = function (page,rows,pId) {
        return $http.get('../kind/findparent?page='+page+'&rows='+rows+'&pId='+pId);
    }

    this.addKind = function (entity,pId) {
        return $http.post('../kind/addkind?pId='+pId,entity);
    }

})