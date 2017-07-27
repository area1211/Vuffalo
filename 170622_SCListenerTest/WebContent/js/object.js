$.errMsg = {
	contain_blank : "아이디에 공백문자가 포함되어있습니다!"
	
}


var checkId = function(){
	if($('input#id').val().indexOf(" ") >= 0){
		alert(contain_blank);
		$('input#id').prop('value', "");
		$('input#id').focus();
		return false;
	} else if ($('input#id').val().length < 4){
		alert("아이디는 4자 이상이어야 합니다!");
		$('input#pwd').prop('value', "");
		$('input#id').focus();
		return false;
	} else if (isNumber($('input#id').val().charAt(0))){
		alert("아이디는 숫자로 시작할 수 없습니다!");
		$('input#pwd').prop('value', "");
		$('input#id').focus();
		return false;
	}
	
	return true;
};

var checkPwd = function(){
	reg = '^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,19}$';
	if($('input#pwd').val().indexOf(" ") >= 0){
		alert("비밀번호에 공백문자가 포함되어있습니다!");
		$('input#pwd').prop('value', "");
		$('input#pwd').focus();
		return false;
	} else if ($('input#pwd').val().length < 6){
		alert("비밀번호는 6자 이상이어야 합니다!");
		$('input#pwd').prop('value', "");
		$('input#pwd').focus();
		return false;
	} 
	else if (!($('input#pwd').val().match(reg))){
	//else if(!RegExp(reg, 'i').test(!$('input#pwd').val())){
		alert("비밀번호는 영문, 숫자, 특수문자의 조합이어야 합니다!");
		$('input#pwd').prop('value', "");
		$('input#pwd').focus();
		return false;
	}
	
	return true;
}

function isNumber(s) {
	s += ''; // 문자열로 변환
	s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
	if (s == '' || isNaN(s)) return false;
	  return true;
}

$(document).ready(function(e){

	$('input#login').click(function(e){
		//alert("로그인버튼클릭!");
		if(checkId() && checkPwd()){
			alert("유효성검증통과");
			$('form#end').submit();
			return true;
		}
		
		return false;
	});
	
});