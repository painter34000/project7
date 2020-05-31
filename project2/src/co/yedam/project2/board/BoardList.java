package co.yedam.project2.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class BoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		 List<BoardVO> list = dao.getSelectList(); 
		request.setAttribute("Board", list); //jsp에쓰는거 이름 , 돌려주는 객체
		
		return "board/boardList.jsp";
	}

}
