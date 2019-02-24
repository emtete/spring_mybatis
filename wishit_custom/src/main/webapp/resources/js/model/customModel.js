


var customService = (function(){

	function getList( param, callback, error ){

		var busiNum = param.busiNum;
		var custom = param.custom;
		
		
		$.getJSON("/wishit/list/" + busiNum + "/" + custom +".json", 
			function(data){
				if(callback){
					
					
					callback(data);
					// setListCookie(data);
				}
			}).fail(function(xhr, status, err){
					if(error){
						error();
					}
				});
	}
	
	
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

	
	return {
				getList : getList,
				getDetail : getDetail
			};
})();



function runGetList(){
	var busiNum = $('#search_busiNum').val();
	var custom = $('#search_custom').val();
	
	customService.getList( { "busiNum": busiNum, 
							 "custom" : custom },
							
				function(data){
					sidebarListAppend(data);
				},
				function(error){
					console.log("fail");
				}
			);
}

function sidebarListAppend(data){

	$.each( data, function(index, custom){
		console.log('data.length : '+data.length);
		console.log('index : '+index);
		
		
		$('#list_tr' + index ).show();

		$('#list_link'+index).text(custom.busiNum);
		$('#list_tr'+index+' .list_td2').text(custom.custom);

		getDetailEventBinding( index, custom.busiNum );
	});
}



function getDetailEventBinding( index, busiNum ){

	$('#list_link'+index).on( 'click', function(){
		runGetDetail( busiNum );
	});
}



function runGetDetail(busiNum){
	
	customService.getDetail( { "busiNum" : busiNum },
							function(data){
								putDetail(data);
							},
							function(error){
								console.log('fail');
							}
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









