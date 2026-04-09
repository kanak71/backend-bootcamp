//TODO 108 회원 가입 유효성 검사

window.onload = function(){
	
	// 회원가입 submit 버튼 이벤트
	document.querySelector("input[type=submit]").onclick = function(event){
		event.preventDefault();
		
		//이메일 체크
		var emailIsc = emailCheck();
		if(!emailIsc){
			alert("잘못된 이메일 형식입니다");
			return;
		}
		
		//아이디 중복 검사
		var idInput = document.getElementsByName("id")[0];
		var idIsc = idInput.getAttribute("title");	//title 속성 확인
		console.log("id의 title 속성값 : ", idIsc);
		
		// submit 체크
		if(emailIsc && idIsc === 'y'){
			alert("회원가입을 진행합니다");
			//input이 readOnly로 되어 있다면 서버에서 값을 전송받지 못한다
			//따라서 사용자에게는 입력하지 못하도록 하고, submit을 했을때 변경해서 보내준다
			idInput.readOnly = false;
			document.forms[0].submit();
		}else{
			alert("아이디 중복 확인이 필요합니다")
			idInput.focus();
		}
		
		
	}
	
}
// 이메일 체크를 위한 정규화 표현식
	function emailCheck(){
		var email = document.getElementsByName("email")[0].value;
		console.log("작성된 email 값 :", email);
		var regEx = /^[a-zA-Z0-9\.\-]+@[a-zA-Z\-]+(\.[a-zA-Z]{2,3})+$/;
		
		if(regEx.test(email)){
			return true;		
		}else{
			return false;
		}
	}
	
	//서버에 요청을 해서 비동기식으로 ID 사용가능 여부를 확인
	//"available"로 키를 전달받은 JSON으로 되어 있다
	// fetch 사용해서 AJAX를 구현한다
	// 추가 : 아이디 중복 검사가 완료되면 해당 input 입력하지 못하도록 한다
	//		<input> 속성 readOnly를 작성하겠다
	function idCheck(){
		const idInput = document.getElementsByName("id")[0];
		const id = idInput.value.trim();
		
		if(id === ""){
			alert("아이디를 입력해 주세요");
			idInput.focus();
			return;
		}
		
		//AJAX를 통해서 서버에 중복검사를 요청
		//반환값을 확인해서 회원가입이 가능한 상태(title='y', readOnly=true)
		fetch('./duplicateIdServlet.do?id='+id)
			.then(res => res.json())
			.then(data => {
				if(data.available){
					alert("사용 가능한 아이디 입니다");
					idInput.title = 'y';
					idInput.readOnly = true;
				}else{
					alert("이미 사용중인 아이디 입니다");
					idInput.value="";
					idInput.focus();
				}
			});
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	