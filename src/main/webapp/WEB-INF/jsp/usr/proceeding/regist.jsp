<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../common/head.jspf"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	&nbsp;<h2>커뮤니티 > 회의록 > 회의록 등록</h2>
	
	<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">회의 유형</div>
			<div class="col-3">
				<div>
  					<input type="checkbox" id="emergency" name="emergency">
  					<label for="emergency">긴급</label>
				</div>
				<div>
  					<input type="checkbox" id="weekly" name="weekly">
  					<label for="weekly">주간</label>
				</div>
				<div>
  					<input type="checkbox" id="monthly" name="monthly">
  					<label for="monthly">월간</label>
				</div>
				<div>
  					<input type="checkbox" id="board" name="board">
  					<label for="board">임원</label>
				</div>
				<div>
  					<input type="checkbox" id="co-op" name="co-op">
  					<label for="co-op">협력</label>
				</div>
			
			</div>
			<div class="col-2 category">회의 제목</div>
			<div class="col-3"><input type="text" id="proceeding_title" placeholder="회의록 제목을 입력해 주세요."></div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">회의 일자</div>
			<div class="col-3">
				<form>
  					<input type='date' id='currentDate'/>
				</form>
			</div>
			<div class="col-2 category">회의 장소</div>
			<div class="col-3">
				<form action="#">
  					<label for="locate"></label>
  					<select name="proceeding_location" id="locate">
   						<option value="1">제1 회의장</option>
    					<option value="2">제2 회의장</option>
    					<option value="3">제3 회의장</option>
    					<option value="4">제4 회의장</option>
    					<option value="5">제5 회의장</option>
    					<option value="6">제6 회의장</option>
    					<option value="7">제7 회의장</option>
  					</select>
  					<input type="submit" value="장소 등록"/>
				</form>
			
			</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">회의 안건</div>
			<div class="col-3">
				<input type="text" id="proceeding_topic" placeholder="회의 안건을 입력해 주세요.">
			</div>
			<div class="col-2 category">작성자 / 소속 부서</div>
			<div class="col-3">${loginUser.loginUser_name } / ${member.member_department }</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">회의록 공개범위</div>
			<div class="col-8">
				
				<div>
  					<input type="checkbox" id="full-disclosure" name="full-disclosure" checked>
  					<label for="full-disclosure">전체 공개</label>
				</div>
				<div>
  					<input type="checkbox" id="hr" name="hr">
  					<label for="hr">인사 부서</label>
				</div>
				<div>
  					<input type="checkbox" id="marketing" name="marketing">
  					<label for="marketing">마케팅 부서</label>
				</div>
				<div>
  					<input type="checkbox" id="sales" name="sales">
  					<label for="sales">영업 부서</label>
				</div>
				<div>
  					<input type="checkbox" id="admin" name="admin">
  					<label for="admin">관리 부서</label>
				</div>
				<div>
  					<input type="checkbox" id="planning" name="planning">
  					<label for="planning">기획 부서</label>
				</div>
				
				<div>
  					<input type="checkbox" id="board-level" name="board-level">
  					<label for="board-level">임원 이상</label>
				</div>
				
			</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">회의 참여자</div>
			<div class="col-8">
				<div class=""></div>
				<div><button>참여자 등록</button>
				</div>
			</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<!-- form 안에 에디터를 사용하는 경우 (보통 이경우를 많이 사용하는듯)-->
				<form method="post">
 					<textarea id="summernote" name="editordata"></textarea>
				</form>
			</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2 category">파일 첨부</div>
			<div class="col-8">
				<div class="row">
					<div class="col-2"><button>파일 업로드</button></div>
					<div class="col-2"><button>선택 삭제</button></div>
					<div class="col-8"></div>
				</div>
				<div class="row">
					<div class="col-12">첨부된 파일, 네모 박스 선택자</div>
				</div>
			</div>
			<div class="col-1"></div>
		</div>
		
		<div class="row">
			<div class="col-1"></div>
			<div class="col-8"></div>
			<div class="col-1"><button>등록</button></div>
			<div class="col-1"><button>목록</button></div>
			<div class="col-1"></div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
		  	height: 300,                 // 에디터 높이
		  	minHeight: null,             // 최소 높이
		  	maxHeight: null,             // 최대 높이
		  	focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  	lang: "ko-KR",					// 한글 설정
		  	placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
          
			});
		});
		
		document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);
	</script>	
	
	<script src="/js/summernote/summernote-lite.js"></script>
	<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
</body>

	<%@include file="../common/foot.jspf"%>
</html>


