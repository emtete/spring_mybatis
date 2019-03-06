

$(document).ready(function(){


	saveEventBinding();
	// setRegiButton();
	// setResetButton();

	buttonEvent.resetEventBinding();
	buttonEvent.setButtonRegiOrModi();




});


var buttonEvent = {

	
	resetEventBinding : function(){
		$('#resetButton').on('click', function(){
			eventAfter();
		});

		var eventAfter = function (){
			CookieUtil.unset('list.busiNum');
			CookieUtil.unset('list.custom');
			CookieUtil.unset('detail.busiNum');
			window.location.reload();
		}
	},


	setButtonRegiOrModi : function(){
		var detailCookie = CookieUtil.get('detail.busiNum');
		( typeof detailCookie == 'string' ) ? below( update, '수정' ) 
											: below( regiCustomVoModule.regiRun, '등록' ); 

		function below( btnEvntBinding, value ){
			$('#regiButton').attr('value',value);
			$('#regiButton').on('click', function(){
				btnEvntBinding();
			});
		}
	}


}

// function setResetButton(){

// 	$('#resetButton').on('click', function(){
// 		CookieUtil.unset('list.busiNum');
// 		CookieUtil.unset('list.custom');
// 		CookieUtil.unset('detail.busiNum');
// 		window.location.reload();
// 	});
// }



// function setRegiButton(){

// 	var detail = CookieUtil.get('detail.busiNum');
// 	(typeof detail == 'string') ? setBtnEvnt(update, '수정') : setBtnEvnt(regiRun, '등록'); 

// }



// function setBtnEvnt(setBtn, value){
	
// 	$('#regiButton').on('click', function(){
// 			setBtn();
// 	});

// 	$('#regiButton').attr('value',value);
// }








var regiCustomVoModule = ( function(){

	function regiRun(){
		regiCustomVoModule.register(regiCallback);
	}

	function register(regiCallback, error){

		var formObj = formToObject( $('#detailForm') );

		$.ajax({
			type : 'post',
			url : '/wishit/insert',
			contentType: "application/json",
			data : JSON.stringify(formObj),
			dataType : "json",
			success : function(result, status, xhr){

					if (regiCallback) regiCallback(result);
			},
			error : function(xhr, status, er){

					if (error) error(er);
			}
		});
	}


	function regiCallback(result){
		console.log(result);
	}



// argument : $('form')
// return 	: CustomVO
	function formToObject( originalFormObj ){
	
		var sArray = originalFormObj.serializeArray();
		var customVO = new Object;

		$.each(sArray, function(index, data){
			customVO[data.name] = data.value;
		});

		customVO = objToHasA(customVO);

		return customVO;
	}


	/*
	자료구조 변경
		customVO 에 accountVO의 필드까지 섞여있는 형태를
		accountVO 와 has a 관계로 변경한다.
		
		argument 	: customVO( accountVO필드와 섞여 있음 )
		return		: customVO( customVO has a accountVO )
	*/
	function objToHasA( custom ){

		var account = new Object;

		account['factory'] =  custom['factory'];
		account['tradeBank'] = custom['tradeBank'];
		account['accountNum'] = custom['accountNum'];
		account['busiNum'] = custom['busiNum'];

		delete custom['factory'];
		delete custom['tradeBank'];
		delete custom['accountNum'];

		custom['accountVO'] = account;

		/*
			sr and ts is CheckkBox
		*/
		var sr = $('#specialRelation');
		var ts = $('#tradeStop');

		( sr.prop('checked') )	? custom['specialRelation'] = 'Y' 
								: custom['specialRelation'] = 'N';

		( ts.prop('checked') )	? custom['tradeStop'] = 'Y'
								: custom['tradeStop'] = 'N';

		return custom;
	}


	return { register 		: 	register,
			 regiRun 		: 	regiRun,
			 regiCallback 	: 	regiCallback,
			 formToObject	:	formToObject,
			 objToHasA 		: 	objToHasA };
})();












function update(){
	alert('update');
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
	
	var customVO = new Object(); // custom_text_vo
	customVO['busiNum'] = 20;
	customVO['custom'] = 20;
	customVO['shortt'] = 20;
	customVO['ceo'] = 10;
	customVO['chargePerson'] = 10;
	customVO['busiCondition'] = 10;
	customVO['item'] = 10;
	customVO['postNum'] = 10;
	customVO['addr1'] = 80;
	customVO['addr2'] = 80;
	customVO['tel'] = 10;
	customVO['fax'] = 10;
	customVO['homepage'] = 20;
	// customVO['coYn']
	// customVO['foreignYn']
	// customVO['taxYn']
	customVO['countryEng'] = 20;
	customVO['countryKor'] = 20;
	// customVO['specialRelation']
	// customVO['tradeStop']
	// customVO['contractPeriodS']
	// customVO['contractPeriodE']
	customVO['regiInfoMan'] = 10;
	// customVO['regiInfoDate']
	customVO['modiInfoMan'] = 10;
	// customVO['modiInfoDate']

	return customVO;
}



// 객체의 키값과 매칭되는 글자제한수를 가져온다. generateObject()
// validation check의 기준의 정의를 가져온다. validation_check()
//반복문을 돌려서 validation check를 수행한다.
function run_val(){

	var customVO = generateObject();

	for( vo in customVO ){

		if( !validation_check( vo, customVO[vo] ) ){
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
