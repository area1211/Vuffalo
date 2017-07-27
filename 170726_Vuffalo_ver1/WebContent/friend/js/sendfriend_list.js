
function hi(){
	/*
	$("iv1").hover(function(){
		alert("hi");
		$("iv1").play();
	});
}
*/
	
	var video = document.getElementById("iv1");
    if (video.paused) {
       video.play();
    } else {
       video.pause();
    }
}

function modifyProfile(){
   alert("전송합니다");
   document.getElementById("myProfileForm").submit();
}
function cancelModifyProfile(){
   alert("수정 취소합니다");
}
function fileInfo(f){
      var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음
      // file 은 배열이므로 file[0] 으로 접근해야 함

      if(file[0].size > 1024 * 1024){
         // 큰 파일을 올리니까 브라우저가 다운되었음 -_-;;
         alert('1MB 이상의 파일은 안돼!!!');
         return;
      }
}
      /* var reader = new FileReader(); // FileReader 객체 사용
      reader.onload = function(rst){ // 파일을 다 읽었을 때 실행되는 부분
         $('[name=base64text]').val(rst.target.result); // 해당 파일의 base64 값을 가져옴
      }
      reader.readAsDataURL(file[0]); // 파일을 읽는다 */
