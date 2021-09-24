function validateName(){
	var username = $("#username")
	var name = username.val();
	var note = $("#usernameNote");
	if(name==null || name===""){
		note.html( "用户名不能为空！").css("color","red");
		username.parent().parent().removeClass("has-success");
		username.parent().parent().addClass("has-error");
		return false;
	}else{
		note.html("");
		username.parent().parent().removeClass("has-error");
		username.parent().parent().addClass("has-success");
		return true;
	}
}

function validatePassword(){
	var password = $("#password");
	var password1 = password.val();
	var note = $("#passwordNote");
	if(password1==null || password1===""){
		note.html( "密码不能为空！").css("color","red");
		password.parent().parent().removeClass("has-success");
		password.parent().parent().addClass("has-error");
		return false;
	}else{
		note.html("");
		password.parent().parent().removeClass("has-error");
		password.parent().parent().addClass("has-success");
		return true;
	}
}

$(function(){ 
	//用户名格式验证
	$("#username").blur(function(){
		validateName();
	});
	//密码格式验证
	$("#password").blur(function(){
		validatePassword();
	});
	
	$("button[type='submit']").click(function(){
		return  validateName()&&validatePassword();
	});
})