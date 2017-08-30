var service = '/message';
var RestGet = function (id) {
    $.ajax({
        type: 'GET',
        url: service + '/get/' + id,
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPut = function (fromUserId, toUserId, messageText) {
    var JSONObject = {
        'fromUserId': fromUserId,
        'toUserId': toUserId,
        'messageText': messageText
    };

    $.ajax({
        type: 'PUT',
        url: service + "/add",
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('$response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestGetAll = function () {
    $.ajax({
        type: 'GET',
        url: service + "/all",
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestDelete = function (id) {
    $.ajax({
        type: 'DELETE',
        url: service + '/delete/' + id,
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPost = function (id, fromUserId, toUserId, messageText) {
    var JSONObject = {
        'id': id,
        'fromUserId': fromUserId,
        'toUserId': toUserId,
        'messageText': messageText
    };

    $.ajax({
        type: 'POST',
        url: service + '/update',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result))
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    })
}