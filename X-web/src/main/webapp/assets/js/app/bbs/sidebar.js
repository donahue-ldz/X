(function(){
    var user = function(){
        return{
            avatar:function(){
                return $("#avatar").attr("src");
            }
        }
    }();
    $(document).ready(function () {
        $("#bbsAvatar").attr("src",user.avatar());
    });
})();