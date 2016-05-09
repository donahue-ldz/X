/**
 *
 * @param pager
 * @param callFunc
 * 将会封装 分页需要的数据
 * {pageNO:1,pageSize:20}
 */
function page(pager,func,options,containerID){
    var pageBarButtons = pager.pageBarButtons;
    var html = "";
    $.each(pageBarButtons, function (index, button) {
        html += "<li class ='"+button.status+"'><a>"+button.key+"</a></li>"
    });
    var pageSizeOptions = pager.pageSizeOptions;
    var optionHtml = "";
    $.each(pageSizeOptions, function (index,option) {
        if(pager.pageSize == option)
        optionHtml += "<option value='"+option+"' selected>"+option+"</option>";
        else
            optionHtml += "<option value='"+option+"'>"+option+"</option>";

    });

    if(containerID) {
        $("#"+containerID+" #select_pageSize").html(optionHtml);
        $("#"+containerID+" #currentPage").text(pager.currentPage);

        $("#"+containerID+" #totalPages").text(pager.totalPages);
        $("#"+containerID+" #totalRecordsNum").text(pager.totalRecords);

        $("#"+containerID+" .pagination").html(html);
    }else{
        $("#select_pageSize").html(optionHtml);
        $("#currentPage").text(pager.currentPage);

        $("#totalPages").text(pager.totalPages);
        $("#totalRecordsNum").text(pager.totalRecords);

        $(".pagination").html(html);
    }
    $(".pagination > li.normal > a").css("cursor","pointer");



    $("ul.pagination > li").unbind().on("click", function () {
        var hash = location.hash;
        console.log(hash);
        if($(this).attr("class")=="disabled") return;
        if($(this).attr("class")=="active") return;
        var text = $(this).text();
        var pageNO = $(this).text();
        var pageSize = $("#select_pageSize").find("option:checked").val();


        var currentPage = $("#currentPage").text();
        var totalPages = $("#totalPages").text();
        if(text=="上一页"){
            pageNO = parseInt(currentPage)-1;
        }
        if(text=="下一页"){
            pageNO = parseInt(currentPage)+1;
        }
        if(text=="首页"){
            pageNO = 1;
        }
        if(text=="尾页"){
            pageNO = parseInt(totalPages);
        }
        var data = {pageNO:parseInt(""+pageNO),pageSize:pageSize};
        $.extend(options,data);
        func(options);
        location.hash = hash;

    })  ;

    $("#select_pageSize").unbind().on("change", function () {

        var pageSize = $(this).find("option:checked").val();
        var currentPage = $("#currentPage").text();
        var data = {pageNO:currentPage,pageSize:pageSize};
        $.extend(options,data);
        func(options);

    });


}