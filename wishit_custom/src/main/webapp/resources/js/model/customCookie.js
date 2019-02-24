
function setListCookie(data){
	var tempStr = "";
	
	data.forEach(function(element){
		Object.keys( element ).forEach( function(key){

			
			tempStr += key+"="+element[key]+",";
//			document.cookie = "list."+key+"="+element[key];
		});
	});
	tempStr = tempStr.substring(0, tempStr.length-1);
	document.cookie = tempStr;
	
	console.log( "tempStr : " + tempStr );
	console.log( "cookie : " + document.cookie );
}

function getListCookie(){
//	var cookie = document.cookie;
//	var strArray = cookie.split(',');
//	var cookieObject;
//	var name;
//	var value;
////	var eleArray = new Array();
//	
//	strArray.forEach( function(element){
//		var eleArray = element.split('=');
//		
//		
//		cookieObject = { 
////				eleArray[0] : eleArray[1]
//				
//		}
//	});
//	
//	
//	
////	cookie.
}