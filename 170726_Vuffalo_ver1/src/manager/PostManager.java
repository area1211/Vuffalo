package manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import dao.PostConDAO;
import dao.PostListDAO;
import dao.PostViewListDAO;
import util.KeyDecoder;
import vo.PostVO;
import vo.PostViewVO;

public class PostManager {
	public void writePost(int boardNum, String title, String text,
			byte imgFlag,byte deleteFlag, int codeNum, String nickName, String fileUrl){
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String ran = (new SimpleDateFormat("sms").format(date));
        System.out.println(ran);
		
		int postNum = Integer.parseInt(ran);
		postNum = postNum +7;
		/*int postNum = PostListDAO.getInstance().getPostVOList().size() + 1000;*/

        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        //vo생성시 필요한 값들 생성
        int memNum = KeyDecoder.decodeKey(codeNum);
		PostVO vo = new PostVO(postNum,boardNum,title,text,imgFlag,today,(byte)0,memNum,nickName,fileUrl,0);
		PostListDAO.getInstance().addPostVO(vo);
		
	}
	public List<PostViewVO> getPostViewVOList(){
		return PostViewListDAO.getInstacne().searchPostViewVOAll();
	}
	
	public PostVO searchPost(int postNum, int boardNum){
		return PostListDAO.getInstance().searchPostVO(postNum, boardNum);
	}
	
	public boolean deletePost(int postNum,int boardNum){
		return PostListDAO.getInstance().deletePostVO(postNum, boardNum);
	}
	public boolean editPost(int postNum, int boardNum, String title, String text,String fileUrl){
		PostVO vo = PostListDAO.getInstance().searchPostVO(postNum, boardNum);
		vo.setTitle(title);
		vo.setText(text);
		vo.setFileUrl(fileUrl);
		return PostListDAO.getInstance().editPostVO(vo);
		/*List<PostVO> resList = new ArrayList<PostVO>();
		resList.add(vo);
		PostConDAO.getInstacne().editList(resList);*/
	}
	public List<PostViewVO> getDeletePostViewList(){
		return PostViewListDAO.getInstacne().searchPostViewVODeleteAll();
	}
	public boolean editPostDeleteFlag(int postNum,int boardNum,byte flag){
		return PostConDAO.getInstacne().editdeleteFlag(postNum, boardNum, (byte) flag);
	}
}