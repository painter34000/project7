package co.yedam.project2.worker;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class WorkerList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WorkerDAO dao = new WorkerDAO();
		
		List<WorkerVO> list = dao.getWorkerList();
		request.setAttribute("workerList", list);
		
		return "worker/workerList.jsp";
	}

}
