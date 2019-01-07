app.controller('descController',function ($scope, descService,mainService){

    var url = location.toString();
    var urlList = url.split("?");
    var aId = urlList[1];
    var find = aId.split("=");
    var id = find[1];


    descService.finDesc(id).success(
        function (response) {
            if(response.success){
                $scope.article = response.object;

                $('#articleText').html(""+$scope.article.aText);
            }
        }
    );

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

        location.href = "../";
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
});