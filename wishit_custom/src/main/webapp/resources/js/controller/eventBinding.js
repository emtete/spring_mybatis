
	
function saveEventBinding(){

	$('#save').click(function(){

		if( !run_val() ){
			alert('validation check fail !!');
			return;
		} 
		alert('validation check success	!!');
	});

}


function searchEventBinding(){
	
	//read ( getList )
	$('#searchButton').on('click', function(){ 
		
		runGetList();
	});
}	


