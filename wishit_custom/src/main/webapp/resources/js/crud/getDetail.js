

/*
	핵심 키워드 : ajax, rest, detail, get, json, module, customVO, accountVO

	var getCustomVoModule
		getVoByAjax()
		runGetDetail()
		callbackForDetail()
		ynToBool()	
*/


var getCustomVoModule = (function(){
	

	function getVoByAjax( param, callback, error ){
		
		var busiNum = param.busiNum;
		
		$.getJSON ("/wishit/detail/" + busiNum + ".json",		
			function(data){ 
				if (callback) callback(data); 
			}
		).fail( 
			function(xhr, status, err){ 
				if (err) error(); 
			}
		);

	}


	function runGetDetail(busiNum){ 
	
		getVoByAjax ( 
			{ "busiNum" : busiNum },
			function(data){ 
				callbackForDetail(data); 
			},
			function(error){ 
				console.log('fail'); 
			}
		);

	}


	function callbackForDetail(data){ 

		$('#busiNum').val( data.busiNum );
		$('#custom').val( data.custom );
		$('#shortt').val( data.shortt );
		$('#ceo').val( data.ceo );
		$('#chargePerson').val( data.chargePerson );
		$('#busiCondition').val( data.busiCondition );
		$('#item').val( data.item );
		$('#postNum').val( data.postNum );
		$('#addr1').val( data.addr1 );
		$('#addr2').val( data.addr2 );
		$('#tel').val( data.tel );
		$('#fax').val( data.fax );
		$('#homepage').val( data.homepage );
		$('#countryEng').val( data.countryEng );
		$('#countryKor').val( data.countryKor );
		$('#contractPeriodS').val( data.contractPeriodS );
		$('#contractPeriodE').val( data.contractPeriodE );
		$('#regiInfoMan').val( data.regiInfoMan );
		$('#regiInfoDate').val( data.regiInfoDate );
		$('#modiInfoMan').val( data.modiInfoMan );
		$('#modiInfoDate').val( data.modiInfoDate );

		$('input[name=coYn]input[value='+ data.coYn +']').attr('checked', 'checked')
		$('input[name=foreignYn]input[value='+ data.foreignYn +']').attr('checked', 'checked')
		$('#taxYn').val( data.taxYn );
		
		$('#specialRelation').attr( 'checked', ynToBool( data.specialRelation ) );
		$('#tradeStop').val( 'checked', ynToBool( data.tradeStop ) );

		
		$('#factory').val( data.accountVO.factory );
		$('#tradeBank').val( data.accountVO.tradeBank );
		$('#accountNum').val( data.accountVO.accountNum );
	}



	function ynToBool(yn){
		
		var isTrue;
		(yn == 'Y') ? isTrue =  true : isTrue = false;
		
		return isTrue;
	}



	
	return { getVoByAjax : getVoByAjax,
			 runGetDetail : runGetDetail };
})();













