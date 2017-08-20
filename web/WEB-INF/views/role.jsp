<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ROLES</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="/js/roleTestService.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
<table class="table">
    <tr>
        <th>ID</th>
        <th>ROLE_NAME</th>
        <th>ROLE_DESCRIPTION</th>
    </tr>
    <tr>
        <td>GET ROLE by ID</td>
        <td><code><strong>GET</strong>/roles/get/{id}</code></td>
        <td>
            Id: <input id="RoleById" value=""/>
            <button type="button" onclick="RestGet($('#RoleById').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add ROLE</td>
        <td><code><strong>PUT</strong>/roles/add</code></td>
        <td>
            <form class="form-inline">
                name: <input type="text" id="putName" value="roleName">
                description: <input type="text" id="putDescription" value="roleDescription">
                <button type="button" onclick="RestPut($('#putName').val(), $('#putDescription').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>GET All ROLES</td>
        <td><code><strong>GET ALL</strong>/roles/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Update ROLE</td>
        <td><code><strong>POST</strong>/roles/update</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="postId" value=3>
                name: <input type="text" id="postName" value="roleName">
                description: <input type="text" id="postDescription" value="roleDescription">
                <button type="button"
                        onclick="RestPost($('#postId').val(),$('#postName').val(), $('#postDescription').val())">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete ROLE by ID</td>
        <td><code><strong>DELETE</strong>/role/delete/{id}</code></td>
        <td>
            Id: <input id="RoleIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#RoleIdForDelete').val())">Try</button>
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
