//1. 화면을 강제로 이동할 때 입력되어 있는 글이 저장되지 않는다는 경고
// ex)양식이 저장되지 않습니다

// submit()을 통해서 이동할 때 onbeforeunload가 동작된다.
// 이러한 이벤트를 isShow의 변수값을 통해서 처리
let isShow = true;

window.onbeforeunload = function(){
	if(isShow){
		return "화면에서 벗어 납니다. 작성된 글은 저장되지 않습니다";
	}
} // onbeforeunload 끝


// 3. 새로고침과 같은 키의 화면 refresh의 이벤트를 막음
// keycode 
// f5:116 ,  ctrl(17)+r(82) , ctrl(17)+n(78)
let isCtrl = false; // 조합키를 판단, 누른상태를 확인 할 수 없다

document.addEventListener("keydown", function(e){
	if(e.keyCode === 17){
		isCtrl = true;
	}
	//         f5,                 ctrl+r,                         ctrl+n
	if((e.keyCode===116)||(e.keyCode===82 && isCtrl) || (e.keyCode===78 && isCtrl)){
		//이벤트를 막음 : Propagation
		e.preventDefault();
		e.stopPropagation();
		return false;
	}
}); // keydown 끝

document.addEventListener("keyup", function(e){
	if(e.keyCode === 17){
		isCtrl = false;
	}
	
}); // keyup 끝



//2. 화면에 값 유효성 검사 
function validationForm(){
	console.log("form 요소의 유효성 검사");
	
	var form = document.forms[0];
	
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	if(title.value == "" || content.value == ""){
		alert("필수값을 입력해 주세요");
	}else{
		// XSS(Cross Side Script) 방지
		var str = content.value;
		
		str = str.replace(/</gim,"&lt;");
		str = str.replace(/>/gim, "&gt;");
		str = str.replace(/\'/gim, "&apos;");
		str = str.replace(/\r\n|\n\r|\r|\n/gim, "<br>");
		
		document.getElementById("contentView").innerHTML = str;
		
		// XSS 값 재입력 
		content.value = str;
		
		// onbeforeunload 경고창 제외
		isShow =false;
		
		// javascript submit
		form.submit();
	}
	
}















