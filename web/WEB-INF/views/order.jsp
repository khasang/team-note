<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/order';
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

    var RestPut = function (c01_order_date, c02_order_person) {
        var JSONObject = {
            'Order_date': c01_order_date,
            'Order_person': c02_order_person
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

    var RestPost = function (id, c01_order_date, c02_order_person) {
        var JSONObject = {
            'id': id,
            'Order_date': c01_order_date,
            'Order_person': c02_order_person
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
        <th>ORDER</th>
    </tr>
    <tr>
        <td>GET Order by ID</td>
        <td><code><strong>GET</strong>/order/get/{id}</code></td>
        <td>
            Id: <input id="getOrderById" value=""/>
            <button type="button" onclick="RestGet($('#getOrderById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>GET All Orders</td>
        <td><code><strong>GET ALL</strong>/order/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add order</td>
        <td><code><strong>PUT</strong>/order/add</code></td>
        <td>
            <form class="form-inline">
                Order_date: <input type="text" id="putC01_order_date" value=2017-01-01>
                Order_person: <input type="text" id="putC02_order_person" value="Valeri Mikhailov">
                <button type="button" onclick="RestPut($('#putC01_order_date').val(), $('#putC02_order_person').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update order</td>
        <td><code><strong>POST</strong>/order/update</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="postId" value=2>
                Order_date: <input type="text" id="postC01_order_date" value=2017-02-02>
                Order_person: <input type="text" id="postC02_order_person" value="Valeri Mikhailov">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postC01_order_date').val(), $('#postC02_order_person').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete order by ID</td>
        <td><code><strong>DELETE</strong>/order/delete/{id}</code></td>
        <td>
            Id: <input id="OrderIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#OrderIdForDelete').val())">Try</button>
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
