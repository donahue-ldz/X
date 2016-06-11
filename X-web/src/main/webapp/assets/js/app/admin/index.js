var ChartsAmcharts = function () {

    var chartConfig = function (data,option) {
        return $.extend({
            "type": "serial",
            "theme": "light",
            "pathToImages": App.getGlobalPluginsPath() + "amcharts/amcharts/images/",
            "autoMargins": false,
            "marginLeft": 50,
            "marginRight": 50,
            "marginTop": 50,
            "marginBottom": 50,

            "fontFamily": 'Open Sans',
            "color": '#888',

            "dataProvider": data,
            "valueAxes": [{
                "axisAlpha": 0,
                "position": "left"
            }],
            "startDuration": 1,
            "graphs": [{
                "alphaField": "alpha",
                "balloonText": "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>",
                "dashLengthField": "dashLengthColumn",
                "fillAlphas": 1,
                "title": "访问人数",
                "type": "column",
                "valueField": "visited"
            }, {
                "balloonText": "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>",
                "bullet": "round",
                "dashLengthField": "dashLengthLine",
                "lineThickness": 3,
                "bulletSize": 7,
                "bulletBorderAlpha": 1,
                "bulletColor": "#FFFFFF",
                "useLineColorForBulletBorder": true,
                "bulletBorderThickness": 3,
                "fillAlphas": 0,
                "lineAlpha": 1,
                "title": "访问人数",
                "valueField": "visited"
            }],
            "categoryField": "time",
            "categoryAxis": {
                "gridPosition": "start",
                "axisAlpha": 0,
                "tickLength": 0,
                "labelRotation": 45
            },
            "export": {
                "enabled": true,
            }
        },option);
    };
    var visitedReport = function (data,config) {
        $.post("/admin/json/IndexRequest/visitedReport.json", {
            fromDay: data && data["fromDay"] ? data["fromDay"] : $("#fromDay").val(),
            toDay: data && data["toDay"] ? data["toDay"] : $("#toDay").val()
        }, function (result) {
            if (result.success) {
                var data = result.objList;
                var chart = AmCharts.makeChart("chart_visited", chartConfig(data,config||{}));
                $('#chart_visited').closest('.portlet').find('.fullscreen').click(function () {
                    chart.invalidateSize();
                });
            } else {
                console.log(result.errorMsg);
            }
        })
    };
    var registerReport = function (data,config) {
        $.post("/admin/json/IndexRequest/registerReport.json", {
            fromDay: data && data["fromDay"] ? data["fromDay"] : $("#register_fromDay").val(),
            toDay: data && data["toDay"] ? data["toDay"] : $("#register_toDay").val()
        }, function (result) {
            if (result.success) {
                var data = result.objList;
                var chart = AmCharts.makeChart("chart_register", chartConfig(data,config||{}));
                $('#chart_register').closest('.portlet').find('.fullscreen').click(function () {
                    chart.invalidateSize();
                });
            } else {
                console.log(result.errorMsg);
            }
        })
    };


    return {
        visitedReport: visitedReport,
        registerReport:registerReport
    }

}();

jQuery(document).ready(function () {
    $("#btnDay").click(function () {
        var data = {
            fromDay: $("#fromDay").val(),
            toDay: $("#toDay").val()
        };
        ChartsAmcharts.visitedReport(data);
    });
    $("#btnRegisterDay").click(function () {
        var data = {
            fromDay: $("#register_fromDay").val(),
            toDay: $("#register_toDay").val()
        };
        ChartsAmcharts.registerReport(data,{
            "graphs": [{
                "alphaField": "alpha",
                "balloonText": "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>",
                "dashLengthField": "dashLengthColumn",
                "fillAlphas": 1,
                "title": "注册人数",
                "type": "column",
                "valueField": "registerNum"
            }, {
                "balloonText": "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>",
                "bullet": "round",
                "dashLengthField": "dashLengthLine",
                "lineThickness": 3,
                "bulletSize": 7,
                "bulletBorderAlpha": 1,
                "bulletColor": "#FFFFFF",
                "useLineColorForBulletBorder": true,
                "bulletBorderThickness": 3,
                "fillAlphas": 0,
                "lineAlpha": 1,
                "title": "注册人数",
                "valueField": "registerNum"
            }],
        });
    });
    $("#btnDay").click();
    $("#btnRegisterDay").click();

});