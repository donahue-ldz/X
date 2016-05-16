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
    }

    return {
        //main function to initiate the module
        init: function () {

            // handle compose btn click
            $('.inbox').on('click', '.compose-btn', function () {
                loadCompose($(this));
            });

            // handle discard btn
            $('.inbox').on('click', '.inbox-discard-btn', function (e) {
                e.preventDefault();
                loadInbox($(this), listListing);
            });

            // handle reply and forward button click
            $('.inbox').on('click', '.reply-btn', function () {
                loadReply($(this));
            });

            // handle view message
            $('.inbox').on('click', '.view-message', function () {
                loadMessage($(this));
            });

            // handle inbox listing
            $('.inbox-nav > li > a').click(function () {
                loadInbox($(this), 'inbox');
            });

            //handle compose/reply cc input toggle
            $('.inbox-content').on('click', '.mail-to .inbox-cc', function () {
                handleCCInput();
            });

            //handle compose/reply bcc input toggle
            $('.inbox-content').on('click', '.mail-to .inbox-bcc', function () {
                handleBCCInput();
            });

            //handle loading content based on URL parameter
            if (App.getURLParameter("a") === "view") {
                loadMessage();
            } else if (App.getURLParameter("a") === "compose") {
                loadCompose();
            } else {
                $('.inbox-nav > li:first > a').click();
            }

        }

    };

}();

jQuery(document).ready(function () {
    course.init();
});