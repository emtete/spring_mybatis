

$(document).ready(function(){

	saveEventBinding();
});


function saveEventBinding(){

	$('#save').click(function(){

		if( !run_val() ){
			alert('validation check fail !!');
			return;
		} 
		alert('validation check success	!!');
	});

}





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
