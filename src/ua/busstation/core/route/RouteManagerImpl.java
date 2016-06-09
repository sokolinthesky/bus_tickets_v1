package ua.busstation.core.route;

/*import ua.busstation.dao.convertors.RouteConvertor;
import ua.busstation.dao.models.RouteModel;
import ua.busstation.dao.repository.RouteRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteManagerImpl implements RouteManager {

	@Autowired
	private RouteRepository routeRepository;

	public void add(Route route) {
		routeRepository.save(RouteConvertor.convertToRouteModel(route));
		
	}

	public List<Route> allRouts() {
		List<Route> routes = new ArrayList<>();
		List<RouteModel> models = (List<RouteModel>) routeRepository.findAll();

		for (RouteModel m : models) {
			routes.add(RouteConvertor.convertToRoute(m));
		}

		return routes;
	}

	public void editRoute(Route route) {
		RouteModel model =  routeRepository.findOne(route.getId());

		model.setId(route.getId());
		model.setName(route.getName());

		routeRepository.save(model);

	}

	public void removeRoute(Route route) {
		routeRepository.delete(RouteConvertor.convertToRouteModel(route));
		
	}

	@Override
	public Route findByName(String name) {
		return RouteConvertor.convertToRoute(routeRepository.findByName(name));
	}

}*/
