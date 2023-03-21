$('.auth__form').submit(function() {
	let login = $(".input-field[name=log]").val();
	let pass = $(".input-field[name=pwd]").val();

	$.ajax({
		url: "/checkValidAuthData",
		type: "POST",
		dataType: 'json',
		data: {userLogin: login, userPass: pass},
		success: function(data) {
			console.log("asda");
			if("error" in data) {
				$(".auth__error").text(data.error);
			} else {
				location.href = "/";
			}
		}
	});

	return false;
});