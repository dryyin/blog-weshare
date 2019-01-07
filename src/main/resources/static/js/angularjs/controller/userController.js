app.controller('userController',function ($scope,userService,loginService) {


    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.getAllUsers( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
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


    $scope.getAllUsers = function(page,rows){
        userService.getAllUsers(page,rows).success(
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



});