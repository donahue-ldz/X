define(['jquery',
        'ztree',
        "record",
        "utils",
        'jquery.blockUI',
        "bootstrap",
        "jquery.bootstrap"], function ($, ztree, record, utils) {

        var contexts = {};
        var dataFilter = function (treeId, parentNode, childNodes) {
            if (!childNodes) return null;
            childNodes = childNodes.objList;
            if (!childNodes) return null;

            for (var i = 0, l = childNodes.length; i < l; i++) {
                var record = childNodes[i].record;
                var payload = JSON.parse(record.payload);
                var renderFields = contexts[treeId].renderFields;
                if (renderFields) {
                    var name = "<span>";
                    for (var j = 0; j < renderFields.length; j++) {
                        var fieldValue = payload[renderFields[j]];
                        if (fieldValue == "") fieldValue = "&nbsp;&nbsp;&nbsp;&nbsp;";
                        name += "<span class='fieldRender'>" + fieldValue + "</span>"
                    }
                    name += "</span>";
                    childNodes[i].richName = name;
                }
                else {
                    childNodes[i].richName = childNodes[i].name;
                }
            }

            return childNodes;
        };

        var beforeRemove = function (treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj(treeId);
            zTree.selectNode(treeNode);
            record.showDelPayloadModal(treeNode.record, function () {
                zTree.removeNode(treeNode, false);
            });
            return false;
        };


        var beforeRename = function (treeId, treeNode, newName) {
            if (newName.length == 0) {
                alert("节点名称不能为空.");
                return false;
            }
            return true;
        };
        var beforeEditName = function (treeId, treeNode) {
            record.showEditPayloadModal(treeNode.record, contexts[treeId].tableKeys, function () {
                $.each($("#formEditor2>.form-item"), function (index, ele) {
                    var lable = $(ele).find("label").text();
                    if ($.inArray(lable, contexts[treeId].tableKeys) != -1) {
                        $(ele).find(".value-item").prop("disabled", true);
                        return false;

                    }
                });
            });
            return false;
        };
        var setRequestParams = function (treeId, paramsObj) {
            if (paramsObj)
                contexts[treeId].config.async.otherParam = paramsObj;
        };

        var addHoverDom = function (treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if ($("#addBtn_" + treeNode.tId).length > 0) return;
            if ($("#infoBtn_" + treeNode.tId).length > 0) return;
            if ($("#historyBtn_" + treeNode.tId).length > 0) return;

            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='新增子节点' onfocus='this.blur();'></span>";
            var infoStr = "<span class='custom-btn glyphicon glyphicon-eye-open' id='infoBtn_" + treeNode.tId
                + "' title='查看详情' onfocus='this.blur();'></span>";

            var historyStr = "<span class='custom-btn glyphicon glyphicon-compressed' id='historyBtn_" + treeNode.tId
                + "' title='历史版本' onfocus='this.blur();'></span>";
            var selectedStr = "<span class='custom-btn glyphicon  glyphicon-ok' id='selectedBtn_" + treeNode.tId
                + "' title='节点选择' onfocus='this.blur();'></span>";

            if (contexts[treeId].editable) sObj.after(addStr);
            if (!contexts[treeId].editable) sObj.after(selectedStr);
            sObj.parent().append(infoStr);
            sObj.parent().append(historyStr);

            var addBtn = $("#addBtn_" + treeNode.tId);
            var infoBtn = $("#infoBtn_" + treeNode.tId);
            var historyBtn = $("#historyBtn_" + treeNode.tId);
            var selectedBtn = $("#selectedBtn_" + treeNode.tId);

            if (addBtn) addBtn.bind("click", function () {
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                var url;
                if (location.href.indexOf("/lite/") != -1)
                    url = "/json/DataToolRequest/putRecord.json";
                var params = {
                    ns: $("#nsSelect").find("option:selected").val(),
                    table: $("#selectedTable >.tableName").text(),
                    dataEnvEn: $("#dataEnvSelect").find("option:checked").val()

                };
                record.putRecordModal(params, url, function () {
                    $.each($("#formEditor1>.form-item"), function (index, ele) {
                        var lable = $(ele).find("label").text();
                        if (lable == "__sys_fallback_parent") {
                            $(ele).find(".value-item").val(treeNode.name);
                            $(ele).find(".value-item").prop("disabled", true);
                            return false;

                        }
                    });

                }, function (payload) {
                    payload = JSON.parse(payload);
                    zTree.addNodes(treeNode, {
                        id: payload["fallback_key"],
                        pId: treeNode.id,
                        name: payload["fallback_key"]
                    });
                    $("#recordAddModal").modal("hide");
                    $.each($(".notice-num"), function (index, ele) {
                        var num = parseInt($(ele).text());
                        $(ele).text(++num);
                    })

                });
                return false;
            });
            if (infoBtn)infoBtn.bind("click", function () {
                record.recordInfo(treeNode.record);
            })
            if (historyBtn) historyBtn.bind("click", function () {
                var url = '/list/recordHistory.htm?id=' + treeNode.record.id;
                var target = '_blank';
                utils.pageJump(url, target);
            });
            if (selectedBtn) selectedBtn.bind("click", function () {
                $(this).parentsUntil('th').parent().find(".mainTable-button .dimKeyValue").text(treeNode.name);
                $(this).parentsUntil("th").parent().find(".mainTable-treeViewDivWrapper").unbind().hide();
                $("#reloadData").change();
            });
        }
        var removeHoverDom = function (treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
            $("#infoBtn_" + treeNode.tId).unbind().remove();
            $("#historyBtn_" + treeNode.tId).unbind().remove();
            $("#selectedBtn_" + treeNode.tId).unbind().remove();

        };

        //异步加载之前调用,true调用 false不调用
        var beforeAsync = function (treeId, treeNode) {
            return true;

        };
        var onAsyncError = function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
            $("#" + treeId).parent().unblock();

        };

        var onAsyncSuccess = function (event, treeId, treeNode, msg) {
            $("#" + treeId).parent().unblock();
            //搜索之后节点的异步加载url就需要编程正常的url了,便于节点的展开
            isSearchRequest = false;
            if (typeof contexts[treeId].afterTreeInitCallback == "function")
                contexts[treeId].afterTreeInitCallback();
        };

        //每一棵树应用运行的上下文
        var Context = {
            tableKeys: new Array(),
            indexFields: new Array(),
            renderFields: new Array(),
            tableColumns: new Array(),
            ztreeID: "",             //树的ID
            editable: true,
            afterTreeInitCallback: null,
            isSearchRequest: false,  //是否是搜索请求
            config: {
                async: {
                    enable: true,
                    url: '/json/UserTableRequest/queryDimTableRecords.json',
                    autoParam: ["id", "name=parentKey", "level=lv"],
                    otherParam: [],
                    dataFilter: dataFilter
                },
                view: {
                    expandSpeed: "",
                    addHoverDom: addHoverDom,
                    removeHoverDom: removeHoverDom,
                    selectedMulti: false,
                    nameIsHTML: true,
                    showTitle: false
                },
                edit: {
                    enable: true,
                    removeTitle: "删除",
                    renameTitle: "编辑"
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "name",
                        pIdKey: "fallbackParentKey",
                        rootPId: ""
                    },
                    key: {
                        name: 'richName',
                    }
                },
                callback: {
                    beforeRemove: beforeRemove,
                    beforeRename: beforeRename,
                    beforeEditName: beforeEditName,
                    beforeAsync: beforeAsync,
                    onAsyncError: onAsyncError,
                    onAsyncSuccess: onAsyncSuccess
                },
            },
        };


        /**
         * 改变展示字段的时候刷新树
         */
        var refreshTreeForChangeFields = function (treeId, showFields) {

            var ztreeObject = $.fn.zTree.getZTreeObj(contexts[treeId].ztreeID);
            var nodes = ztreeObject.transformToArray(ztreeObject.getNodes());
            contexts[treeId].renderFields = showFields;
            for (var i = 0; i < nodes.length; i++) {
                var name = "<span>";
                var node = nodes[i];
                var record = node.record;
                var payload = JSON.parse(record.payload);
                for (var j = 0; j < showFields.length; j++) {
                    var fieldValue = payload[showFields[j]];
                    if (fieldValue == "") fieldValue = "&nbsp;&nbsp;&nbsp;&nbsp;";
                    name += "<span class='fieldRender'>" + fieldValue + "</span>"
                }
                name += "</span>";
                node.richName = name;
                ztreeObject.updateNode(node);
            }
        };
        var treeViewtemplate = function () {
            // 同步阻塞
            var view = function (/**模板要生成的树ID**/treeId, /**命名空间**/ns, /**表**/table, /**是否是可编辑的**/editable) {
                var ctx = utils.clone(Context);

                var keysUrl = "/json/UserTableRequest/queryTableColumns.json";
                var params = {ns: ns, table: table};
                var view;
                $.ajax({

                    type: "post",
                    url: keysUrl,
                    data: params,
                    async: false,
                    success: function (result) {
                        if (result.success) {
                            ctx.tableColumns = result.obj;
                            contexts[treeId] = ctx;
                            view = $('<div>');
                            var showFieldsDiv = $('<table class="table" class="showFieldsTable">')
                            showFieldsDiv.append(_makeShowFields(treeId, ctx.tableColumns))
                            view.append(showFieldsDiv);
                            var searchBoxDiv = $('<div class="search_box" style="margin-top: -5px">')
                                .append('<input type="text" class="treeSearch-text" placeholder="精确搜索,请输入值">')
                                .append('<input type="image" src="/assets/imgs/btn_search_box.gif" width="27" class="treeSearch-go" ' +
                                    'alt="Search" title="Search" ' +
                                    'style="position: relative;top: 1px;left: -3px;">');
                            var treeSearchDiv = $("<div class='treeSearch'>").append(searchBoxDiv);
                            view.append(showFieldsDiv)
                                .append(treeSearchDiv)
                                .append('<ul ' + 'id="' + treeId + '"' + ' class="ztree"></ul>');

                            view.find(".treeSearch-go").click(function () {
                                treeSearch(treeId, ctx.tableColumns, params);
                            });
                            ctx.ztreeID = treeId;
                            ctx.editable = editable !== undefined ? editable : true;
                        } else {
                            $.messager.alert("异常", "查询表列信息失败,异常信息: " + result.errorMsg);
                        }
                    }

                });
                return view;
            };

            var _makeShowFields = function (treeId, tableColumnsWithDesc) {
                var thead = $("<thead class='allFields'>");
                thead.append('<th>展示字段<a class="btn btn-link glyphicon glyphicon-refresh" id="refreshTree" style="margin-left: 20px"></a></th>');
                for (var column in tableColumnsWithDesc) {
                    var isKey = false;
                    var columnDesc = tableColumnsWithDesc[column];
                    var desc = Object.keys(columnDesc)[0];

                    var tip;
                    if (columnDesc[desc] == 0) {
                        isKey = true;
                        tip = "<div style='display: inline-block'><span class='showFields' data-toggle='tooltip' data-placement='bottom' title='" + (desc == "" ? "列备注未填" : desc) + "'>"
                            + column + "</span><span data-toggle='tooltip' data-placement='bottom' title='主键'>"
                            + "<img src='/assets/imgs/Key-icon.png' style='width: 16px'></span></div>";
                    } else if (columnDesc[desc] == 1) {
                        tip = "<div style='display: inline-block'><span class='showFields' data-toggle='tooltip' data-placement='bottom' title='" + (desc == "" ? "列备注未填" : desc) + "'>"
                            + column + "</span><span data-toggle='tooltip' data-placement='bottom' title='可检索'>"
                            + "<img src='/assets/imgs/indexField.png' width='30px'></span></div>";
                    } else {
                        tip = "<div style='display: inline-block'><span class='showFields' data-toggle='tooltip' data-placement='bottom' title='" + (desc == "" ? "列备注未填" : desc) + "'>" + column + "</span></div>";
                    }
                    var checkBox;
                    if (isKey) {
                        checkBox = $('<input type="checkbox" checked>')
                    } else {
                        checkBox = $('<input type="checkbox">')

                    }
                    thead.append($('<th>').append(checkBox).append(tip));
                }
                thead.find("#refreshTree").click(function () {
                    var showFields = _getShowFields(treeId);
                    refreshTreeForChangeFields(treeId, showFields);
                });
                return thead;
            };
            var _getShowFields = function (treeId) {
                var showFields = new Array();
                $.each($("#" + treeId).parent().find(".allFields").find("input[type='checkbox']:checked").parent().find("span.showFields"), function (index, ele) {
                    showFields.push($(ele).text());
                });
                return showFields;
            };
            var _parseSearchableFieldsFromColumns = function (tableColumns) {
                var searchableFields = new Array();
                for (var key in tableColumns) {
                    var keyWithDesc = tableColumns[key]
                    for (var field in keyWithDesc) {
                        if (keyWithDesc[field] == 0) {
                            searchableFields.push(key);
                        } //主键
                        else if (keyWithDesc[field] == 1) {
                            searchableFields.push(key)
                        }
                    }
                }
                return searchableFields;
            };

            var treeSearch = function (treeId, tableColumns, params) {

                var showFields = _getShowFields(treeId);
                var searchableFields = _parseSearchableFieldsFromColumns(tableColumns);
                var searchFields = new Array();
                $.each(showFields, function (index, ele) {
                    if ($.inArray(ele, searchableFields) != -1)
                        searchFields.push(ele);
                });
                var searchText = $("#" + treeId).parent().find(".treeSearch-text").val();
                treeInit(treeId,
                    $.extend({
                        "fields": searchFields,
                        "searchText": searchText
                    }, params),
                    showFields, true);
            };
            var treeInit = function (treeId, /**请求数据时参数**/params, /**节点上可以看的字段**/showFields, /**是否是搜索**/ isSearch) {
                var ztreeObject = $.fn.zTree.getZTreeObj(treeId);
                if (ztreeObject) ztreeObject.destroy();
                for (var key in contexts[treeId].tableColumns) {
                    var keyWithDesc = contexts[treeId].tableColumns[key]
                    for (var field in keyWithDesc) {
                        if (keyWithDesc[field] == 0) {
                            contexts[treeId].tableKeys.push(key);
                        } //主键
                        else if (keyWithDesc[field] == 1) {
                            contexts[treeId].indexFields.push(key)
                        }
                    }
                }
                setRequestParams(treeId, params);
                contexts[treeId].renderFields = showFields;
                contexts[treeId].isSearchRequest = isSearch;
                contexts[treeId].ztreeID = treeId;
                var blockMsg = "请稍后...";
                $("#" + treeId).parent().block({
                    message: '<h4>' + blockMsg + '</h4>',
                    css: {
                        border: '3px solid khaki',

                    },
                });
                if (isSearch) contexts[treeId].config.async.url = '/json/UserTableRequest/searchDimTree.json';
                if (!contexts[treeId].editable) contexts[treeId].config.edit.enable = false;
                $.fn.zTree.init($("#" + treeId), contexts[treeId].config);
            };

            var init = function (ns, /**treeID**/ treeId,
                                 /**维度表**/table, /**维度表的Key**/dimKeys,
                                 /**节点上可以看的字段**/showFields, /**是否是搜索**/ isSearch,
                                 /**树初始化完回调**/successCallBack) {
                var params = {ns: ns, table: table};
                contexts[treeId].afterTreeInitCallback = successCallBack;
                treeInit(treeId, params, showFields, isSearch);

            };
            return {
                view: view,
                init: init
            };
        };

        return {
            refreshTreeForChangeFields: refreshTreeForChangeFields,

            treeViewtemplate: treeViewtemplate
        }
    }
);