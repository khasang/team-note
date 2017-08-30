<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="/js/messageTestService.js" type="text/javascript"></script>
</head>

<body>
<table class="table">
    <tr>
        <th>ID</th>
        <th>MESSAGE_NAME</th>
        <th>MESSAGE_DESCRIPTION</th>
    </tr>
    <tr>
        <td>GET MESSAGE BY ID</td>
        <td><code><strong>GET</strong>/message/get/{id}</code></td>
        <td>
            Id: <input id="MessageById" value=""/>
            <button type="button" onclick="RestGet($('#MessageById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add MESSAGE</td>
        <td><code><strong>PUT</strong>/message/add</code></td>
        <td>
            <form class="form-inline">
                fromUserId: <input type="number" id="putFromUserId" value="10">
                toUserId: <input type="number" id="putToUserId" value="234">
                messageText: <input type="text" id="putMessageText" value="Test text after ADD">
                <button type="button"
                        onclick="RestPut($('#putFromUserId').val(),$('#putToUserId').val(),$('#putMessageText').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update MESSAGE</td>
        <td><code><strong>POST</strong>/message/update</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="postId" value="5">
                fromUserId: <input type="number" id="postFromUserId" value="15">
                toUserId: <input type="number" id="postToUserId" value="150">
                messageText: <input type="text" id="postMessageText" value="new text after POST">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postFromUserId').val(),$('#postToUserId').val(),$('#postMessageText').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>GET ALL MESSAGES</td>
        <td><code><strong>GEL ALL</strong>/message/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Delete MESSAGE by id</td>
        <td><code><strong>DELETE</strong>/message/delete/{id}</code></td>
        <td>
            Id: <input type="number" id="MessageIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#MessageIdForDelete').val())">Try</button>
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
