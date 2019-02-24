

$(document).ready(function(){
	hideTableRow();
	searchEventBinding();
});



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
				if(callback){

					callback(data);
				}
			}).fail(function(xhr, status, err){
					if(error){
						error();
					}
			});
	}
	
	return { getList : getList };
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




