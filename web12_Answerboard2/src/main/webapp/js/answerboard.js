
//GNB(header.jsp)에 있는 목록을 클릭 했을 경우 Bootstrap에 class='active' 적용
document.addEventListener("DOMContentLoaded",function(){
	console.log("javascript addEventListener onload 실행");
	
	var menu = document.querySelectorAll(".navbar-nav li");
	
	menu.forEach(function(item){ // 탐색된 li의 목록을 향상된 for문 한개씩 입력(item변수로)
		item.addEventListener("click",function(){
			
			// 클릭된 요소를 저장
			var current = this;
			
			//나를 제외한 li의 목록에 있는 class='active'를 제거해 줘야함
			menu.forEach(function(other){
				other.classList.remove("active");
			}); // other 끝
			
			//해당 li가 onclick되었을때 class='active' 클래스를 추가
			current.classList.add("active");
			
		});
	});
});

//boradList.jsp에 checkbox 기능

//1. thead의 checkbox를 클릭하면 name='ch'인 checkbox를 같은 상태로 변경한다
function checkAll(bool){	//this.checked
	//checkbox는 checked를 통해서 상태를 받는다
	var chs = document.getElementsByName("ch");
	for(let i=0; i<chs.length; i++){
		chs[i].checked = bool;
	}
}

//2. name="ch"인 checkbox가 모두 체크가 되면, <thead>에 있는 checkbox true
// 필요한 name="ch" 체크된 개수를 반환하는 함수
// document.queryselectorAll()의 속성탐색으로 변경 구현해 보세요
var chCheckCount = function(){
	var chs = document.getElementsByName("ch");
	let cnt = 0;
	for(let i=0; i<chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	return cnt;
}

window.onload = function(){
	console.log("javacript ch에 따른 allCheckbox의 상태 변경");
	
	var chs = document.getElementsByName("ch");
	var chkbox = document.getElementById("chkbox");
	
	//각 name="ch"인 element에 onclick 이벤트를 작성하기 위해서
	for(let i=0; i<chs.length; i++){
		chs[i].onclick = function(){
			if(chs.length == chCheckCount()){
				chkbox.checked = true;
			}else{
				chkbox.checked = false;
			}
		}
	}
}

function chkSubmit(){
	console.log("form의 이벤트인 submit 실행");
	var chCount = chCheckCount();
	if(chCount == 0){
		alert("반드시 하나 이상의 글을 선택해주세요");
		
	} else{
		document.forms[0].submit();
		
	}
	return false;
}


//다중삭제를 위한 sweet alter2 콜백 js 이벤트
function chSubmit(event){
	console.log("sweet alert2를 통해서 콜백 다이얼로그 작성");
	event.preventDefault();	//onsubmit 에빈트 정지
	
	var chCount = chCheckCount();
	if(chCount > 0){
		Swal.fire({
				  title: "다중 삭제를 진행 하겠습니까?",
				  icon: "success",
				    showDenyButton: true,
				   // showCancelButton: true,
				    confirmButtonText: "Save",
				    denyButtonText: `Don't save`
				}).then((result) => { // 선택했던 결과 Call Back result에 담긴다
					// TRUR 라면 isConfirmed 이고 아니면 FALSE isDenied
					if(result.isConfirmed){
						Swal.fire("저장!!","","success").then(()=>{
							document.forms[0].submit();
						});
					} else if (result.isDenied){
						Swal.fire("Changes are not saved", "", "info")
					}
				});
		
	}else{
		Swal.fire("선택된 글이 없습니다");
	}
}






// detailBoard.jsp 에서 내글수정 modify(this)
function modify(btn){
	console.log(btn);
	
	var seq = document.querySelector("input[name=seq]").value;
	location.href="./modifyBoard.do?seq="+seq;
	
}

// detailBoard.jsp 에서 답글작성 reply(this)
function reply(btn){
	console.log(btn);
	
	var seq = document.querySelector("input[name=seq]").value;
	location.href="./replyBoard.do?seq="+seq;
}

// detailBoard.jsp에서 관리자 기능을 DB삭제(del)this
function del(btn){
	console.log(btn)
	var con = confirm("선택된 글이 완전삭제 됩니다");
	console.log(typeof con, con);
	
	var seq = document.querySelector("input[name=seq]").value;
	
	if(con){	//javascript에서는 boolean 경우 동작, 객체가 있으면 true로 판단
		location.href="./realDelete.do?seq="+seq;
	} else{
		alert("삭제가 취소 되었습니다");
	}
}

