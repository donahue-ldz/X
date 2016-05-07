requirejs.config({
    baseUrl: "/assets/js",
    paths: {
        "jquery": "/assets/js/lib/jquery-1.11.2",
        "jquery.bootstrap": "/assets/js/lib/jquery.bootstrap",
        "bootstrap": "/assets/js/lib/bootstrap",
        "domReady": "/assets/js/lib/requireJsPlugin/domReady",
        "CodeMirror": "/assets/js/lib/CodeMirror",
        "diff_match_patch": "/assets/js/lib/diff_match_patch",
        "jquery.blockUI": "/assets/js/lib/jquery.blockUI",
        "jquery.cookie": "/assets/js/lib/jquery.cookie.js",
        "WdatePicker": "/assets/js/My97DatePicker/WdatePicker",
        "bootstrap-select": "/assets/js/lib/bootstrap-select",
        "ace": "/assets/js/ace/ace",
        "ZeroClipboard": "/assets/js/lib/ZeroClipboard",
        "formValidate": "/assets/js/lib/jquery.validate",
        "ztree": "/assets/js/lib/jquery.ztree.all",

        "merge": "/assets/js/lib/CodeMirror/merge",
        "get": "/assets/js/application/ops/module/get",
        "utils": "/assets/js/application/ops/module/utils",
        "aside": "/assets/js/application/ops/module/aside",
        "navbar": "/assets/js/application/ops/module/navbar",
        "settings": "/assets/js/application/ops/module/settings",
        "enviInfo": "/assets/js/application/ops/enviInfo",

        "record": "/assets/js/application/ops/module/record",
        "wizard": "/assets/js/application/ops/module/wizard",
        "jsonForm": "/assets/js/application/ops/module/jsonForm",

        "app": "/assets/js/application/ops/module/app",
        "tree": "/assets/js/application/ops/module/tree",

    },
    "shim": {
        "bootstrap": ["jquery"],
        "jquery.bootstrap": ["jquery", "bootstrap"],
        "jquery.blockUI": ["jquery"],
        "WdatePicker": [],
        "bootstrap-select": ['jquery'],
        "app": ['jquery', "bootstrap"],
        "ace": ['jquery'],
        "ZeroClipboard": [],
        "ztree": ['jquery'],
        "jsonForm": ["jquery"],
    },

    waitSeconds: 0
});