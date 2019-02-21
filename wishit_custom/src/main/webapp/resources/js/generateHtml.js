
function sidebarListAppend(data){
	
	
	$.each( data, function( index, custom ){
		$('#sidebar_list table')
		.append('<tr><td>'+custom.busiNum+'</td><td>'+custom.custom+'</td></tr>');
	})
	
}

