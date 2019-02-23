<%@page import="org.wishit.domain.CustomVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
	<title>wishit_custom</title>
	
	
	<link rel="stylesheet" type="text/css" href="resources/css/wishit_custom.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- <script src="resources/js/jquery.js"></script> -->
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	
	<script src="resources/js/controller/customController.js" type="text/javascript"></script>
	<script src="resources/js/controller/eventBinding.js" type="text/javascript"></script>
	
	<script src="resources/js/model/customModel.js" type="text/javascript"></script>
	
	<script src="resources/js/view/customView.js" type="text/javascript"></script>
	<script src="resources/js/view/validation.js" type="text/javascript"></script>
	
</head>
<body>
	
	<div id="header_container">
	
		<div id="header_title">
			<h3>거래처 관리</h3>
		</div>
	
		<div id="header_buttons">
			<input type="button" value="삭제" class="button_top">
			<input type="button" value="저장/수정" class="button_top"  id="save">
			<!-- <input type="button" value="초기화" class="button_top"> -->
		</div>
	
	</div>

	<div id="sidebar_container">
		<div id="sidebar_search">
			<form id="search_form">
				<table id="table_search">
					<tr>
						<td>사업자번호</td>
						<td>
							<input type="text" class="search_textbox" id="search_busiNum">
						</td>
						<td></td>
					</tr>
					<tr>
						<td>거래처명</td>
						<td>
							<input type="text" class="search_textbox" id="search_custom">	
						</td>
						<td><input type="button" value="조회" id = "searchButton"></td>
					</tr>
				</table>
			</form>
			
		</div>

		<div id="sidebar_list">
			
			<table>
				<thead>
						<td>사업자 번호</td>
						<td>거래처명</td>
				</thead>
			</table>

		</div>	
	</div>
	

	<div id="content_detail">
		<form id="content_form" name="content_form">
			<table>
				<tr>
					<td>사업자번호</td>
					<td> 
						<input type="text" id="busiNum">
					</td>
					<td>약	칭</td>
					<td>
						<input type="text" id="shortt">
					</td>
				</tr>
				<tr>
					<td>거 래 처 명</td>
					<td colspan="3"><input type="text" id="custom"></td>	
				</tr>
				<tr>
					<td>대  표  자</td>
					<td><input type="text" id="ceo"></td>
					<td>담  당  자</td>
					<td><input type="text" id="chargePerson"></td>
				</tr>
				<tr>
					<td>업	태</td>
					<td><input type="text" id="busiCondition"></td>
					<td>종	목</td>
					<td><input type="text" id="item"></td>
				</tr>
				<tr>
					<td>우 편 번 호</td>
					<td><input type="text" id="postNum"></td>
					<td>주  소  1</td>
					<td><input type="text" id="addr1"></td>
				</tr>
				<tr>
					<td>주  소  2</td>
					<td colspan="3">
						<input type="text" id="addr2">
					</td>
				</tr>
				<tr>
					<td>전 화 번 호</td>
					<td><input type="text" id="tel"></td>
					<td>팩 스 번 호</td>
					<td><input type="text" id="fax"></td>
				</tr>
				<tr>
					<td>홈 페 이 지</td>
					<td colspan="3">
						<input type="text" id="homepage">
					</td>
				</tr>
				<tr>
					<td>법 인 여 부</td>
					<td>
						<div class="table_Yn">
							<label><input type="radio" name="coYn" value="Y">법인</label>
							&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="coYn" value="N">개인</label>
						</div>
					</td>
					<td>해 외 여 부</td>
					<td>
						<div class="table_Yn">
							<label><input type="radio" name="foreignYn" value="Y">국내</label>&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="foreignYn" value="N">해외</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>과 세 구 분</td>
					<td>
						<select id="taxYn">
							<option value="Y">과세</option>
							<option value="N">면제</option>
						</select>
					</td>
					<td>국	   가</td>
					<td>
						<input type="text" id="countryEng" readonly>
						<input type="text" id="countryKor" readonly>
						<input type="button" value="검색" id="content_select_country">
					</td>
				</tr>
				<tr>
					<td>특수 관계자</td>
					<td>
						<input type="checkbox" value="" id="specialRelation">
					</td>
					<td>거 래 중 지</td>
					<td>
						<input type="checkbox" value="" id="tradeStop">
					</td>
				</tr>
				<tr>
					<td>계 약 기 간</td>
					<td colspan="3">
						<input type="text" id="contractPeriodS" readonly>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								~
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" id="contractPeriodE" readonly>
					</td>
				</tr>
				<tr>
					<td>등 록 정 보</td>
					<td>
						<input type="text" id="regiInfoMan">
						<input type="text" id="regiInfoDate" readonly>
					</td>
					<td>변 경 정 보</td>
					<td>
						<input type="text" id="modiInfoMan">
						<input type="text" id="modiInfoDate" readonly>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						</br>(거래처 계좌정보)
					</td>
				</tr>
			</table>


			<table class="table_account">
				<thead>
					<tr>
						<td>사  무  소</td>
						<td>은     행</td>
						<td>계 좌 번 호</td>
					</tr>
				</thead>
				<tr>
					<td><input type="text" id="factory"></td>
					<td><input type="text" id="tradeBank"></td>
					<td><input type="text" id="accountNum"></td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>











 





