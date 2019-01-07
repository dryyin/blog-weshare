app.controller('countController',function ($scope,countService,loginService) {

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



    $scope.getBaseParam = function () {
        countService.getBaseParam().success(
            function (response) {
                if(response.success){
                    $scope.baseParam = response.object;
                }
            }
        );
    }

    $.getJSON('../count/pv', function (csv) {
        var chart = Highcharts.chart('firCharts', {
            chart: {
                type: 'area'
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                type: 'datetime',
                dateTimeLabelFormats: {
                    day: '%Y-%m-%d'
                }
            },
            yAxis: {
                title: {
                    text: 'pv量'
                },
                labels: {
                }
            },
            plotOptions: {
                series:{
                    pointStart: Date.UTC(csv.year, csv.month-1, csv.day), // 开始值
                    pointInterval: 24 * 3600 * 1000 // 间隔一天
                }
            },
            series: [{
                name: 'pv量',
                data: csv.gPvs,
            }],
            credits: {
                enabled: false     //不显示LOGO
            }
        });
    });






    $.getJSON('../count/articlepro', function (csv) {
// Make monochrome colors and set them as default for all pies
        Highcharts.getOptions().plotOptions.pie.colors = (function () {
            var colors = [],
                base = Highcharts.getOptions().colors[0],
                i;
            for (i = 0; i < 15; i += 1) {
                // Start out with a darkened base color (negative brighten), and end
                // up with a much brighter color
                colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
            }
            return colors;
        }());
// 初始化图表
        var chart = Highcharts.chart('pieCharts', {
            title: {
                text: ''
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            credits: {
                enabled: false     //不显示LOGO
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '占比',
                data: csv.object
            }]
        });
    });

    $.getJSON('../count/kindclick', function (csv) {
        var chart = Highcharts.chart('yearCharts', {
            chart: {
                type: 'bar'
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            credits: {
                enabled: false     //不显示LOGO
            },
            xAxis: {
                categories: ['操作系统', '前端设计', '后端开发', '算法', '网络','软件','开源框架','数据库','其他'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '点击量',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                valueSuffix: ''
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: false,
                        allowOverlap: true // 允许数据标签重叠
                    }
                }
            },
            series: [{
                name:'次数',
                data: csv.object
            }]
        });
    });
});