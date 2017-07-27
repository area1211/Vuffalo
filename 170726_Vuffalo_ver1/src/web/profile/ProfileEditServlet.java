package web.profile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.ProfileEditManager;
import manager.ViewProfileManager;
import vo.ProfileViewVO;

/**
 * Servlet implementation class ProfileEditServlet
 */
public class ProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		if(request.getParameter("flag")==null||request.getParameter("flag").equals("0")){
		if(session.getAttribute("codeNum")!=null){
		int num = (Integer)(session.getAttribute("codeNum"));
		ProfileEditManager manager = new ProfileEditManager();
		List<String> list = manager.viewProfile(num);
		
		request.setAttribute("pnum", list.get(0));
		request.setAttribute("pname", list.get(1));
		request.setAttribute("pmail", list.get(2));
		request.setAttribute("page", list.get(3));
		request.setAttribute("pmTongue", list.get(4));
		request.setAttribute("pinterest", list.get(5));
		request.setAttribute("pgender", list.get(6));
		request.setAttribute("pnationality", list.get(7));
		request.setAttribute("pselfIntro", list.get(8));
		request.setAttribute("popenRange", list.get(9));
		request.setAttribute("pfileFlag", list.get(10));
		request.setAttribute("plastVisitDate", list.get(11));
		request.setAttribute("plastProfileUpdate", list.get(12));
		request.setAttribute("pfileURL", list.get(13));
		
		List<String> languageList = new ArrayList<String>();
		languageList.add("한국어");
		languageList.add("영어");
		languageList.add("일본어");
		List<String> genderList = new ArrayList<String>();
		genderList.add("남성");
		genderList.add("여성");
		request.setAttribute("genderList", genderList);
		List<String> countryList = new ArrayList<String>();
		countryList.add("대한민국");
		countryList.add("미국");
		countryList.add("중국");
		request.setAttribute("countryList", countryList);
		//request.setAttribute("introduce", "heelo");
		
		List<String> openLevelList = new ArrayList<String>();
		openLevelList.add("전체공개");
		openLevelList.add("스탭이상");
		openLevelList.add("관리자");
		request.setAttribute("openLevelList",  openLevelList);
		request.setAttribute("languageList", languageList);
//		PrintWriter out = response.getWriter();
//		System.out.println(list);
//		out.println("hi나니");
		RequestDispatcher rq = request.getRequestDispatcher("profile/edit_profile.jsp");
		rq.forward(request, response);
		}
		
		else{
			RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
			rq.forward(request, response);
		}
		}
		else if(request.getParameter("flag").equals("1")){
			
			System.out.println((int)(session.getAttribute("codeNum")));
			System.out.println((String)(session.getAttribute("name")));
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("age"));
			System.out.println(request.getParameter("motherTongue"));
			System.out.println(request.getParameter("hopeLanguage"));
			System.out.println(request.getParameter("mail"));
			System.out.println(request.getParameter("gender"));
			System.out.println(request.getParameter("country"));
			System.out.println(request.getParameter("introduce"));
			System.out.println(request.getParameter("profileOpenType"));
			System.out.println(request.getParameter("addedFile"));
			
			String num = Integer.toString( (int)(session.getAttribute("codeNum")) );			
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String motherTongue = request.getParameter("motherTongue");
			String hopeLanguage = request.getParameter("hopeLanguage");
			String mail = request.getParameter("mail");
			String gender = request.getParameter("gender");
			String country = request.getParameter("country");
			String introduce = request.getParameter("introduce");
			String profileOpenType = request.getParameter("profileOpenType");
			String addedFile = request.getParameter("addedFile");
			String preName = (String)(session.getAttribute("name"));
			String fileFlag = null;
			if(addedFile.equals("")){
				fileFlag = "0";
			}
			else
				fileFlag = "1";
			Calendar calendar = Calendar.getInstance();
	        java.util.Date date = calendar.getTime();
	        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			/*
	        this.memberNum = memberNum;
			this.gender = gender;
			this.age = age;
			this.country = country;
			this.motherTongue = motherTongue;
			this.interestLanguage = interestLanguage;
			this.introduce = introduce;
			this.fileFlag = fileFlag;
			this.openRange = openRange;
			this.fileUrl = fileUrl;
			this.hit = hit;
			list.add(Integer.toString(profileViewVO.getNum()));
			list.add(profileViewVO.getNickname());
			list.add(profileViewVO.getEmail());
			list.add(Integer.toString(profileViewVO.getAge()));
			list.add(profileViewVO.getmTongue());
			list.add(profileViewVO.getInterest());
			list.add(Integer.toString(profileViewVO.getGender()));
			list.add(profileViewVO.getNationality());
			list.add(profileViewVO.getSelfIntro());
			list.add(Integer.toString(profileViewVO.getOpenRange()));
			list.add(Integer.toString(profileViewVO.getFileFlag()));
			list.add(profileViewVO.getLastVisitDate());
			list.add(profileViewVO.getLastProfileUpdate());
			list.add(profileViewVO.getFileURL());*/
			ProfileEditManager manager = new ProfileEditManager();
			if(manager.editProfile(new String[]{num,name, mail,age, motherTongue, hopeLanguage,
					 gender, country, introduce, profileOpenType, fileFlag, today, today, addedFile, preName
			})){
				ViewProfileManager manager2 = new ViewProfileManager();
				ProfileViewVO profileViewVO
				= manager2.viewProfile((Integer)(session.getAttribute("codeNum")));
				request.setAttribute("bean", profileViewVO);

				session.setAttribute("name", name);
				
				RequestDispatcher rq = request.getRequestDispatcher("profile/view_my_profile.jsp");
				rq.forward(request, response);
				}
				else{
					response.getWriter().println("수정실패!");
				}
			}
			/*
			ProfileViewVO bean = new ProfileViewVO()
			session.setAttribute("name", name);
			request.setAttribute("pnum", num);
			request.setAttribute("pname", name);
			request.setAttribute("pmail", mail);
			request.setAttribute("page", age);
			request.setAttribute("pmotherTongue", motherTongue);
			request.setAttribute("phopeLanguage", hopeLanguage);
			request.setAttribute("pgender", gender);
			request.setAttribute("pnationality", country);
			request.setAttribute("pselfIntro", introduce);
			request.setAttribute("popenRange", profileOpenType);
			*/
			/*
			int num = (Integer)(session.getAttribute("codeNum"));
			String nickname = (String)(session.getAttribute("name"));
			ProfileEditManager manager = new ProfileEditManager();
			List<String> list = manager.viewProfile(num);
			String[] stringArray = new String[]{list.get(0),list.get(1),list.get(2),
				list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),
				list.get(8),list.get(9),list.get(10),list.get(11),list.get(12),
				list.get(13), nickname};
			
			if(manager.editProfile(stringArray)){
			ViewProfileManager manager2 = new ViewProfileManager();
			ProfileViewVO profileViewVO
			= manager2.viewProfile((Integer)(session.getAttribute("codeNum")));
			
			//response.getWriter().println(request.getParameter("name"));
			
			request.setAttribute("bean", profileViewVO);
			
			RequestDispatcher rq = request.getRequestDispatcher("profile/view_my_profile.jsp");
			rq.forward(request, response);
			}
			else{
				response.getWriter().println("수정실패!");
			}*/
			//request.setAttribute("pfileFlag", added);
			//request.setAttribute("plastVisitDate", list.get(11));
			//request.setAttribute("plastProfileUpdate", list.get(12));
			//request.setAttribute("pfileURL", list.get(13));
		}
	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}