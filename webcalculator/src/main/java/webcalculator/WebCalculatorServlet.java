package webcalculator;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class WebCalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out
				.println("com.seavus.webcalculator.WebCalculatorServlet.doGet");
		calculate(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out
				.println("com.seavus.webcalculator.WebCalculatorServlet.doPost");
		calculate(req, resp);
	}

	private void calculate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("operations") == null) {
			List<Operation> ops = new ArrayList<Operation>();
			session.setAttribute("operations", ops);
		}
		
		final String var1 = req.getParameter("var1");
		final String var2 = req.getParameter("var2");
		final String op = req.getParameter("operation");
		Operation operation = new Operation();
		operation.var1 = Integer.valueOf(var1);
		operation.var2 = Integer.valueOf(var2);
		operation.operation = op;
		if (op.equals("ADD")) {
			operation.result = Integer.valueOf(var1) + Integer.valueOf(var2);

		} else {
			operation.result = Integer.valueOf(var1) - Integer.valueOf(var2);
		}

		((List<Operation>) session.getAttribute("operations")).add(operation);
		resp.setContentType("text/html");
		resp.getWriter().println("Result is: " + operation.toString());
	}
}
