
//null 을 허용하지 않도록 만들었다.
//특정 필드엔 null 을 허용하면서 글자 수만 제한하도록 다형성 적용해서 구현해야 한다.
//거래처 계좌정보는 객체에 저장하지 못했다. 포함필요
//submit 할 때, 특정 데이터( Yn )는 DB에 맞도록 데이터를 변경해서 보내야 한다. 
	//일단 확인되는 사항은 체크박스의 값만 submit 될 때, value = checked 식으로 값을 대입하여 보낸다.
//날짜 필드는 형식을 DATE 로 하는 방법을 찾아야 한다.
// 글자 길이는 바이트로 계산해야 한다.

$(document).ready(function(){

	
	saveEventBinding();
	searchEventBinding();
	
//	keepData();
//	console.log(document.cookie);
	

	
});

//새로고침 하면 사라지는 데이터 유지. 
function keepData(){
	sidebarListAppend(data);
}
















