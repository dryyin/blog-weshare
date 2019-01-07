app.controller('writeController',function ($scope,$rootScope,mainService) {

    $scope.getKindList = function () {
        mainService.getKindList().success(
            function (response) {
                if(response.success){


                    $scope.parentList = response.object;
                }else{
                }
            }
        );
    }


    $scope.findByParentId = function () {
        mainService.findByParentId($scope.selectParent).success(
            function (response) {
                $scope.childList = response.object;
            }
        );
    }

    $scope.article = {};

    $scope.add = function () {

        if($scope.selectChild != undefined){
            $scope.article.kId = $scope.selectChild;
        }else{
            $scope.article.kId = $scope.selectParent;
        }

        $scope.article.aText = editor.txt.html();


        mainService.addArticle($scope.article).success(
            function (response) {
                if(response.success){
                    toastr.success(response.message);
                    setTimeout(function () {
                        location.href = "../";
                    },1000)
                }else{
                    toastr.error(response.message);
                }
            }
        );

    }

    $scope.isLogin = function () {
        mainService.isLogin().success(
            function (response) {
                if(response.success){
                    $scope.unuser = response.object;
                }else{
                    location.href = "../";
                }
            }
        );
    }

    var E = window.wangEditor
    var editor = new E('#bar','#editor');
    editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
    editor.customConfig.zIndex = 1000;
    editor.customConfig.onchange = function (ehtml) {
        // 监控变化，同步更新到 textarea
        var $text = $('#text');
        $text.html(ehtml);
    }
    editor.create();

})