toLogin = function () {
    var name = $("#name").val();
    var password = $("#password").val();
    $.ajax({
        type: "POST",
        url: "/login",
        contentType: 'application/json',
        data: JSON.stringify({
            loginName: name,
            password: password
        }),
        success: function (data) {
            if (data.messages.toString() == "success") {
                alert("登录成功");
                open("/index");
            } else {
                alert(data.messages.toString());
            }
        },
        error: function (data) {
            alert(data);
            alert("error");
        },
        dataType: "JSON"
    });
};
