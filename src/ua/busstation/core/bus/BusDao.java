package ua.busstation.core.bus;

import java.util.List;

/**
 * Bus dao interface contains dao methods.
 * 
 * @author O.Soklakov
 *
 */
public interface BusDao {

	/**
	 * Get list of buses by route id.
	 * 
	 * @param id
	 *            specified id.
	 * @return list of buses.
	 */
	List<Bus> getBusesByRouteId(String id);

}
