package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.PostVO;

public class PostListDAO {
   private static PostListDAO instance;
   
   private List<PostVO> postVOList;
   private List<PostVO> addedPostVOList;
   private List<PostVO> deletedPostVOList;
   private List<PostVO> editedPostVOList;
   
   static{
      instance = new PostListDAO();
   }
   private PostListDAO() {
      postVOList = new ArrayList<PostVO>();
      init();
      addedPostVOList = new ArrayList<PostVO>();
      deletedPostVOList = new ArrayList<PostVO>();
      editedPostVOList = new ArrayList<PostVO>();      
   }
   
   public static PostListDAO getInstance(){
      return instance;
   }
   
   private PostListDAO(List<PostVO> postVOList, List<PostVO> addedPostVOList, List<PostVO> deletedPostVOList,
         List<PostVO> editedPostVOList) {
      super();
      this.postVOList = postVOList;
      this.addedPostVOList = addedPostVOList;
      this.deletedPostVOList = deletedPostVOList;
      this.editedPostVOList = editedPostVOList;
   }
   
   public List<PostVO> getPostVOList() {
      return postVOList;
   }
   public void setPostVOList(List<PostVO> postVOList) {
      this.postVOList = postVOList;
   }
   public List<PostVO> getAddedPostVOList() {
      return addedPostVOList;
   }
   public void setAddedPostVOList(List<PostVO> addedPostVOList) {
      this.addedPostVOList = addedPostVOList;
   }
   public List<PostVO> getDeletedPostVOList() {
      return deletedPostVOList;
   }
   public void setDeletedPostVOList(List<PostVO> deletedPostVOList) {
      this.deletedPostVOList = deletedPostVOList;
   }
   public List<PostVO> getEditedPostVOList() {
      return editedPostVOList;
   }
   public void setEditedPostVOList(List<PostVO> editedPostVOList) {
      this.editedPostVOList = editedPostVOList;
   }
   public void addPostVO(int postNum, int boardNum, String title, String text, byte imgFlag, String writeDate, byte deleteFlag, int memberNum, String nickName, String fileUrl, int hit){
      PostVO newVO = new PostVO(postNum,boardNum,title,text,imgFlag,writeDate,deleteFlag, memberNum,nickName,fileUrl,hit);
      addPostVO(newVO);
   }
   public void addPostVO(PostVO postVO){
      if(postVO == null){
         return;
      }
      postVOList.add(postVO);
      addedPostVOList.add(postVO);
      PostViewListDAO.getInstacne().addPostViewVO(postVO);
      PostListDAO.getInstance().writeToDB();
      //일단 한번쓰면 한번씩 쓴다.
   }
   public boolean deletePostVO(PostVO postVO){
      if(postVO == null){
         return false;
      }
      if(postVOList == null){
         return false;
      }
      if(!(postVOList.remove(postVO))){
         return false;
      }
      deletedPostVOList.add(postVO);
      //뷰에서도 삭제
      PostListDAO.getInstance().writeToDB();
      return true;
   }
   public boolean deletePostVO(int postNum,int boardNum){
      PostVO temp = searchPostVO(postNum, boardNum);
      if(temp == null){
         return false;
      }
      if(postVOList == null){
         return false;
      }
      if(!(postVOList.remove(temp))){
         return false;
      }
      deletedPostVOList.add(temp);
     System.out.println(PostViewListDAO.getInstacne().deletePostViewVO(temp));
      PostListDAO.getInstance().writeToDB();
      return true;
   }
   public PostVO searchPostVO(int postNum, int boardNum){
      for(PostVO temp : postVOList){
         if(temp.getBoardNum() == boardNum && temp.getPostNum() == postNum){
            return temp;
         }
      }
      return null;
   }
   public PostVO searchPostVO(List<PostVO> list, int postNum, int boardNum){
      if(list == null){
         return null;
      }
      for(PostVO temp : list){
         if(temp.getBoardNum() == boardNum && temp.getPostNum() == postNum){
            return temp;
         }
      }
      return null;
   }
   public List<PostVO> searchPostVOByBoardNumAndTitle(int boardNum, String title, byte deleteFlag){
      if(postVOList == null){
         return null;
      }
      List<PostVO> returnList = new ArrayList<PostVO>();
      for(PostVO temp : postVOList){
         if(temp.getBoardNum() == boardNum && temp.getTitle().contains(title) && temp.getDeleteFlag() == deleteFlag ){
            returnList.add(temp);
         }
      }
      if(returnList.size() == 0){
         return null;
      }
      return returnList;
   }
   public List<PostVO> searchPostVOByBoardNumAndText(int boardNum, String text, byte deleteFlag){
      if(postVOList == null){
         return null;
      }
      List<PostVO> returnList = new ArrayList<PostVO>();
      for(PostVO temp : postVOList){
         if(temp.getBoardNum() == boardNum && temp.getText().contains(text) && temp.getDeleteFlag() == deleteFlag){
            returnList.add(temp);
         }
      }
      if(returnList.size() == 0){
         return null;
      }
      return returnList;
   }
   public List<PostVO> searchPostVOByBoardNumAndNickName(int boardNum, String nickName, byte deleteFlag){
      if(postVOList == null){
         return null;
      }
      List<PostVO> returnList = new ArrayList<PostVO>();
      for(PostVO temp : postVOList){
         if(temp.getBoardNum() == boardNum && temp.getNickName().contains(nickName) && temp.getDeleteFlag() == deleteFlag){
            returnList.add(temp);
         }
      }
      if(returnList.size() == 0){
         return null;
      }
      return returnList;
   }
   public List<PostVO> searchPostVOByBordNumAndDeleteFlag(int boardNum, byte deleteFlag){
      if(postVOList == null){
         return null;
      }
      List<PostVO> returnList = new ArrayList<PostVO>();
      for(PostVO temp : postVOList){
         if(temp.getBoardNum() == boardNum && temp.getDeleteFlag() == deleteFlag){
            returnList.add(temp);
         }
      }
      if(returnList.size() == 0){
         return null;
      }
      return returnList;
   }
   public boolean editPostVO(PostVO postVO){
      if(postVOList==null){
    	  System.out.println("널이다.");
         return false;
      }
      if(postVO == null){
    	  System.out.println("브이오널");
         return false;
      }
      if(!(postVOList.remove(postVO))){
    	  System.out.println("맞는애가없다..");
         return false;
      }
      System.out.println(postVOList.add(postVO));
      System.out.println(editedPostVOList.add(postVO));
      PostViewListDAO.getInstacne().editPostViewVO(postVO);
      writeToDB();
      return true;
   }
   public boolean editPostVO(int postNum, int boardNum, String title, String text, byte imgFlag, String writeDate, byte deleteFlag, int memberNum, String nickName, String fileUrl,int hit){
      return editPostVO(new PostVO(postNum, boardNum, title, text, imgFlag, writeDate, deleteFlag, memberNum, nickName, fileUrl,hit));
   }
   public boolean editPostVOTitle(int postNum, int boardNum, String title){
      if(postVOList == null){
         return false;
      }
      if(title == null || title.length() == 0){
         return false;
      }
      PostVO temp = searchPostVO(boardNum, postNum);
      if(temp == null){
         return false;
      }
      temp.setTitle(title);
      editedPostVOList.add(temp);
      return true;
   }
   public boolean editPostVOText(int postNum, int boardNum, String text){
      if(postVOList == null){
         return false;
      }
      if(text == null || text.length() == 0){
         return false;
      }
      PostVO temp = searchPostVO(boardNum, postNum);
      if(temp == null){
         return false;
      }
      temp.setText(text);
      editedPostVOList.add(temp);
      return true;
   }
   public boolean editPostVODeleteFlag(int postNum, int boardNum, byte deleteFlag){
      if(postVOList == null){
         return false;
      }
      PostVO temp = searchPostVO(boardNum, postNum);
      if(temp == null){
         return false;
      }
      temp.setDeleteFlag(deleteFlag);
      editedPostVOList.add(temp);
      return true;
   }
   public boolean editPostVOImgFlag(int postNum, int boardNum, byte imgFlag){
      if(postVOList == null){
         return false;
      }
      PostVO temp = searchPostVO(boardNum, postNum);
      if(temp == null){
         return false;
      }
      temp.setImgFlag(imgFlag);
      editedPostVOList.add(temp);
      return true;
   }
   public void init(){
	   try {
			postVOList = PostConDAO.getInstacne().searchAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return;
   }
   public void writeToDB(){
	   PostConDAO.getInstacne().addList(addedPostVOList);
	   addedPostVOList.removeAll(addedPostVOList);
	   PostConDAO.getInstacne().editList(editedPostVOList);
	   editedPostVOList.removeAll(editedPostVOList);
	   PostConDAO.getInstacne().deleteList(deletedPostVOList);
	   deletedPostVOList.removeAll(deletedPostVOList);
      return;
   }
   
}