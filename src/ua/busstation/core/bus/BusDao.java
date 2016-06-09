package ua.busstation.core.bus;

import java.util.List;

public interface BusDao {
	List<Bus> getBusesByRouteId(String id);

}
