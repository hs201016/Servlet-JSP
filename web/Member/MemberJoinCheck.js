$(function() {
	$("form").submit(function() {
		if ($("#id").val() === "") { //val은 값을 가져오거나 설정
			alert("아이디를 입력하세요.");
			$("#id").focus(); // focus 는 이벤트를 처
			return false;
		}
		if ($("#password").val() === "") {
			alert("비밀번호를 입력하세요.");
			$("#password").focus();
			return false;
		}
		if ($("#name").val() === "") {
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		if ($("#studentId").val() === "") {
			alert("학번를 입력하세요.");
			$("#studentId").focus();
			return false;
		}
		if ($("#email").val() === "") {
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}

		if ($("#password").val() !== $("#password2").val()) {
			alert("비밀번호가 다릅니다.");
			$("#password").val("");
			$("#password2").val("");
			$("#password").focus();
			return false;
		}
	});
});
