package manager;

import dao.DailyActiveListDAO;
import dao.MemberActivityListDAO;
import dao.MemberListDAO;
import vo.MemberActivityVO;
import vo.MemberVO;

public class LoginManager {
	private MemberListDAO memberListDAO;
	private DailyActiveListDAO dailyActiveListDAO;
	
	public LoginManager() {
		super();
		this.memberListDAO=MemberListDAO.getInstance();
		this.dailyActiveListDAO=DailyActiveListDAO.getInstance();
	}
	public LoginManager(MemberListDAO memberListDAO, DailyActiveListDAO dailyActiveListDAO) {
		super();
		this.memberListDAO = memberListDAO;
		this.dailyActiveListDAO = dailyActiveListDAO;
	}
	
	public int checkLoginInfo(String id,String pwd){
		
		MemberVO memberVO = this.memberListDAO.searchMemberVOById(id);
		
		if(memberVO!=null) //회원에서 아이디존재
		{
			if(memberVO.getPassword().equals(pwd)){ //비밀번호확인
				return memberVO.getState(); //회원상태정보 리턴(1:일반2:정지3:강퇴)
			}
		}
		return 0;
	}
	
	public MemberVO login(String id, String pwd){
		
		//리턴할 그릇객체 선언
		//해당 아이디의 회원을 받아옴
		//System.out.println("로그인시훑어보는회원목록 :"+this.memberListDAO.getMemberVOList());
		MemberVO memberVO = this.memberListDAO.searchMemberVOById(id);
		//System.out.println("로그인전:"+memberVO);
		if(memberVO!=null){ //아이디가 존재하는 회원
			//아이디, 비밀번호 확인
			if(!this.memberListDAO.searchPwdById(id).equals(pwd)){
				return null;
			}
			
			//회원일경우(1:일반 2:정지 3:강퇴)
			if(this.memberListDAO.searchStateById(id)==1){
				
				//해당 아이디의 당일 활동점수로 받아서 세팅(총활동점수->당일활동점수로)
				int activePoint = this.dailyActiveListDAO.searchActivePoint(memberVO.getMemberNum());
				memberVO.setActivePoint(activePoint);
				
				//해당 아이디의 회원번호 암호화
				int encodeNum= memberVO.getMemberNum();
				//int encodeNum = KeyEncoder.encodeKey(memberVO.getMemberNum());
				memberVO.setMemberNum(encodeNum);
				
				//MemberVO mvo = new MemberVO(encodeNum)
				//System.out.println("login후 member정보"+memberVO);
				
				return memberVO;
			}
			else{ //정지/강퇴회원처리 나중에
				return memberVO; 
			}
		}
		return null;
	}
	
	public MemberListDAO getMemberListDAO() {
		return memberListDAO;
	}
	public void setMemberListDAO(MemberListDAO memberListDAO) {
		this.memberListDAO = memberListDAO;
	}
	public DailyActiveListDAO getDailyActiveListDAO() {
		return dailyActiveListDAO;
	}
	public void setDailyActiveListDAO(DailyActiveListDAO dailyActiveListDAO) {
		this.dailyActiveListDAO = dailyActiveListDAO;
	}
	public String toString() {
		return "LoginManager [memberListDAO=" + memberListDAO + ", dailyActiveListDAO=" + dailyActiveListDAO + "]";
	}
	
	
	
}
