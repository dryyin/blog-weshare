app.controller('mainController',function ($scope,mainService) {

    $scope.article = {};

    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.getAllArticles( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage , $scope.article);
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 5,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    $scope.getAllArticles = function(page,rows,entity){
        mainService.getAllArticles(page,rows,entity).success(
            function(response){
                //更新分页插件
                $scope.list = response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }

    $scope.findHotArticle = function(){
        mainService.findHotArticle().success(
            function (response) {
                if(response.success){
                    $scope.hotList = response.object;
                }
            }
        );
    }


    $scope.getKindList = function () {
        mainService.getKindList().success(
            function (response) {
                if(response.success){
                    $scope.one = response.object[0];
                    $scope.two = response.object[1];
                    $scope.three = response.object[2];
                    $scope.four = response.object[3];
                    $scope.five = response.object[4];
                    $scope.six = response.object[5];
                    $scope.seven = response.object[6];
                    $scope.eight = response.object[7];
                    $scope.nine = response.object[8];
                }else{
                }
            }
        );
    }

    $scope.to = function (kId) {
       $scope.article.kId = kId;
       $scope.reloadList();
    }

    $scope.refresh = function () {
        $scope.article = {};
        $scope.reloadList();
    }

    $scope.read = function (id) {
        location.href = "../read?id="+id;
    }

    $scope.isLogin = function () {
        mainService.isLogin().success(
            function (response) {
                if(response.success){
                    $scope.unuser = response.object;
                }else{

                }
            }
        );
    }

    $scope.writeArticle = function () {
        if($scope.unuser == null){
            location.href = "../l";
        }else{
            location.href = "../w";
        }
    }

    $scope.logout = function () {
        mainService.logout();
        $scope.unuser = null;
    }



})