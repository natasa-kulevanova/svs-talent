package webcalculator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class CalculatorHistoryServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("com.seavus.webcalculator.CalculatorHistoryServlet.doGet");
		HttpSession session = req.getSession(true);
		if (session.getAttribute("operations") == null) {
			System.out.println("History is empty");
		} else
			for (Operation o : (List<Operation>) req.getSession().getAttribute("operations"))
				resp.getWriter().write(o.toString());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("com.seavus.webcalculator.CalculatorHistoryServlet.doPost");
		HttpSession session = req.getSession(true);
		if (session.getAttribute("operations") == null) {
			System.out.println("History is empty");
		} else
			for (Operation o : (List<Operation>) req.getSession().getAttribute("operations")) 
				resp.getWriter().write(o.toString());
	}
}
