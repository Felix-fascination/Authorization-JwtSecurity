$('.auth__form').submit(function() {
	let login = $(".input-field[name=log]").val();
	let pass = $(".input-field[name=pwd]").val();

	$.ajax({
		url: "/authenticate",
		type: "POST",
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify({userLogin: login, userPass: pass}),
		success: function(data) {
			if("error" in data) {
				$(".auth__error").text(data.error);
			} else {
				location.href = "/";
			}
		},
		error(responce) {
			console.log(responce);
		}
	});

	return false;
});