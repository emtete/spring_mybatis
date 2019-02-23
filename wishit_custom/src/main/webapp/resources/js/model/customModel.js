


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



function runGetDetail(){
	
	var busiNum = '111-11-11111';
	
	customService.getDetail( { "busiNum" : busiNum },
							function(data){
								putDetail(data);
							},
							function(error){
								console.log('fail');
							}
	);			
}












