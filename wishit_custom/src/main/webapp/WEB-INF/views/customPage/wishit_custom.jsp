<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
	<title>wishit_custom</title>
	
	
	<link rel="stylesheet" type="text/css" href="resources/css/wishit_custom.css">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	<link rel="shortcut icon" href="favicon.ico">

	<script>

		
	</script>
	
</head>
<body>
	
	<div id="header_container">
	
		<div id="header_title">
			<h3>거래처 관리</h3>
		</div>
	
		<div id="header_buttons">
			<input type="button" value="삭제" class="button_top">
			<input type="button" value="저장/수정" class="button_top"  id="regiButton">
			<input type="button" value="초기화" class="button_top"  id="resetButton">
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
					
					<tr id="list_tr0" class="list_tr">
						<td class="list_td1">
							<a href="#" id="list_link0"></a>
						</td>
						<td class="list_td2"></td>
					</tr>
					<tr id="list_tr1" class="list_tr">
						<td class="list_td1">
							<a href="#" id="list_link1"></a>
						</td>
						<td class="list_td2"></td>
					</tr>
					<tr id="list_tr2" class="list_tr">
						<td class="list_td1">
							<a href="#" id="list_link2"></a>
						</td>
						<td class="list_td2"></td>
					</tr>
					<tr id="list_tr3" class="list_tr">
						<td class="list_td1">
							<a href="#" id="list_link3"></a>
						</td>
						<td class="list_td2"></td>
					</tr>
					<tr id="list_tr4" class="list_tr">
						<td class="list_td1">
							<a href="#" id="list_link4"></a>
						</td>
						<td class="list_td2"></td>
					</tr>					
					
				</table>
		</div>	
	</div>
	

	<div id="content_detail">
		<form id="detailForm" name="detailForm">
			<table>
				<tr>
					<td style="width:100px;">사업자번호</td>
					<td> 
						<input type="text" id="busiNum" name="busiNum">
					</td>
					<td style="width:100px;">약	칭</td>
					<td>
						<input type="text" id="shortt" name="shortt">
					</td>
				</tr>
				<tr>
					<td>거 래 처 명</td>
					<td colspan="3"><input type="text" id="custom" name="custom"></td>	
				</tr>
				<tr>
					<td>대  표  자</td>
					<td><input type="text" id="ceo" name="ceo"></td>
					<td>담  당  자</td>
					<td><input type="text" id="chargePerson" name="chargePerson"></td>
				</tr>
				<tr>
					<td>업	태</td>
					<td><input type="text" id="busiCondition" name="busiCondition"></td>
					<td>종	목</td>
					<td><input type="text" id="item" name="item"></td>
				</tr>
				<tr>
					<td>우 편 번 호</td>
					<td><input type="text" id="postNum" name="postNum"></td>
					<td>주  소  1</td>
					<td><input type="text" id="addr1" name="addr1"></td>
				</tr>
				<tr>
					<td>주  소  2</td>
					<td colspan="3">
						<input type="text" id="addr2" name="addr2">
					</td>
				</tr>
				<tr>
					<td>전 화 번 호</td>
					<td><input type="text" id="tel" name="tel"></td>
					<td>팩 스 번 호</td>
					<td><input type="text" id="fax" name="fax"></td>
				</tr>
				<tr>
					<td>홈 페 이 지</td>
					<td colspan="3">
						<input type="text" id="homepage" name="homepage">
					</td>
				</tr>
				<tr>
					<td>법 인 여 부</td>
					<td>
						<div class="table_Yn">
							<label><input type="radio" name="coYn" value="Y" checked="checked">법인</label>
							&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="coYn" value="N">개인</label>
						</div>
					</td>
					<td>해 외 여 부</td>
					<td>
						<div class="table_Yn">
							<label><input type="radio" name="foreignYn" value="Y" checked="checked">국내</label>&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="foreignYn" value="N">해외</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>과 세 구 분</td>
					<td>
						<select id="taxYn" name="taxYn">
							<option value="Y">과세</option>
							<option value="N">면제</option>
						</select>
					</td>
					<td>국	   가</td>
					<td>
						<input type="text" id="countryEng" name="countryEng" ><!-- readonly -->
						<input type="text" id="countryKor" name="countryKor" ><!-- readonly -->
						<input type="button" value="검색" id="content_select_country">
					</td>
				</tr>
				<tr>
					<td>특수 관계자</td>
					<td>
						<input type="checkbox" value="" id="specialRelation" name="specialRelation">
					</td>
					<td>거 래 중 지</td>
					<td>
						<input type="checkbox" value="" id="tradeStop" name="tradeStop">
					</td>
				</tr>
				<tr>
					<td>계 약 기 간</td>
					<td colspan="3">
						<input type="text" id="contractPeriodS" name="contractPeriodS" ><!-- readonly -->
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								~
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" id="contractPeriodE" name="contractPeriodE" ><!-- readonly -->
					</td>
				</tr>
				<tr>
					<td>등 록 정 보</td>
					<td>
						<input type="text" id="regiInfoMan" name="regiInfoMan">
						<input type="text" id="regiInfoDate" name="regiInfoDate" ><!-- readonly -->
					</td>
					<td>변 경 정 보</td>
					<td>
						<input type="text" id="modiInfoMan" name="modiInfoMan">
						<input type="text" id="modiInfoDate" name="modiInfoDate" ><!-- readonly -->
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
					<td><input type="text" id="factory" name="factory"></td>
					<td><input type="text" id="tradeBank" name="tradeBank"></td>
					<td><input type="text" id="accountNum" name="accountNum"></td>
				</tr>
				
			</table>
		</form>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script src="resources/js/crud/register.js" type="text/javascript"></script>
	<script src="resources/js/crud/getDetail.js" type="text/javascript"></script>
	<script src="resources/js/crud/getList.js" type="text/javascript"></script>
	
	<script src="resources/js/reLoad.js" type="text/javascript"></script>
	

</body>
</html>











 





