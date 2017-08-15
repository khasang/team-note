<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/status';
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

    var RestPut = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
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

    var RestPost = function (id, name, description) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description
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

</script>
<body>
<table class="table">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
    </tr>
    <tr>
        <td>GET Status by ID</td>
        <td><code><strong>GET</strong>/status/get/{id}</code></td>
        <td>
            Id: <input id="getStatusById" value=""/>
            <button type="button" onclick="RestGet($('#getStatusById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>GET All Statuses</td>
        <td><code><strong>GET ALL</strong>/status/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add status</td>
        <td><code><strong>PUT</strong>/status/add</code></td>
        <td>
            <form class="form-inline">
                name: <input type="text" id="putName" value="statusName">
                description: <input type="text" id="putDescription" value="statusDescription">
                <button type="button" onclick="RestPut($('#putName').val(), $('#putDescription').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update status</td>
        <td><code><strong>POST</strong>/status/update</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="postId" value=2>
                name: <input type="text" id="postName" value="statusName">
                description: <input type="text" id="postDescription" value="statusDescription">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postName').val(), $('#postDescription').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete status by ID</td>
        <td><code><strong>DELETE</strong>/status/delete/{id}</code></td>
        <td>
            Id: <input id="StatusIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#StatusIdForDelete').val())">Try</button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
