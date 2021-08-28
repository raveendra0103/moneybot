function login() {
	$.get( "/login/urls", function(data) {
		console.log(data);
		window.location.replace(data);
	});
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    
    $( "#login" ).click(function() { login(); });
    
});

