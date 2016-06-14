package ua.busstation.core;

import ua.busstation.core.route.Route;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class BusStation {

    private static Route selectedRoute;
    private static Date selectedDate;
    private static Map<Route, Date> routes = new HashMap<>();

    public boolean checkTime(Date selectedDate) {
        this.selectedDate = selectedDate;

        if (this.selectedDate.after(new java.util.Date()) || selectedRoute.getDepartureTime().after(new java.util.Date())) {
            return true;
        } else {
            return false;
        }
    }

    public void setDateForAllBuses() {
        for (int i = 0; i < selectedRoute.getBuses().size(); i++) {
            selectedRoute.getBuses().get(i).setDate(selectedDate);
        }
    }

    public void checkAndAddingRouteAndDateOrReturnExisting() {
        if (routes.size() == 0 || !routes.containsKey(selectedRoute)) {
            routes.put(selectedRoute, selectedDate);
        } else {
            for (Route r : routes.keySet()) {
                if (r.equals(selectedRoute)) {
                    selectedRoute = r;
                }

            }
        }
    }

    public Route getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public static Map<Route, Date> getRoutes() {
        return routes;
    }

    public static void setRoutes(Map<Route, Date> routes) {
        BusStation.routes = routes;
    }
}
