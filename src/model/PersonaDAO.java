package model;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

public class PersonaDAO {

	public static final Logger LOG = Logger.getLogger(PersonaDAO.class);

	public Set<PersonaVO> selectAll() {
		Set<PersonaVO> personas = null;
		personas = new TreeSet<>();
		return personas;
	}

	public Set<PersonaVO> selectByPK(int id) {
		Set<PersonaVO> personas = null;
		personas = new TreeSet<>();
		return personas;
	}

	public int deleteByPK(int id) {
		int result = 0;

		return result;
	}

	public int updateByPK(int id) {
		int result = 0;

		return result;
	}
}
