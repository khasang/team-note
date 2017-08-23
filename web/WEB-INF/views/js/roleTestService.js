var service = '/roles';
var RestGet = function (id) {
    $.ajax({
        type: 'GET',
        url: service + '/get/' + id,
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPut = function (roleName, roleDescription) {
    var JSONObject = {
        'roleName': roleName,
        'roleDescription': roleDescription
    };

    $.ajax({
        type: 'PUT',
        url: service + "/add",
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(JSONObject),
        datatype: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestGetAll = function () {
    $.ajax({
        type: 'GET',
        url: service + '/all',
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
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
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};

var RestPost = function (id, roleName, roleDescription) {
    var JSONObject = {
        'id': id,
        'roleName': roleName,
        'roleDescription': roleDescription
    };

    $.ajax({
        type: 'POST',
        url: service + "/update",
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(JSONObject),
        datatype: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR))
        }
    });
};
