<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin_menu.css"/>
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./js/admin_menu.js"></script>

<div class="admin_menu_main">
	<form>
		<div class="admin_menu">
			<div class="admin_title">
				<h2>관리자설정</h2>
				<h4>페이지를 관리하세요</h4>
				<hr>
			</div>
			<div class="admin_section">
			<table>
				<tr>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_member" value="회원관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_board"  value="게시판관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_report"  value="신고관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_banword"  value="금칙어관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_delete"  value="삭제내역관리"/></td>
					<td class="admin_td_size"><input type="button" class="admin_btn" id="admin_stats"  value="통계관리"/></td>
				</tr>
			</table>
			</div>
		</div>
	</form>
	<div id="board_manage_div" class="board_manage_div" >
		<input type="button" id="add_board_btn" value="게시판 추가하기"/>
		<input type="button" id="modify_board_btn" value="게시판 수정하기"/>
		<input type="button" id="delete_board_btn" value="게시판 삭제하기"/>
	</div>
	</div>
