window.onload = function(){
	document.forms[0].onsubmit=function(event){
		console.log("submit 버튼 작동");
		var chkContent = document.getElementById("chkContent").value;
		if(chkContent == 'y'){
			alert("답글은 필수입니다");
			event.preventDefault();
		}
	}
	
	var txtArea = document.getElementById("txtArea");
	
	txtArea.addEventListener("focus", function(){
		var obj1 = document.getElementById("hiddenContent").value;
		var obj2 = txtArea.value;	//input은 checkbox와 radio를 제외하고 모두 value로 값을 사용한다
		var tmpObj = obj2.replace("원본>","");	//화면 Entity Tag는 값의 형태로 가져온다 &gt; => >
		
		if(obj1 === tmpObj){
			txtArea.value="";
			document.getElementById("contxt").innerHTML = "내용";
			document.getElementById("chkContent").value = 'n';
		}
	});
	
	//reset 버튼 동작
	document.querySelector("input[type=reset]").onclick=function(){
		document.getElementById("contxt").innerHTML = "내용<br>(원본)";
		document.getElementById("chkContent").value = 'y';
		
	}
	
}