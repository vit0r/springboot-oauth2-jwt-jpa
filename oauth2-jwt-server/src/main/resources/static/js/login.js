$(document).ready(function () {
    var supportsHTML5Storage = function () {
        try {
            return 'localStorage' in window && window['localStorage'] !== null;
        } catch (e) {
            return false;
        }
    };

    var requestToken = function () {
        var auth = {username: $('#username').val(), password: $('#password').val()};
        $.ajax({
            async: false,
            type: 'POST',
            data: JSON.stringify(auth),
            url: 'http://localhost:9094/oauth/token',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                var ob = {Authorization: data.token_type + ' ' + data.access_token};
                console.log(ob);
            },
            error: function (error) {
                console.log(error);
            }
        });
    };

    if (supportsHTML5Storage()) {
        $('#form-signin').submit(function () {
            var authorization = requestToken();
            console.log(authorization);
        });
    }
});
