$(document).ready(function () {
    var username = getUsername();
    $('#username').text(username);

    showUserList(getUserList());
});

function getUsername() {
    var username = "";
    $.ajax({
        type: "GET",
        url: "/username",
        cache: false,
        timeout: 600000,
        dataType: "text",
        async: false,
        success: function (data) {
            if(data) {
                username = data;
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
    return username;
}

function getUserList() {
    var users = null;
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/admin/users",
        cache: false,
        timeout: 600000,
        dataType: "json",
        async: false,
        success: function (data) {
            if(data) {
                users = data
            }
        },
        error: function (e) {
            console.log(JSON.stringify(e.responseText));
            return false;
        }
    });
    return users;
}

function showUserList(users) {
    $('.content').prepend(
        '<div class="user-info">' +
        '<div class="user-role col-xs-3"><spring:message code="main.role"/></div>' +
        '<div class="user-role col-xs-4"><spring:message code="main.username"/></div>' +
        '<div class="user-role col-xs-5"><spring:message code="main.mail"/></div>' +
        '</div>'
    );
    for (var i = 0; i < users.length; i++) {
        $('.content').prepend(
            '<div class="user-info">' +
                '<div class="user-role col-xs-3">' + users[i].role + '</div>' +
                '<div class="user-role col-xs-4">' + users[i].username + '</div>' +
                '<div class="user-role col-xs-5">' + users[i].mail + '</div>' +
            '</div>'
        );
    }
}
