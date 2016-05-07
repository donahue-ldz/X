define(['jquery', 'jquery.blockUI'], function () {
        return {
            parseNickNameCn: function (richName) {
                if (!richName) return "";
                return richName.split("/")[0];
            },
            parseEmpId: function (richName) {
                if (!richName) return "";
                if (richName.split("/").length > 1) return richName.split("/")[1];
                else return "";
            },
            createUserName: function (richName) {
                var name = this.parseNickNameCn(richName);
                var empId = this.parseEmpId(richName);
                if (name == "") return "";
                if (empId != "") return "<a target='_blank' href='https://work.alibaba-inc.com/work/work/u/" + empId + "'>" + (name || "") + "</a>";
                if (name != "")  return "<a href='https://work.alibaba-inc.com/work/search?keywords=" + name + "&type=person' target='_blank'>" + (name || "") + "</a>";

            },
            fmtValue: function (value) {
                var fmtValue = (value = !null ? value : undefined) == undefined ? "" : value;
                if (typeof (value) == "string")
                    fmtValue = this.html2Escape(fmtValue);
                if (typeof(fmtValue) == "object") {
                    fmtValue = JSON.stringify(fmtValue, null, 2);
                    fmtValue = this.html2Escape(fmtValue);
                }

                return fmtValue;
            },
            mask: function (msg) {
                //if($(window).height()>$("body").height()) {
                //    $("html").css("height", "100%");
                //    $("body").css("height", "100%");
                //}
                if (!msg) msg = "请稍后...";
                $(window).block({
                    message: '<h4>' + msg + '</h4>',
                    css: {
                        border: '3px solid khaki',

                    },
                });
            },
            unMask: function () {
                $(window).unblock();
            },
            html2Escape: function (sHtml) {
                return sHtml.replace(/[<>&"]/g, function (c) {
                    return {'<': '&lt;', '>': '&gt;', '&': '&amp;', '"': '&quot;'}[c];
                });
            },
            versionAlert: function (message, version, callback) {
                if (!message || message == "") {
                    message = "<p style='color: red;font-size: larger'>该功能存在版本问题,请不要随意使用!</p> <p>如果要使用,请确定所依赖的AMS版本" + ((version || "" == "") ? "是最新版本" : ">=" + version);
                    message += "! 且不影响该命名空间下的其他使用者...</p>"
                    message += "<p style='color: red;font-size: larger'>请选择是否执行该功能?</p>"
                }
                $.messager.confirm("警告", message, function () {
                    callback()
                });
            },
            page: function (pager, func, options, containerID) {
                var pageBarButtons = pager.pageBarButtons;
                var html = "";
                $.each(pageBarButtons, function (index, button) {
                    html += "<li class ='" + button.status + "'><a>" + button.key + "</a></li>"
                });
                var pageSizeOptions = pager.pageSizeOptions;
                var optionHtml = "";
                $.each(pageSizeOptions, function (index, option) {
                    if (pager.pageSize == option)
                        optionHtml += "<option value='" + option + "' selected>" + option + "</option>";
                    else
                        optionHtml += "<option value='" + option + "'>" + option + "</option>";

                });
                if (containerID) {
                    $("#" + containerID + " #select_pageSize").html(optionHtml);
                    $("#" + containerID + " #currentPage").text(pager.currentPage);

                    $("#" + containerID + " #totalPages").text(pager.totalPages);
                    $("#" + containerID + " #totalRecordsNum").text(pager.totalRecords);

                    $("#" + containerID + " .pagination").html(html);
                } else {
                    $("#select_pageSize").html(optionHtml);
                    $("#currentPage").text(pager.currentPage);

                    $("#totalPages").text(pager.totalPages);
                    $("#totalRecordsNum").text(pager.totalRecords);

                    $(".pagination").html(html);
                }
                $(".pagination > li.normal > a").css("cursor", "pointer");


                $("ul.pagination > li").unbind().on("click", function () {
                    var hash = location.hash;
                    if ($(this).attr("class") == "disabled") return;
                    if ($(this).attr("class") == "active") return;
                    var text = $(this).text();
                    var pageNO = $(this).text();
                    var pageSize = $("#select_pageSize").find("option:checked").val();


                    var currentPage = $("#currentPage").text();
                    var totalPages = $("#totalPages").text();
                    if (text == "上一页") {
                        pageNO = parseInt(currentPage) - 1;
                    }
                    if (text == "下一页") {
                        pageNO = parseInt(currentPage) + 1;
                    }
                    if (text == "首页") {
                        pageNO = 1;
                    }
                    if (text == "尾页") {
                        pageNO = parseInt(totalPages);
                    }
                    var data = {pageNO: parseInt("" + pageNO), pageSize: pageSize};
                    $.extend(options, data);
                    func(options);
                    location.hash = hash;

                });

                $("#select_pageSize").unbind().on("change", function () {

                    var pageSize = $(this).find("option:checked").val();
                    var currentPage = $("#currentPage").text();
                    var data = {pageNO: currentPage, pageSize: pageSize};
                    $.extend(options, data);
                    func(options);

                });


            },
            /**
             *
             * @param format
             * @param timestamp  时间戳，毫秒为单位
             * @returns {*|void|XML|string}
             */
            date: function (format, timestamp) {
                var a, jsdate = new Date(timestamp);
                var pad = function (n, c) {
                    if ((n = n + "").length < c) {
                        return new Array(++c - n.length).join("0") + n;
                    } else {
                        return n;
                    }
                };
                var txt_weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
                var txt_ordin = {1: "st", 2: "nd", 3: "rd", 21: "st", 22: "nd", 23: "rd", 31: "st"};
                var txt_months = ["", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
                var f = {
                    // Day
                    d: function () {
                        return pad(f.j(), 2)
                    },
                    D: function () {
                        return f.l().substr(0, 3)
                    },
                    j: function () {
                        return jsdate.getDate()
                    },
                    l: function () {
                        return txt_weekdays[f.w()]
                    },
                    N: function () {
                        return f.w() + 1
                    },
                    S: function () {
                        return txt_ordin[f.j()] ? txt_ordin[f.j()] : 'th'
                    },
                    w: function () {
                        return jsdate.getDay()
                    },
                    z: function () {
                        return (jsdate - new Date(jsdate.getFullYear() + "/1/1")) / 864e5 >> 0
                    },

                    // Week
                    W: function () {
                        var a = f.z(), b = 364 + f.L() - a;
                        var nd2, nd = (new Date(jsdate.getFullYear() + "/1/1").getDay() || 7) - 1;
                        if (b <= 2 && ((jsdate.getDay() || 7) - 1) <= 2 - b) {
                            return 1;
                        } else {
                            if (a <= 2 && nd >= 4 && a >= (6 - nd)) {
                                nd2 = new Date(jsdate.getFullYear() - 1 + "/12/31");
                                return date("W", Math.round(nd2.getTime() / 1000));
                            } else {
                                return (1 + (nd <= 3 ? ((a + nd) / 7) : (a - (7 - nd)) / 7) >> 0);
                            }
                        }
                    },

                    // Month
                    F: function () {
                        return txt_months[f.n()]
                    },
                    m: function () {
                        return pad(f.n(), 2)
                    },
                    M: function () {
                        return f.F().substr(0, 3)
                    },
                    n: function () {
                        return jsdate.getMonth() + 1
                    },
                    t: function () {
                        var n;
                        if ((n = jsdate.getMonth() + 1) == 2) {
                            return 28 + f.L();
                        } else {
                            if (n & 1 && n < 8 || !(n & 1) && n > 7) {
                                return 31;
                            } else {
                                return 30;
                            }
                        }
                    },

                    // Year
                    L: function () {
                        var y = f.Y();
                        return (!(y & 3) && (y % 1e2 || !(y % 4e2))) ? 1 : 0
                    },
                    //o not supported yet
                    Y: function () {
                        return jsdate.getFullYear()
                    },
                    y: function () {
                        return (jsdate.getFullYear() + "").slice(2)
                    },

                    // Time
                    a: function () {
                        return jsdate.getHours() > 11 ? "pm" : "am"
                    },
                    A: function () {
                        return f.a().toUpperCase()
                    },
                    B: function () {
                        // peter paul koch:
                        var off = (jsdate.getTimezoneOffset() + 60) * 60;
                        var theSeconds = (jsdate.getHours() * 3600) + (jsdate.getMinutes() * 60) + jsdate.getSeconds() + off;
                        var beat = Math.floor(theSeconds / 86.4);
                        if (beat > 1000) beat -= 1000;
                        if (beat < 0) beat += 1000;
                        if ((String(beat)).length == 1) beat = "00" + beat;
                        if ((String(beat)).length == 2) beat = "0" + beat;
                        return beat;
                    },
                    g: function () {
                        return jsdate.getHours() % 12 || 12
                    },
                    G: function () {
                        return jsdate.getHours()
                    },
                    h: function () {
                        return pad(f.g(), 2)
                    },
                    H: function () {
                        return pad(jsdate.getHours(), 2)
                    },
                    i: function () {
                        return pad(jsdate.getMinutes(), 2)
                    },
                    s: function () {
                        return pad(jsdate.getSeconds(), 2)
                    },
                    //u not supported yet

                    // Timezone
                    //e not supported yet
                    //I not supported yet
                    O: function () {
                        var t = pad(Math.abs(jsdate.getTimezoneOffset() / 60 * 100), 4);
                        if (jsdate.getTimezoneOffset() > 0) t = "-" + t; else t = "+" + t;
                        return t;
                    },
                    P: function () {
                        var O = f.O();
                        return (O.substr(0, 3) + ":" + O.substr(3, 2))
                    },
                    //T not supported yet
                    //Z not supported yet

                    // Full Date/Time
                    c: function () {
                        return f.Y() + "-" + f.m() + "-" + f.d() + "T" + f.h() + ":" + f.i() + ":" + f.s() + f.P()
                    },
                    //r not supported yet
                    U: function () {
                        return Math.round(jsdate.getTime() / 1000)
                    }
                };

                return format.replace(/[\\]?([a-zA-Z])/g, function (t, s) {
                    if (t != s) {
                        // escaped
                        ret = s;
                    } else if (f[s]) {
                        // a date function exists
                        ret = f[s]();
                    } else {
                        // nothing special
                        ret = s;
                    }
                    return ret;
                });
                //test
                alert(date('Y-m-d H:i:s', (new Date).getTime() / 1000));
                alert(date('Y-m-d', (new Date).getTime() / 1000));
                alert(date('Y-m-d H:i:s', '1355252653'));
            },

            /**
             * 对象的拷贝，js中对象数组赋值也就是引用
             * 实现对象的copy
             * @constructor
             */
            copy: function (obj) {
                var o, i, j, k;
                if (typeof(obj) != "object" || obj === null)return obj;
                if (obj instanceof (Array)) {
                    o = [];
                    i = 0;
                    j = obj.length;
                    for (; i < j; i++) {
                        if (typeof(obj[i]) == "object" && obj[i] != null) {
                            o[i] = arguments.callee(obj[i]);
                        }
                        else {
                            o[i] = obj[i];
                        }
                    }
                }
                else {
                    o = {};
                    for (i in obj) {
                        if (typeof(obj[i]) == "object" && obj[i] != null) {
                            o[i] = arguments.callee(obj[i]);
                        }
                        else {
                            o[i] = obj[i];
                        }
                    }
                }

                return o;

            },
            //深复制
            clone: function (obj) {
                if (obj === null) return null;
                var o = Array.isArray(obj) ? [] : {};
                for (var i in obj) {
                    o[i] = (obj[i] instanceof Date) ? new Date(obj[i].getTime()) : (typeof obj[i] === "object" ? arguments.callee(obj[i]) : obj[i]);
                }
                return o;
            },
            isArray: function (arr) {
                return Object.prototype.toString.apply(arr) === "[object Array]";
            },

            pageJump: function (url, target) {
                var a = document.createElement('a');
                a.href = url;
                a.target = target;
                document.body.appendChild(a);
                a.click();
            },
            difference: function (array1, array2) {

                var r = new Array();
                $.each(array1, function (index, ele) {
                    if ($.inArray(ele, array2) == -1) r.push(ele);
                });
                return r;
            },
            disabledClick: function (e) {
                $(".disableAction").unbind().click(function (e) {
                    e.preventDefault();
                });
            },
            reverse: function (s) {
                return s.split("").reverse().join("");
            },

        }
    }
)

