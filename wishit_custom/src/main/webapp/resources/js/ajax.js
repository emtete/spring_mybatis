


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

	
	return { 
		getList : getList
		
			
			};
})();

