$(function() {
	/*
	* function 이라는 매개변수로 초기화를 시켜주는 역할을 한다. / 수정하는 페이지
	**/
	$("#detailUpldate").on("click", function() {

		var pass = $("#pass").val();
		if (pass.length <= 0) {
			alert("추억을 수정하려면 비밀번호를 입력해주세요.");
			return false;
		}

		$("#rPass").val(pass);
		$("#checkForm").attr("action", "updateForm	");
		$("checkForm").attr("method", "post");
		$("#chackForm").submit();
	});
	/**
	 * 게시글 상세보기에서 게시글 삭제 요청 처리
	 */
	$("#datailDelete").on("click", function() {
		var pass = $("#pass").val();
		if(pass.length <= 0){
			alert("추억을 삭제하려면 비밀번호을 입력해주세요");
			return false;
		}
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "deleteProcess");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	});

	// 게시글 쓰기 폼 유효성 검사
	$("#writeForm").on("submit", function(){
		if($("#name").val().length <= 0) {
			alert("작성자가 입력되지 않았습니다. \n 작성자를 입력해주세요");
			$("#name").focus();
			return false;
		}
		if($("#title").val().length <= 0) {
			alert("제목을 입력되지 않았습니다. \n 제목을 입력해주세요");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다. \n 비밀번호를 입력해주세요");
			$("#pass").focus();
			return false;
		}
	});
	// 게시글 수정 폼 유효성 검사
	$("#updateForm").on("submit", function(){
		if($("#name").val().length <= 0){
			alert("작성자가 입력되지 않았습니다 \n 작성자를 입력해주세요");
			$("#name").foucs();
			return false;
		}
		if($("#title").val().length <= 0){
			alert("제목을 입력되지 않았습니다. \n 제목을 입력해주세요");
			$("#title").foucs();
			return false;
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다. \n 비밀번호를 입력해주세요");
			$("#pass").focus();
			return false;
		}
	});
	// 로그인 폼 로그인 정보를 알려주는 코드
	$("#updateForm").on("submit", function(){
		if($("#userId").val().length <= 0){
			alert("작성자가 입력되지 않았습니다 \n 작성자를 입력해주세요");
			$("#userId").foucs();
			return false;
		}
		if($("#userPass").val().length <= 0){
			alert("제목을 입력되지 않았습니다. \n 제목을 입력해주세요");
			$("#userPass").foucs();
			return false;
		}
	});
});