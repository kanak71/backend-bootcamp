// detailBoard.jsp 에서 내글수정 modify(this)
function modify(btn){
	console.log(btn);
	
	var seq = document.querySelector("input[name=seq]").value;
	location.href="./modifyBoard.do?seq="+seq;
}

//detailBoard.jsp에서 답글작성 replu(this)
function reply(btn){
	console.log(btn);
	
	var seq = document.querySelector("input[name=seq]").value;
	location.href="./replyBoard.do?seq="+seq;
}