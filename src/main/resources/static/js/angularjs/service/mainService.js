app.service('mainService',function ($http) {

    this.getKindList = function () {
        return $http.get('../kind/findall');
    }

    this.findByParentId = function (pId) {
        return $http.get('../kind/po/findbyparent?pId='+pId);
    }

    this.addArticle = function (entity) {
        return $http.post('../article/add',entity);
    }

    this.getAllArticles = function (page,rows,entity) {
        return $http.post('../article/init?page='+page+'&rows='+rows,entity);
    }

    this.findHotArticle = function () {
        return $http.get('../article/findhot');
    }

    this.isLogin = function () {
        return $http.get('../useril');
    }
    this.logout = function () {
        return $http.get('../logout');
    }
})