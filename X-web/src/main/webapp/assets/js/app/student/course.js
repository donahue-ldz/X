var course = function () {

    var content = $('.content');
    var listListing = '';

    var loadData= function (el, name) {
        var url = '/json/CourseRequest/queryCourses.json';
        var title = el.attr('data-title');
        listListing = name;

        App.blockUI({
            target: content,
            overlayColor: 'none',
            animate: true
        });

        toggleButton(el);

        $.ajax({
            type: "POST",
            cache: false,
            url: url,
            success: function (res) {
                toggleButton(el);
                App.unblockUI('.inbox-content');
                $('.inbox-nav > li.active').removeClass('active');
                el.closest('li').addClass('active');
                $('.inbox-header > h1').text(title);
                    
                content.html(res);

                if (Layout.fixContentHeight) {
                    Layout.fixContentHeight();
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                toggleButton(el);
            },
            async: false
        });

        // handle group checkbox:
        jQuery('body').on('change', '.mail-group-checkbox', function () {
            var set = jQuery('.mail-checkbox');
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                $(this).attr("checked", checked);
            });
        });
    }
    
    var toggleButton = function (el) {
        if (typeof el == 'undefined') {
            return;
        }
        if (el.attr("disabled")) {
            el.attr("disabled", false);
        } else {
            el.attr("disabled", true);
        }
    };


    return {
        //main function to initiate the module
        init: function () {
            $(".mt-widget-2").click(function () {
                location.href="/list/courseDetails.htm?courseID=1";
            });
        }

    };

}();

jQuery(document).ready(function () {
    course.init();

});