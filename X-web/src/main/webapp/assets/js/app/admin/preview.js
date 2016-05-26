$(function () {
   $("#savePreview").click(function (e) {
       e.preventDefault();
       $.post("/admin/json/PreviewRequest/upload.json",{
           fileName:$("form").find("input[name='fileName']").val(),
           content:$("form").find("textarea").val()
       },function(result){
           if(result.success){
               var id = result.obj;
               $("#previewFrame").attr("src","/admin/toolkit/preview.htm?id="+id);
           }else {
               console.log(result.errorMsg);
           }
       })
   })
})()