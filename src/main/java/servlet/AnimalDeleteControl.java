package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VoteDAO;

@WebServlet("/AnimalDeleteControl")
public class AnimalDeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//削除用ページへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/animalDelete.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String deleteName = request.getParameter("name");
		//System.out.println(deleteName);//確認用
		
		//VoteDAOクラスのDeleteAnimalメソッドを使用
		VoteDAO vd = new VoteDAO();
		vd.DeleteAnimal(deleteName);
		
		//TOP画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
