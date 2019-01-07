app.controller('kindController',function ($scope,kindService,loginService) {

    $scope.parentId = 0;

    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.getAllParentKinds( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.parentId);
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

    $scope.parent = {};

    $scope.getAllParentKinds = function(page,rows,parentId){
        kindService.getAllParentKinds(page,rows,parentId).success(
            function(response){
                //更新分页插件
                $scope.kindList = response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }

    $scope.kind = {};

    $scope.addKind = function(){
        kindService.addKind($scope.kind,$scope.parentId).success(
            function (response) {
                if(response.success){
                    toastr.success(response.message);
                    $scope.kind = {};
                    $scope.reloadList();
                }else{
                    toastr.info(response.message);
                }
            }
        );
    }

    $scope.findByParent = function (parentId,parentText,kIsparent) {

        if(kIsparent == 1){
            $scope.parent.kId = parentId;
            $scope.parent.kText = parentText;

            $scope.parentId = $scope.parent.kId;
            $scope.reloadList();
        }else{
            toastr.info("该分类不能再划分");
        }



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

    $scope.back = function () {
        $scope.parentId = 0;

        $scope.parent = {};

        $scope.reloadList();
    }



});