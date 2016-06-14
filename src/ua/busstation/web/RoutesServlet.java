package ua.busstation.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.busstation.core.BusStation;
import ua.busstation.core.route.Route;
import ua.busstation.core.route.RouteManager;
import ua.busstation.core.route.RouteManagerImpl;

@WebServlet("/routes")
public class RoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RouteManager manager = new RouteManagerImpl();
	private BusStation busStation;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.busStation = new BusStation();
		List<Route> routes = this.manager.getAllRouts();
		request.setAttribute("routes", routes);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.busStation.setSelectedRoute(this.manager.findByName(request.getParameter("routeName")));
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			Date selectedDate = new Date(date.getTime());
			
			if (this.busStation.checkTime(selectedDate)) {
				this.busStation.setDateForAllBuses();
				this.busStation.checkAndAddingRouteAndDateOrReturnExisting();
				
				request.setAttribute("buses", this.busStation.getSelectedRoute().getBuses());
				request.setAttribute("date", this.busStation.getSelectedDate());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/buses.jsp");
				dispatcher.forward(request, response);

			} else {
				System.out.println("ERROR");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//doGet(request, response);
	}

}
