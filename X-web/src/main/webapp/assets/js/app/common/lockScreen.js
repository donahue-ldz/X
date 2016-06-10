var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {

             $.backstretch([
		        "/assets/imags/common/bg/1.jpg",
    		    "/assets/imags/common/bg/2.jpg",
    		    "/assets/imags/common/bg/3.jpg",
    		    "/assets/imags/common/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();

jQuery(document).ready(function() {
    Lock.init();
});