

var customService = (function(){
	
	function getDetail( param, callback, error ){
		
		var busiNum = param.busiNum;
		
		$.getJSON("/wishit/detail/" + busiNum + ".json",
				function(data){
					if(callback){
						callback(data);
					}
				}).fail( function(xhr, status, err){
						if(err){
							error();
						}
				});
	}
	
	return { getDetail : getDetail };
})();



function runGetDetail(busiNum){
	
	customService.getDetail( { "busiNum" : busiNum },
				function(data){ putDetail(data); },
				function(error){ console.log('fail'); }
	);			
}


function putDetail(data){
	
	$('#busiNum').val( data.custom[0].busiNum );
	$('#custom').val( data.custom[0].custom );
	$('#shortt').val( data.custom[0].shortt );
	$('#ceo').val( data.custom[0].ceo );
	$('#chargePerson').val( data.custom[0].chargePerson );
	$('#busiCondition').val( data.custom[0].busiCondition );
	$('#item').val( data.custom[0].item );
	$('#postNum').val( data.custom[0].postNum );
	$('#addr1').val( data.custom[0].addr1 );
	$('#addr2').val( data.custom[0].addr2 );
	$('#tel').val( data.custom[0].tel );
	$('#fax').val( data.custom[0].fax );
	$('#homepage').val( data.custom[0].homepage );
	$('#countryEng').val( data.custom[0].countryEng );
	$('#countryKor').val( data.custom[0].countryKor );
	$('#contractPeriodS').val( data.custom[0].contractPeriodS );
	$('#contractPeriodE').val( data.custom[0].contractPeriodE );
	$('#regiInfoMan').val( data.custom[0].regiInfoMan );
	$('#regiInfoDate').val( data.custom[0].regiInfoDate );
	$('#modiInfoMan').val( data.custom[0].modiInfoMan );
	$('#modiInfoDate').val( data.custom[0].modiInfoDate );

	$('input[name=coYn]input[value='+ data.custom[0].coYn +']').attr('checked', 'checked')
	$('input[name=foreignYn]input[value='+ data.custom[0].foreignYn +']').attr('checked', 'checked')
	$('#taxYn').val( data.custom[0].taxYn );
	
	$('#specialRelation').attr( 'checked', ynToBool( data.custom[0].specialRelation ) );
	$('#tradeStop').val( 'checked', ynToBool( data.custom[0].tradeStop ) );
	
	
}


function ynToBool(yn){
	
	var isTrue;
	(yn == 'Y') ? isTrue =  true : isTrue = false;
	
	return isTrue;
}









