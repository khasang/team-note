<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="/js/groupsTestService.js" type="text/javascript"></script>
</head>

<body>
<table class="table">
    <tr>
        <th>ID</th>
        <th>GROUPS_NAME</th>
        <th>GROUPS_DESCRIPTION</th>
    </tr>
    <tr>
        <td>GET GROUPS BY ID</td>
        <td><code><strong>GET</strong>/groups/get/{id}</code></td>
        <td>
            Id: <input id="GroupsById" value=""/>
            <button type="button" onclick="RestGet($('#GroupsById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add GROUPS</td>
        <td><code><strong>PUT</strong>/groups/add</code></td>
        <td>
            <form class="form-inline">
                groupName: <input type="text" id="putGroupName" value="Test groupName">
                <button type="button"
                        onclick="RestPut($('#putGroupName').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update GROUPS</td>
        <td><code><strong>POST</strong>/groups/update</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="postId" value="">
                groupName: <input type="text" id="postGroupName" value="UPDATE groupName">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postGroupName').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>GET ALL GROUPS</td>
        <td><code><strong>GEL ALL</strong>/groups/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Delete GROUPS by id</td>
        <td><code><strong>DELETE</strong>/groups/delete/{id}</code></td>
        <td>
            Id: <input type="number" id="GroupsIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#GroupsIdForDelete').val())">Try</button>
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
