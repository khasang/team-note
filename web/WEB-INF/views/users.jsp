<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Users</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>

<script type="text/javascript">
	var service = '/rest/users';

	var RestAddUser = function(accountName, password, firstName, lastName,
			email) {
		var JSONObject = {
			'accountName' : accountName,
			'password' : password,
			'firstName' : firstName,
			'lastName' : lastName,
			'email' : email
		};

		$.ajax({
			type : 'PUT',
			url : service,
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(JSONObject),
			datatype : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestGetAllUsers = function() {
		$.ajax({
			type : 'GET',
			url : service,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestGetUserById = function(id) {
		$.ajax({
			type : 'GET',
			url : service + '/' + id,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestGetUserByAccountName = function(accountName) {
		$.ajax({
			type : 'GET',
			url : service + '/accountName=' + accountName,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestGetUserByEmail = function(email) {
		$.ajax({
			type : 'GET',
			url : service + '/email=' + email,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestGetUserByPersonName = function(firstName, lastName) {
		$.ajax({
			type : 'GET',
			url : service + '/firstName=' + firstName + '&lastName=' + lastName,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};

	var RestDeleteUserById = function(id) {
		$.ajax({
			type : 'DELETE',
			url : service + '/' + id,
			dataType : 'json',
			async : false,
			success : function(result) {
				$('#response').html(JSON.stringify(result));
			},
			error : function(jqXHR, testStatus, errorThrown) {
				$('#response').html(JSON.stringify(jqXHR))
			}
		});
	};
</script>

<body>
	<table class="table">
		<tr>
			<th>Description</th>
			<th>HTTP Method</th>
			<th>URL</th>
			<th>Parameters</th>
			<th>Action</th>
		</tr>
		<tr>
			<td>Create user</td>
			<td><code>PUT</code></td>
			<td><code>/users/{id}</code></td>
			<td>
				<form class="add-user-form">
					<table>
						<tr>
							<td>Account name:</td>
							<td><input type="text" id="addUser-accountName" value=""></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="text" id="addUser-password" value=""></td>
						</tr>
						<tr>
							<td>First name:</td>
							<td><input type="text" id="addUser-firstName" value=""></td>
						</tr>
						<tr>
							<td>Last name:</td>
							<td><input type="text" id="addUser-lastName" value=""></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="text" id="addUser-email" value=""></td>
						</tr>
					</table>
				</form>
			</td>
			<td>
				<button type="button"
					onclick="RestAddUser($('#addUser-accountName').val(), $('#addUser-password').val(), $('#addUser-firstName').val(), $('#addUser-lastName').val(), $('#addUser-email').val())">Run</button>
			</td>
		</tr>
		<tr>
			<td>Get all users</td>
			<td><code>GET</code></td>
			<td><code>/users</code></td>
			<td></td>
			<td><button type="button" onclick="RestGetAllUsers()">Run</button></td>
		</tr>
		<tr>
			<td>Get user by ID</td>
			<td><code>GET</code></td>
			<td><code>/users/{id}</code></td>
			<td>Id: <input id="getUserById-userId" value="" />
			</td>
			<td><button type="button"
					onclick="RestGetUserById($('#getUserById-userId').val())">Run</button></td>
		</tr>
		<tr>
			<td>Get user by account name</td>
			<td><code>GET</code></td>
			<td><code>/users/accountName={accountName}</code></td>
			<td>Account name: <input id="getUserByAccountName-accountName" value="" />
			</td>
			<td><button type="button"
					onclick="RestGetUserByAccountName($('#getUserByAccountName-accountName').val())">Run</button></td>
		</tr>
		<tr>
			<td>Get user by email</td>
			<td><code>GET</code></td>
			<td><code>/users/email={email}</code></td>
			<td>Email: <input id="getUserByEmail-email" value="" />
			</td>
			<td><button type="button"
					onclick="RestGetUserByEmail($('#getUserByEmail-email').val())">Run</button></td>
		</tr>
		<tr>
			<td>Delete user by ID</td>
			<td><code>DELETE</code></td>
			<td><code>/users/{id}</code></td>
			<td>Id: <input id="deleteUserById-userId" value="" />
			</td>
			<td><button type="button"
					onclick="RestDeleteUserById($('#deleteUserById-userId').val())">Run</button></td>
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
