package ua.busstation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.busstation.core.BusStation;
import ua.busstation.core.bus.Bus;
import ua.busstation.core.reckoning.Reckoning;

/**
 * Servlet implementation class ReckoningServlet
 */
@WebServlet("/reckoning")
public class ReckoningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BusStation busStation;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.busStation = new BusStation();
		Bus bus = this.busStation.getSelectedRoute().getBusByNumber(request.getParameter("busNumber"));
		if (!bus.isFull()) {
			Reckoning reckoning = new Reckoning(bus, this.busStation.getSelectedRoute());
			
			request.setAttribute("reckoning", reckoning);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/reckoning.jsp");
			dispatcher.forward(request, response);

		} else {
			//TODO: to make error page 
		}
	}

}
