var ChartsAmcharts = function () {

    var chartConfig = function (data) {
        return {
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
                "title": "总积分",
                "type": "column",
                "valueField": "scores"
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
                "title": "总积分",
                "valueField": "scores"
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
        }
    };

    var yearReport = function (data) {
        $.post("/admin/json/CreditReportRequest/yearReport.json", {
            studentID: data && data["studentID"] ? data["studentID"] : $("#studentID").val()
        }, function (result) {
            if (result.success) {
                var data = result.objList;
                var chart = AmCharts.makeChart("chart_year", chartConfig(data));
                $('#chart_year').closest('.portlet').find('.fullscreen').click(function () {
                    chart.invalidateSize();
                });
            } else {
                console.log(result.errorMsg);
            }
        })

    }

    var monthReport = function (data) {
        $.post("/admin/json/CreditReportRequest/monthReport.json", {
            studentID: $("#studentID").val(),
            fromMonth: data && data["fromMonth"] ? data["fromMonth"] : $("#fromMonth").val(),
            toMonth: data && data["toMonth"] ? data["toMonth"] : $("#toMonth").val()
        }, function (result) {
            if (result.success) {
                var data = result.objList;
                var chart = AmCharts.makeChart("chart_month", chartConfig(data));

                $('#chart_year').closest('.portlet').find('.fullscreen').click(function () {
                    chart.invalidateSize();
                });
            } else {
                console.log(result.errorMsg);
            }
        })
    }

    var dayReport = function (data) {
        $.post("/admin/json/CreditReportRequest/dayReport.json", {
            studentID: data && data["studentID"] ? data["studentID"] : $("#studentID").val(),
            fromDay: data && data["fromDay"] ? data["fromDay"] : $("#fromDay").val(),
            toDay: data && data["toDay"] ? data["toDay"] : $("#toDay").val()
        }, function (result) {
            if (result.success) {
                var data = result.objList;
                var chart = AmCharts.makeChart("chart_day", chartConfig(data));
                $('#chart_year').closest('.portlet').find('.fullscreen').click(function () {
                    chart.invalidateSize();
                });
            } else {
                console.log(result.errorMsg);
            }
        })
    }


    return {
        yearReport: yearReport,
        monthReport: monthReport,
        dayReport: dayReport
    }

}();

jQuery(document).ready(function () {
    var studentID = $("#studentID").val();
    if (studentID) {
        ChartsAmcharts.yearReport({studentID: studentID});
        ChartsAmcharts.monthReport({studentID: studentID});
        ChartsAmcharts.dayReport({studentID: studentID});
    }

    $("#setStudentForm").submit(function (e) {
        e.preventDefault();
        if ($.trim($("#set").text()) === "设定") {
            $("#studentID").prop("readOnly", true);
            $("#set").text("取消设定");
            ChartsAmcharts.yearReport();
            ChartsAmcharts.monthReport();
            ChartsAmcharts.dayReport();

        } else {
            location.href = location.pathname;
        }
    });
    $("#btnDay").click(function () {
        var data = {
            fromDay: $("#fromDay").val(),
            toDay: $("#toDay").val()
        };
        ChartsAmcharts.dayReport(data);
    });
    $("#btnMonth").click(function () {
        var data = {
            fromMonth: $("#fromMonth").val(),
            toMonth: $("#toMonth").val()
        };
        ChartsAmcharts.monthReport(data);
    })
});