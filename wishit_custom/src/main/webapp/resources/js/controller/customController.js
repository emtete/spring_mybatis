
//null 을 허용하지 않도록 만들었다.
//특정 필드엔 null 을 허용하면서 글자 수만 제한하도록 다형성 적용해서 구현해야 한다.
//거래처 계좌정보는 객체에 저장하지 못했다. 포함필요
//submit 할 때, 특정 데이터( Yn )는 DB에 맞도록 데이터를 변경해서 보내야 한다. 
	//일단 확인되는 사항은 체크박스의 값만 submit 될 때, value = checked 식으로 값을 대입하여 보낸다.
//날짜 필드는 형식을 DATE 로 하는 방법을 찾아야 한다.
// 글자 길이는 바이트로 계산해야 한다.

$(document).ready(function(){

	$('#save').click(function(){

		if( !run_val() ){
			alert('validation check fail !!');
			return;
		} 
		alert('validation check success	!!');
	});
	
	
	
	$('#searchButton').on('click', function(){ 
		
		runGetList();
	});
	
	JSON.stringify
	
	document.cookie = "";
	
	
	
});




//validation check 에 필요한 textFeild의 id 와 제한글자수를 매칭하여 객체로 저장한다.
function generateObject(){
	
	var c_txt_vo = new Object(); // custom_text_vo
	c_txt_vo['busiNum'] = 20;
	c_txt_vo['custom'] = 20;
	c_txt_vo['short'] = 20;
	c_txt_vo['ceo'] = 10;
	c_txt_vo['chargePerson'] = 10;
	c_txt_vo['busiCondition'] = 10;
	c_txt_vo['item'] = 10;
	c_txt_vo['postNum'] = 10;
	c_txt_vo['addr1'] = 80;
	c_txt_vo['addr2'] = 80;
	c_txt_vo['tel'] = 10;
	c_txt_vo['fax'] = 10;
	c_txt_vo['homepage'] = 20;
	// c_txt_vo['coYn']
	// c_txt_vo['foreignYn']
	// c_txt_vo['taxYn']
	c_txt_vo['countryEng'] = 20;
	c_txt_vo['countryKor'] = 20;
	// c_txt_vo['specialRelation']
	// c_txt_vo['tradeStop']
	// c_txt_vo['contractPeriodS']
	// c_txt_vo['contractPeriodE']
	c_txt_vo['regiInfoMan'] = 10;
	// c_txt_vo['regiInfoDate']
	c_txt_vo['modiInfoMan'] = 10;
	// c_txt_vo['modiInfoDate']

	return c_txt_vo;
}



// 객체의 키값과 매칭되는 글자제한수를 가져온다. generateObject()
// validation check의 기준의 정의를 가져온다. validation_check()
//반복문을 돌려서 validation check를 수행한다.
function run_val(){

	var c_txt_vo = generateObject();

	for( vo in c_txt_vo ){
		if( !validation_check( vo, c_txt_vo[vo] ) ){
			return false;
		}		
	}
	return true;
}

//validation check의 기준을 정의한다.
function validation_check(elId, limit){
	var id = $('#'+elId).attr('value').trim();
	var textLength = id.length;
	
	
	if(textLength > limit || textLength == 0){
		
		return false;	
	}
	return true; 
	
}















