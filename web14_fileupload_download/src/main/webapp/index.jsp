<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- TODO 002 파일 업로드 & 다운로드 화면 구현 -->
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드&amp;다운로드</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h3 class="md-4">게시글 작성 및 파일 업로드</h3>
		<form action = "./upload.do" method="post" enctype="multipart/form-data">
			<div class="mb-3 mt-3">
      			<label for="title">제목:</label>
      			<input type="text" class="form-control" id="title" name="title" value="파일 업로드 제목" required="required">
    		</div>
    		
    		<div class="mb-3 mt-3">
      			<label for="content">내용:</label>
      			<textarea rows="5" class="form-control" id="content" name="content" required="required">파일 업로드 내용</textarea>
    		</div>

    		<!-- 파일은 input에서 type이 file -->
    		<div class="mb-3 mt-3">
      			<label for="files">파일 선택(여러 파일 가능):</label>
      			<input type="file" class="form-control" id="files" name="files" multiple="multiple">
    		</div>
    		
    		
    		<!-- 목록 처리를 위한 DIV -->
    		<div class="mb-3 mt-3">
    			<label for="form-label">선택된 파일 목록</label>
    			<ul class="list-group" id="fileList"></ul>
    		</div>
    		
    		<!-- ----------------------------------------------------------------------- -->    		
    		
    		<button type="submit" class="btn btn-primary">업로드</button>
    		
    		<!-- ----------------------------------------------------------------------- -->
    		<div class="mb-3 mt-3">
    			<label for="form-label">이미지 미리보기</label>
    			<div id="preview" class="d-flex flex-wrap gap-2"></div>
    		</div>
    		
    		
    		
		</form>
		
		<!-- 업로드 후 업로드된 파일의 목록을 보여줌 -->
		<hr class="my-4"/>
		<h4>업로드된 파일 목록</h4>
		<ul>
			<c:forEach var="item" items="${fileList}">
				<li>
					<a href="./download.do?filename=${item}">${item}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- 이벤트 -->
	
	<script type="text/javascript">
		//<input type="file">에 파일을 선택했을 때(변경) 이벤트 발생
		/* document.getElementById("files").addEventListener("change", function(){
			
			//출력할 영역 DOM 탐색
			var fileList = document.getElementById("fileList");
			fileList.innerHTML="";
			
			const files = this.files;
			
			if(files.length == 0){
				fileList.innerHTML = "<li class='list-group-item'>선택된 파일이 없습니다</li>";
				return;
			}
			
			//  <input type="file"> multiple로 읽어온 file 목록을 create Dom을 통해서 append
			for(let i=0; i<files.length; i++){
				const file = files[i];
				console.log(i, file);
				const li = document.createElement("li");
				li.innerHTML = "<span>"+file.name+"</span>";
				
				fileList.appendChild(li);
			}
			
			
		}); */
		
		//---------------------------------------------------
		//리스트드 보이고, 리스트를 선택해서 삭제, 이미지파일인 경우 미리보기도 되도록
		// 1) 파일 누적 변수를 만들어서 여러개가 누적될 수 있도록 한다
		
		var fileInput = document.getElementById("files");
		var fileListUI = document.getElementById("fileList");
		
		// *input은 value로 입력한다(단, checkbox와 radio는 checked로 확인한다)
		//			file은 new DataTransfer()객체로 입력한다
		// 파일 누적 저장소
		// <input type="file">은 파일을 누적할 수가 없다
		// DataTransfer 객체를 사용해 FileList를 직접 관리할 수 있다
		// 선택을 여러번 해도 모든 파일을 업로드 할 수 있다
		const dataTransfer = new DataTransfer();
		
		fileInput.addEventListener("change", function(){
			
			const newFiles = this.files;
			
			for(let i=0; i<newFiles.length; i++){
				dataTransfer.items.add(newFiles[i]);
			}
			
			//* input의 files를 누적된 파일로 교체 
			fileInput.files = dataTransfer.files;
			
			//DOM을 생성해서 Append 시켜줌
			renderFileList();
			
		});
		
		//생각해볼것 : 메모리 누수를 해결
		function renderFileList(){
			
			clearPreview();
			//fileInput fileListUI
			
			var preview = document.getElementById("preview");
			preview.innerHTML="";
			fileListUI.innerHTML = "";
			
			for(let i=0; i<dataTransfer.files.length; i++){
				const file = dataTransfer.files[i];
				// 1) 파일의 목록을 만들어주고, 목록에 삭제 버튼을 위치함
				const li = document.createElement("li");
				li.innerHTML = "<span>"+file.name+"</span>" +
								"<button type='button' class='btn btn-sm btn-danger' onclick='removeFile("+i+")'>X</button>";
				fileListUI.appendChild(li);
				
				// 2) 파일이 이미지인 경우 미리보기(image/) => preview 영역에 그려준다. createObjectURL
				if(file.type.startsWith("image/")){
					const img = document.createElement("img");
					img.src = URL.createObjectURL(file);
					
					img.style.width="100px";
					img.style.height = "100px";
					img.style.objectFix = "cover";
					img.className = "rounded border";
					
					preview.appendChild(img);
				}
			}
		} //renderFileList 끝
		
		// 각 파일 목록에 삭제버튼 이벤트
		function removeFile(index){
			dataTransfer.items.remove(index);
			fileInput.files = dataTransfer.files;
			
			renderFileList();
		}
		
		//****** 메모리 누수
		function clearPreview(){
			const images = preview.querySelectorAll("img");
			images.forEach(img => {
				URL.revokeObjectURL(img.src);
			})
		}
		
	</script>
	

</body>
</html>







