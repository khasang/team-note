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

    var RestPut = function (person, product, orderNumber, price, orderDate, userId) {
        var JSONObject = {
            'person': person,
            'product': product,
            'orderNumber': orderNumber,
            'price': price,
            'orderDate': orderDate,
            'userId': userId
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

    var RestPost = function (id, person, product, orderNumber, price, orderDate, userId) {
        var JSONObject = {
            'id': id,
            'person': person,
            'product': product,
            'orderNumber': orderNumber,
            'price': price,
            'orderDate': orderDate,
            'userId': userId
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
                Person: <input type="text" id="putPerson" value="Student">
                Product: <input type="text" id="putProduct" value="glass of water">
                Order Number: <input type="text" id="putOrderNumber" value="">
                Price: <input type="text" id="putPrice" value="">
                Order Date: <input type="text" id="putOrderDate" value="">
                User id: <input type="text" id="putUserId" value="">
                <button type="button"
                        onclick="RestPut($('#putPerson').val(), $('#putProduct').val(), $('#putOrderNumber').val(), $('#putPrice').val(),
                         $('#putOrderDate').val(), $('#putUserId').val())">
                    Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update order</td>
        <td><code><strong>POST</strong>/order/update</code></td>
        <td>
            <form class="form-inline">
                Id: <input type="number" id="postId" value="">
                Person: <input type="text" id="postPerson" value="Student">
                Product: <input type="text" id="postProduct" value="glass of water">
                Order Number: <input type="text" id="postOrderNumber" value="">
                Price: <input type="text" id="postPrice" value="">
                Order Date: <input type="text" id="postOrderDate" value="">
                User id: <input type="text" id="postUserId" value="">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postPerson').val(), $('#postProduct').val(), $('#postOrderNumber').val(),
                         $('#postPrice').val(), $('#postOrderDate').val(), $('#postUserId').val())">
                    Try
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
