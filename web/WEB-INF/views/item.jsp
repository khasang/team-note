<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/item';
    var RestGet = function (id) {     // id
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,     // id
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

    var RestPut = function (name, description, type, content) {
        var JSONObject = {
            'name': name,
            'description': description,
            'type': type,
            'content': content
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

    //----------'id' --> 'items_id'     ?????????

    var RestPost = function (id, name, description, type, content) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description,
            'type': type,
            'content': content
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
        <th>ITEM</th>
    </tr>
    <tr>
        <td>GET Item by ID</td>
        <td><code><strong>GET</strong>/item/get/{id}</code></td>
        <td>
            Id: <input id="getItemById" value=""/>
            <button type="button" onclick="RestGet($('#getItemById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>GET All Items</td>
        <td><code><strong>GET ALL</strong>/item/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add item</td>
        <td><code><strong>PUT</strong>/item/add</code></td>
        <td>
            <form class="form-inline">
                Name: <input type="text" id="putName" value="Student">
                Description: <input type="text" id="putDescription" value="glass of water">
                Type: <input type="text" id="putType" value="Type-100">
                Content: <input type="text" id="putContent" value="">
                <button type="button"
                        onclick="RestPut($('#putName').val(), $('#putDescription').val(), $('#putType').val(), $('#putContent').val())">
                    Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update item</td>
        <td><code><strong>POST</strong>/item/update</code></td>
        <td>
            <form class="form-inline">
                Id: <input type="number" id="postId" value="">
                Name: <input type="text" id="postName" value="Student">
                Description: <input type="text" id="postDescription" value="glass of water">
                Type: <input type="text" id="postType" value="Type-100">
                Content: <input type="text" id="postContent" value="">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postName').val(), $('#postDescription').val(), $('#postType').val(), $('#postContent').val())">
                    Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete item by ID</td>
        <td><code><strong>DELETE</strong>/item/delete/{id}</code></td>
        <td>
            Id: <input id="ItemIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#ItemIdForDelete').val())">Try</button>
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
