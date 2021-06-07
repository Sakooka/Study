package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VoteDAO;


@WebServlet("/AnimalIncrementControl")
public class AnimalIncrementControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String votedName = request.getParameter("name");
		//System.out.println(votedName);//確認用
		
		//VoteDAOクラスのCountVoteメソッドを使用し、該当のvotesに+1
		VoteDAO vd = new VoteDAO();
		vd.CountVote(votedName);
		
		//投票結果画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animalResultView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String addName = request.getParameter("name");
		//System.out.println(addName);//確認用
		if(addName == "") {
		}else {
			//VoteDAOクラスのAddAnimalメソッドを使用し、該当のAnimalを票数0で追加
			VoteDAO vd = new VoteDAO();
			vd.AddAnimal(addName);
		}
		//反映させTOP画面へ戻す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
