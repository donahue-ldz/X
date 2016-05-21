$(function () {
    $("#grantCreditForm").submit(function (e) {
        var rules = new Array();
        $.each($("#grantCreditForm").find(".select2-selection__choice"), function (index, ele) {
            var rule = $(ele).attr("title");
            rules.push(rule);
        });
        console.log(rules);
        $("#grantCreditForm").find("select>:first-child").val(rules.join(",")).attr("selected",true);
        console.log($("#grantCreditForm"));

    })
})