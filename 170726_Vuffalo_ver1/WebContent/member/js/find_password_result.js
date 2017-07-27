$(document).ready(function(e) {
	$('#goBtn').go();
	$('#backBtn').back();
	$('#writeBtn').writeContent();
	$('#searchBtn').callsearch();
	$('p').click(function(){
		title = $(this).text();
		num = document.getElementById(title).value;
		$('#contentNum').attr("value",num);
		$('#showContentForm').submit();
	});
	$('#goListBtn').backPage();
});
$.fn.backPage = function() {
	this.click(function(e) {
		//history.back();
		$(location).attr('href', "boardServ.go");
	});
}
$.fn.writeContent = function() {
	this.click(function(e) {
		//open("writerForm.html","srWin","width=1000,height=600");
		//location.href("writeForm.jsp");
		$(location).attr('href', "writeForm.jsp");
		//무슨차이냐....?
	});
}
/*function goWrite(){
	location.href("writeForm.jsp");
}*/
$.fn.callsearch = function() {
	this.click(function(e) {
		/*$('#search').attr('value',"yes");
		alert($('#search').val());*/  //히든으로 값을 넘겨서 검색요청인지 아닌지 확인하려고 했었다.
		keyword = $('#searchKeyword').val();
		if(keyword == ""){
			alert("검색키워드를 입력하세요.");
			return;
		}else{
			alert("검색합니다.");
			$('#searchForm').submit();
			return;
		}
	});
}
$.fn.go = function() {
	this.click(function(e) {
		page = $('#page').val();
		page = parseInt(page) +1;
		if(page > $('#maxPage').val()){
			alert("마지막 페이지입니다.")
			return;
		}else{
			$('#page').attr("value",page);
			$('#pageForm').submit();
		}
	});
}
$.fn.back = function() {
	this.click(function(e) {
		page = $('#page').val();
		if(page == 1){
			alert("첫페이지 입니다.");
			return;
		}else{
			page = $('#page').val();
			page = parseInt(page) -1;
			$('#page').attr("value",page);
			$('#pageForm').submit();
		}
	});
}
