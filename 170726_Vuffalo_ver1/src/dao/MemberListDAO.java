package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.MemberVO;

public class MemberListDAO {
	private static MemberListDAO instance;

	private List<MemberVO> memberVOList;
	private List<MemberVO> addedMemberVOList;
	private List<MemberVO> deletedMemberVOList;
	private List<MemberVO> editedMemberVOList;

	static{
		instance = new MemberListDAO();

	}
	private MemberListDAO(){
		readFromDB();
	}
	private MemberListDAO(List<MemberVO> memberVOList, List<MemberVO> addedMemberVOList, List<MemberVO> deletedMemberVOList, List<MemberVO> editedMemberVOList){
		this.memberVOList = memberVOList;
		this.addedMemberVOList = addedMemberVOList;
		this.deletedMemberVOList = deletedMemberVOList;
		this.editedMemberVOList = editedMemberVOList;
	}
	public static MemberListDAO getInstance(){
		instance.readFromDB();
		return instance;
	}

	private void addMemberVO(MemberVO memberVO){
		this.memberVOList.add(memberVO);
		this.addedMemberVOList.add(memberVO);
	}


	public void addMemberVO(int memberNum, String memberId, String nickName, String password, String email, byte grade, int activePoint, String joinDate, byte state){
		addMemberVO(new MemberVO(memberNum, memberId, nickName, password, email, grade, activePoint, joinDate, state));
	}
	public MemberVO searchMemberVO(List<MemberVO> tempList, int memberNum){
		if(tempList == null){
			return null;
		}
		for(MemberVO temp : tempList){
			if(temp.getMemberNum() == memberNum){
				return temp;
			}
		}
		return null;

	}
	public MemberVO searchMemberVOById(String id){
		if(id == null || memberVOList == null)
			return null;
		for(MemberVO temp : memberVOList){
			if(temp.getMemberId().equals(id)){
				return temp;
			}
		}
		return null;
	}
	public MemberVO searchMemberVO(int memberNum){
		if(memberVOList == null){
			return null;
		}
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberNum() == memberNum){
				return tempVO;
			}
		}
		return null;
	}
	public MemberVO searchMemberVO(String nickName){
		if(memberVOList == null){
			return null;
		}
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getNickName().equals(nickName)){
				return tempVO;
			}
		}
		return null;
	}
	public int searchMemberNumById(String id){
		if(memberVOList == null){
			return 0;
		}
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberId().equals(id)){
				return tempVO.getMemberNum();
			}
		}
		return 0;
	}
	public String searchPwdById(String id){
		if(memberVOList == null){
			return null;
		}
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberId().equals(id)){
				return tempVO.getPassword();
			}
		}
		return null;
	}
	public String searchNickNameById(String id){

		if(memberVOList == null){
			return null;
		}
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberId().equals(id)){
				return tempVO.getNickName();
			}
		}
		return null;
	}
	public String searchIdByMemberNum(int memberNum){
		if(memberVOList == null)
			return null;
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberNum() == memberNum){
				return tempVO.getMemberId();
			}
		}
		return null;
	}
	public String searchNickNameByMemberNum(int memberNum){
		if(memberVOList == null)
			return null;
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getMemberNum() == memberNum){
				return tempVO.getNickName();
			}
		}
		return null;
	}
	public String searchIdByEmail(String email){
		if(memberVOList == null)
			return null;
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getEmail().equals(email)){
				return tempVO.getMemberId();
			}
		}
		return null;
	}
	public String searchPwdByIdAndEmail(String id, String email){
		if(memberVOList == null)
			return null;
		for(MemberVO tempVO : memberVOList){
			if(tempVO.getEmail().equals(email) && tempVO.getMemberId().equals(id)){
				return tempVO.getPassword();
			}
		}
		return null;
	}
	public boolean deleteMemberVO(MemberVO memberVO){
		if(memberVO == null || memberVOList == null||memberVOList.size() == 0){
			return false;
		}
		if(!memberVOList.remove(memberVO)){
			return false;
		}
		deletedMemberVOList.add(memberVO);
		return true;
	}
	public boolean deleteMemberVO(int memberNum){
		if(memberVOList == null || memberVOList.size() == 0){
			return false;
		}
		MemberVO temp = searchMemberVO(memberNum);
		if(!memberVOList.remove(temp)){
			return false;
		}
		deletedMemberVOList.add(temp);
		return true;
	}
	public boolean editMemberVO(MemberVO memberVO){
		if(memberVO == null||memberVOList == null||memberVOList.size() == 0){
			return false;
		}
		if(!(deleteMemberVO(memberVO))){
			return false;
		}
		memberVOList.add(memberVO);
		editedMemberVOList.add(memberVO);
		return true;
	}
	public boolean editMemberVO(int memberNum, String memberId, String nickName, String password, String email, byte grade, int activePoint, String joinDate, byte state){
		return editMemberVO(new MemberVO(memberNum, memberId, nickName, password, email, grade, activePoint, joinDate, state));
	}
	public boolean editPassword(int memberNum, String password){
		MemberVO temp = searchMemberVO(memberNum);
		if(temp == null)
			return false;
		temp.setPassword(password);
		editedMemberVOList.add(temp);
		return true;
	}
	public boolean editMemberVONickname(int memberNum, String nickname){
		if(memberVOList == null){
			return false;
		}
		MemberVO temp = searchMemberVO(memberNum);
		System.out.println(temp);
		if(temp == null)
			return false;
		temp.setNickName(nickname);
		editedMemberVOList.add(temp);
		MemberConDAO conDAO = MemberConDAO.getInstance();
		conDAO.editList(editedMemberVOList);
		return true;
	}
	public boolean editMemberVOGrade(int memberNum, byte grade){
		if(memberVOList == null)
			return false;
		MemberVO temp = searchMemberVO(memberNum);
		if(temp == null)
			return false;
		temp.setGrade(grade);
		return true;
	}
	public boolean editMemberVOActivePoint(int memberNum, int activePoint){
		if(memberVOList == null)
			return false;
		MemberVO temp = searchMemberVO(memberNum);
		if(temp == null)
			return false;
		temp.setActivePoint(activePoint);
		return true;
	}
	public boolean editMemberVOEmail(int memberNum, String email){
		if(memberVOList == null)
			return false;
		MemberVO temp = searchMemberVO(memberNum);
		if(temp == null)
			return false;
		temp.setEmail(email);
		return true;
	}
	public boolean editMemberVOState(int memberNum, byte state){
		if(memberVOList == null)
			return false;
		MemberVO temp = searchMemberVO(memberNum);
		if(temp == null)
			return false;
		temp.setState(state);
		return true;
	}
	public void readFromDB(){
		addedMemberVOList = new ArrayList<MemberVO>();
		deletedMemberVOList = new ArrayList<MemberVO>();
		editedMemberVOList = new ArrayList<MemberVO>();
		try{
			memberVOList = MemberConDAO.getInstance().searchAll();
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	public void writeToDB(){
		MemberConDAO.getInstance().addList(addedMemberVOList);
		MemberConDAO.getInstance().editList(editedMemberVOList);
		MemberConDAO.getInstance().deleteList(deletedMemberVOList);
		addedMemberVOList = new ArrayList<MemberVO>();
		editedMemberVOList = new ArrayList<MemberVO>();
		deletedMemberVOList = new ArrayList<MemberVO>();
	}
	
    public int searchMemberNumByNickName(String receiver) {
        if(memberVOList == null)
           return -1;
        for(MemberVO tempVO : memberVOList){
           if(tempVO.getNickName().equals(receiver)){
              return tempVO.getMemberNum();
           }
        }
        return -1;
        
     }
    public int searchStateById(String id){
        if(memberVOList == null){
           return 0;
        }
        for(MemberVO tempVO : memberVOList){
           if(tempVO.getMemberId().equals(id)){
              return tempVO.getState();
           }
        }
        return 0;
     }
    public int getMemberNum(){
        return (this.memberVOList.size()+1);
     }
}