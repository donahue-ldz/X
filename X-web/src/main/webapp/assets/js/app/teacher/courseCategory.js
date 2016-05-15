var courseCategoryTree = function () {
    var filter = function (treeId, parentNode, childNodes) {
        childNodes = childNodes.objList
        if (!childNodes) return null;
        for (var i = 0, l = childNodes.length; i < l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            //异步转化为同步,只加载一次
            childNodes[i].open = true;
            childNodes[i].pId = childNodes[i].parentID;
        }
        console.log(childNodes)
        return childNodes;
    };
    var beforeRemove = function (treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
    };
    var beforeRename = function (treeId, treeNode, newName) {
        if (newName.length == 0) {
            alert("节点名称不能为空.");
            return false;
        }
        return true;
    };

    var newCount = 1;
    var addHoverDom = function (treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_" + treeNode.tId);
        if (btn) btn.bind("click", function () {
            $("#courseCategoryAddModal input[name='parentName']").val(treeNode.name);
            $("#courseCategoryAddModal input[name='parentID']").val(treeNode.id);

            $("#courseCategoryAddModal").modal("show");
            $("#courseCategoryAddModal").find('#saveBtn').click(function () {
                var data = {};
                data.name = $("#courseCategoryAddModal").find("input[name='name']").val();
                data.parentID = $("#courseCategoryAddModal").find("input[name='parentID']").val();
                data.desc = $("#courseCategoryAddModal").find("textarea[name='desc']").text();

                $.post('/teacher/json/CourseCategoryRequest/addCourseCategory.json', data, function (result) {
                    if (result.success) {
                        location.reload();
                    } else {
                        console.log(result.errorMsg)
                    }
                })
            });

            return false;
        });
    };
    var removeHoverDom = function (treeId, treeNode) {
        $("#addBtn_" + treeNode.tId).unbind().remove();
    };

    var setting = {
        async: {
            enable: true,
            url: "/teacher/json/CourseCategoryRequest/queryAllCourseCategories.json",
            autoParam: ["id", "name=n", "level=lv"],
            otherParam: {"otherParam": "oo"},
            dataFilter: filter
        },
        view: {
            expandSpeed: "",
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            selectedMulti: false
        },
        edit: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: -1
            }
        },
        callback: {
            beforeRemove: beforeRemove,
            beforeRename: beforeRename
        }
    };
    return {
        init: function () {
            $.fn.zTree.init($("#treeDemo"), setting);
        }
    }


}();
$(document).ready(function () {
    courseCategoryTree.init();
});
