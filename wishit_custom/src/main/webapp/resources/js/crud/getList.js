

$(document).ready(function(){

	hideTableRow();
	searchEventBinding();
	reLoadAction.list();
	reLoadAction.detail();
	
});



var reLoadAction = {
	
	list : function(){

		var busiNum = CookieUtil.get('list.busiNum');
		var custom = CookieUtil.get('list.custom');

		if( typeof busiNum == 'string' && typeof busiNum == 'string' ){
			$('#search_busiNum').val(busiNum);
			$('#search_custom').val(custom);	

			runGetList(); 
		}	
	},

	detail : function(){
		
		var busiNum = CookieUtil.get('detail.busiNum');

		if (typeof busiNum == 'string') 
			customVoModule.runGetDetail(busiNum);
	}
}




function searchEventBinding(){
	
	$('#searchButton').on('click', function(){ 
		runGetList();
	});
}	



function hideTableRow(){
	$('tr[class="list_tr"]').hide();
}



var customService = (function(){

	function getList( param, callback, error ){

		var busiNum = param.busiNum;
		var custom = param.custom;
		
		
		$.getJSON("/wishit/list/" + busiNum + "/" + custom +".json", 
			function(data){ 
				console.log('data : '+Object.keys(data));
				console.log('data[0] : '+data[0]);
				console.log('keys(data[0]) : '+Object.keys(data[0]) );
				if (callback) callback(data); 
			}
		).fail( 
			function(xhr, status, err){
				if (error) error();
			}
		);

	}
	
	return { getList : getList };
})();



function runGetList(){
	var busiNum = $('#search_busiNum').val();
	var custom = $('#search_custom').val();
	
	CookieUtil.set('list.busiNum', busiNum);
	CookieUtil.set('list.custom', custom);

	customService.getList( { "busiNum": busiNum, "custom" : custom },
							function(data){ callbackForList(data); },
							function(error){ console.log("fail"); }
						 );
}



function callbackForList(data){

	$.each( data, function(index, custom){
		$('#list_tr' + index ).show();
		$('#list_link'+index).text(custom.busiNum);
		$('#list_tr'+index+' .list_td2').text(custom.custom);

		getDetailEventBinding( index, custom.busiNum );
	});
}



function getDetailEventBinding( index, busiNum ){

	$('#list_link'+index).on( 'click', function(){
		customVoModule.runGetDetail(busiNum);
		CookieUtil.set('detail.busiNum', busiNum);
	});
}




