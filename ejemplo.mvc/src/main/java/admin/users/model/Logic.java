package admin.users.model;

import org.apache.log4j.Logger;

import admin.users.control.Coordinator;
import admin.users.exception.PersonaDAOException;

public class Logic {

	public static final Logger LOG = Logger.getLogger(Logic.class);

	private Coordinator myCoordinator;

	public boolean checkRegistry(PersonaVO persona) throws PersonaDAOException {
		boolean ok = false;
		PersonaDAO personaDao;
		// SE VALIDA QUE SOLO SE INGRESEN ID DE 3 D�GITOS
		if (persona.getId() > 99) {
			personaDao = new PersonaDAO();
			personaDao.registry(persona);
			ok = true;
		}

		return ok;
	}
	
	

}
