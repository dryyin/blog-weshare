app.controller('artController',function ($scope,artService,loginService) {


    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.getAllArticles( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };


    $scope.getAllArticles = function(page,rows){
        artService.getAllArticles(page,rows).success(
            function(response){
                //更新分页插件
                $scope.list = response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }


    $scope.isLogin = function(){
        loginService.isLogin().success(
            function(response){
                if(response.success){
                    $scope.nuser = response.object;
                }else{
                    location.href="../admin"
                }
            }
        );
    }

    $scope.del = function (id) {
        confirm("确定要删除吗？")

        artService.del(id).success(
            function (response) {
                if(response.success){
                    toastr.success(response.message);
                    $scope.reloadList();
                }else{
                    toastr.info("未知错误");
                }
            }
        );
    }

    $scope.findone = function (id) {
        artService.findone(id).success(
            function (response) {
                if(response.success){
                    $scope.article = response.object;

                    $('#articleBody').html($scope.article.aText);

                }
            }
        );
    }



});