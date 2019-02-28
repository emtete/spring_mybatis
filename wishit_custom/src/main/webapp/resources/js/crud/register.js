

$(document).ready(function(){

	saveEventBinding();
	setRegiButton();
	setResetButton();



});



function setResetButton(){

	$('#resetButton').on('click', function(){
		CookieUtil.unset('list.busiNum');
		CookieUtil.unset('list.custom');
		CookieUtil.unset('detail.busiNum');
		window.location.reload();
	});
}



function setRegiButton(){

	var detail = CookieUtil.get('detail.busiNum');
	(typeof detail == 'string') ? setBtnEvnt(update, '수정') : setBtnEvnt(regiRun, '등록'); 

}



function setBtnEvnt(setBtn, value){
	
	$('#regiButton').on('click', function(){
			setBtn();
	});

	$('#regiButton').attr('value',value);
}



function regiRun(){
	registerService.register(regiCallback);
}

function regiCallback(result){
	console.log(result);
}


var registerService = ( function(){

	function register(callback, error){

		var formObj = serializeObject( $('#detailForm') );
		
		console.log(formObj);
		$.ajax({
			type : 'post',
			url : '/wishit/insert',
			contentType: "application/json",
			data : JSON.stringify(formObj),
			dataType : "json",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);	
				}
			}
		});
	}
	return { register : register };
})();



/*
	문제.
		form을 통해 서버로 체크박스의 값이 전송되야 한다.
		전송되는 값은 Y or N 이어야 한다.
		체크박스는 true 혹은 undefined를 리턴한다.
		체크박스가 체크되어있지 않을 경우, 
		form 객체에 체크박스 객체가 없는걸 확인할 수 있다.


	문제해결
		체크박스의 객체를 호출한다.
		각 객체의 값에 따라. 
			true	: 	value = 'Y';
			false	: 	value = 'N'; 그리고 
						체크박스 객체를 만들어 form객체에 저장한다.

 
*/
function putValueToCheckBox(arr){

	

	function samething(elementId, element, arr){
		element.val('N');
		var arrLength = arr.length;
		arr[arrLength] = [{ 'name' : elementId, 'value' : 'N'}];

		return	arr;
	}

	return arr;
}




function serializeObject(jqueryObject){
	var arr = jqueryObject.serializeArray();
	var custom = new Object;

	arr = putValueToCheckBox(arr);

	$.each(arr, function(index, data){
		custom[data.name] = data.value;
	});

	custom = insertObject(custom);
	


	return custom;
}

/*
	문제
		account, custom 두 객체 모두 busiNum필드를 갖고있다.
		결과, 서버에 데이터를 보낼 경우, 바인딩이 안된다.

	문제해결
		custom객체에 account객체를 넣는다.
*/

function insertObject(custom){
	var account = new Object;

	account['factory'] =  custom['factory'];
	account['tradeBank'] = custom['tradeBank'];
	account['accountNum'] = custom['accountNum'];
	// account['busiNum'] = custom['busiNum'];

	delete custom['factory'];
	delete custom['tradeBank'];
	delete custom['accountNum'];

	custom['accountVO'] = account;

	var sr = $('#specialRelation');
	var ts = $('#tradeStop');

	( sr.prop('checked') )	? custom['specialRelation'] = 'Y' 
							: custom['specialRelation'] = 'N';

	( ts.prop('checked') )	? custom['tradeStop'] = 'Y'
							: custom['tradeStop'] = 'N';


	return custom;
}






function update(){

}


function saveEventBinding(){

	$('#regiButton').click(function(){

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
	c_txt_vo['shortt'] = 20;
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
	
	var id = $('#'+elId).val().trim();
	var textLength = id.length;
	
	if(textLength > limit || textLength == 0){
		
		return false;	
	}
	return true; 
	
}
