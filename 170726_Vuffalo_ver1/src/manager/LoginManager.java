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
		
		if(memberVO!=null) //ȸ������ ���̵�����
		{
			if(memberVO.getPassword().equals(pwd)){ //��й�ȣȮ��
				return memberVO.getState(); //ȸ���������� ����(1:�Ϲ�2:����3:����)
			}
		}
		return 0;
	}
	
	public MemberVO login(String id, String pwd){
		
		//������ �׸���ü ����
		//�ش� ���̵��� ȸ���� �޾ƿ�
		//System.out.println("�α��ν��Ⱦ��ȸ����� :"+this.memberListDAO.getMemberVOList());
		MemberVO memberVO = this.memberListDAO.searchMemberVOById(id);
		//System.out.println("�α�����:"+memberVO);
		if(memberVO!=null){ //���̵� �����ϴ� ȸ��
			//���̵�, ��й�ȣ Ȯ��
			if(!this.memberListDAO.searchPwdById(id).equals(pwd)){
				return null;
			}
			
			//ȸ���ϰ��(1:�Ϲ� 2:���� 3:����)
			if(this.memberListDAO.searchStateById(id)==1){
				
				//�ش� ���̵��� ���� Ȱ�������� �޾Ƽ� ����(��Ȱ������->����Ȱ��������)
				int activePoint = this.dailyActiveListDAO.searchActivePoint(memberVO.getMemberNum());
				memberVO.setActivePoint(activePoint);
				
				//�ش� ���̵��� ȸ����ȣ ��ȣȭ
				int encodeNum= memberVO.getMemberNum();
				//int encodeNum = KeyEncoder.encodeKey(memberVO.getMemberNum());
				memberVO.setMemberNum(encodeNum);
				
				//MemberVO mvo = new MemberVO(encodeNum)
				//System.out.println("login�� member����"+memberVO);
				
				return memberVO;
			}
			else{ //����/����ȸ��ó�� ���߿�
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
