package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.BoardVO;

public class BoardListDAO {
	private static BoardListDAO instance;
	private List<BoardVO> boardVOList;
	private List<BoardVO> addedBoardVOList;
	private List<BoardVO> deletedBoardVOList;
	private List<BoardVO> editedBoardVOList;
	
	static{
		instance = new BoardListDAO();
	}
	
	public static BoardListDAO getInstance(){
		return instance;
	}
	
	public BoardListDAO() {
		boardVOList = new ArrayList<BoardVO>();
		addedBoardVOList = new ArrayList<BoardVO>();
		deletedBoardVOList = new ArrayList<BoardVO>();
		editedBoardVOList = new ArrayList<BoardVO>();
	}
	public BoardListDAO(List<BoardVO> boardVOList, List<BoardVO> addedBoardVOList, List<BoardVO> deletedBoardVOList,
			List<BoardVO> editedBoardVOList) {
		super();
		this.boardVOList = boardVOList;
		this.addedBoardVOList = addedBoardVOList;
		this.deletedBoardVOList = deletedBoardVOList;
		this.editedBoardVOList = editedBoardVOList;
	}
	
	public void addBoardVO(BoardVO boardVO){
		if(boardVO != null){
		boardVOList.add(boardVO);
		addedBoardVOList.add(boardVO);
		}
	}
	
	public void addBoardVO(int boardNum, String boardName, 
			String description, byte writePermission,
			byte commentWritePermission, byte openRange){
		BoardVO boardVO = new BoardVO(boardNum, boardName, description,
				writePermission, commentWritePermission, openRange);
		boardVOList.add(boardVO);
		addedBoardVOList.add(boardVO);
	}
	public BoardVO searchBoardVO(List<BoardVO> list, int boardNum){
	      if(list == null){
	         return null;
	      }
	      for(BoardVO temp : list){
	         if(temp.getBoardNum() == boardNum){
	            return temp;
	         }
	      }
	      return null;
	   }
	
	public BoardVO searchBoardVO(int boardNum){
		if(boardVOList == null){
			return null;
		}
		
		for(BoardVO temp : boardVOList){
			if(temp.getBoardNum() == boardNum)
				return temp;
		}
		return null;
	}
	
	public BoardVO searchBoardVO(String boardName){
		if(boardVOList == null){
			return null;
		}
		
		for(BoardVO temp : boardVOList){
			if(temp.getBoardName().equals(boardName))
				return temp;
		}
		return null;
	}
	
	public boolean deleteBoardVO(int boardNum){
		if(boardVOList == null){
			return false;
		}
		
		BoardVO boardVO = searchBoardVO(boardNum);
		if(!boardVOList.remove(boardVO)){
			return false;
		}
		deletedBoardVOList.add(boardVO);
		return true;
	}
	
	public boolean deleteBoardVO(BoardVO boardVO){
		if(boardVOList == null){
			return false;
		}
		
		BoardVO temp = searchBoardVO(boardVO.getBoardNum());
		if(!boardVOList.remove(temp)){
			return false;
		}
		deletedBoardVOList.add(temp);
		return true;
	}
	
	public boolean editBoardName(int boardNum, String boardName){
		if(boardVOList == null){
			return false;
		}
		
		if(searchBoardVO(boardNum)==null)
			return false;
		
		searchBoardVO(boardNum).setBoardName(boardName);
		this.editedBoardVOList.add(searchBoardVO(boardNum));
		return true;
	}
	
	public boolean editDescription(int boardNum, String description){
		if(boardVOList == null){
			return false;
		}
		
		if(searchBoardVO(boardNum)==null)
			return false;
		
		searchBoardVO(boardNum).setDescription(description);
		this.editedBoardVOList.add(searchBoardVO(boardNum));
		return true;
	}
	
	public boolean editWritePermission(int boardNum, byte writePermission){
		if(boardVOList == null){
			return false;
		}
		
		if(searchBoardVO(boardNum)==null)
			return false;
		
		searchBoardVO(boardNum).setWritePermission(writePermission);
		this.editedBoardVOList.add(searchBoardVO(boardNum));
		return true;
	}
	
	public boolean editCommentWritePermission(int boardNum,
			byte commentWritePermission){
		if(boardVOList == null){
			return false;
		}
		
		if(searchBoardVO(boardNum) == null)
			return false;
		
		searchBoardVO(boardNum).setCommentWritePermission(commentWritePermission);
		this.editedBoardVOList.add(searchBoardVO(boardNum));
		return true;
	}
	
	public boolean editOpenRange(int boardNum, byte openRange){
		if(boardVOList == null)
			return false;
		if(searchBoardVO(boardNum)==null)
			return false;
		searchBoardVO(boardNum).setOpenRange(openRange);
		this.editedBoardVOList.add(searchBoardVO(boardNum));
		return true;
	}
	
	public void init(){
		try{
		this.boardVOList = BoardConDAO.getInstance().searchAll();
		} catch(DAOException e){
			e.getMessage();
		}
	}
	
	public void writeToDB(){
		
	}
	public List<BoardVO> getBoardVOList() {
		return boardVOList;
	}
	public void setBoardVOList(List<BoardVO> boardVOList) {
		this.boardVOList = boardVOList;
	}
	public List<BoardVO> getAddedBoardVOList() {
		return addedBoardVOList;
	}
	public void setAddedBoardVOList(List<BoardVO> addedBoardVOList) {
		this.addedBoardVOList = addedBoardVOList;
	}
	public List<BoardVO> getDeletedBoardVOList() {
		return deletedBoardVOList;
	}
	public void setDeletedBoardVOList(List<BoardVO> deletedBoardVOList) {
		this.deletedBoardVOList = deletedBoardVOList;
	}
	public List<BoardVO> getEditedBoardVOList() {
		return editedBoardVOList;
	}
	public void setEditedBoardVOList(List<BoardVO> editedBoardVOList) {
		this.editedBoardVOList = editedBoardVOList;
	} 
	@Override
	public String toString() {
		return "BoardListDAO [boardVOList=" + boardVOList + ", addedBoardVOList=" + addedBoardVOList
				+ ", deletedBoardVOList=" + deletedBoardVOList + ", editedBoardVOList=" + editedBoardVOList + "]";
	}
	
	public static void main(String args[]){
		BoardListDAO dao = BoardListDAO.getInstance();
		
		dao.init();
	}
}


