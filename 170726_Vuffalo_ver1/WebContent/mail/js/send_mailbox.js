
function searchList(){
	//alert(document.getElementById('search_keyword').value);
	//alert("abc");

	document.getElementById('search_from').submit();
	
}
function remove(){
	var chk_obj = document.getElementById('checkbox');
	var checked = 0;
	for(i = 0; i<checkbox.length; i++){
		if(checkbox[i].checked == true){
			checked +=1;
		}
	}
	if(checked == 0){
		alert("선택된 편지가 없습니다.");
		return;
	}
	document.getElementById('flag').value = 1;
	document.getElementById('selectmail_form').submit();
}

function temp(num){
	document.getElementById('num').value = num;
	document.getElementById('viewMail').submit();
}
