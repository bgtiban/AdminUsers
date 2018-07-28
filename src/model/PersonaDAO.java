package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import exception.PersonaDAOException;

public class PersonaDAO {

	public static final Logger LOG = Logger.getLogger(PersonaDAO.class);
	private static final String CAMPO_ID = "id";
	private static final String CAMPO_NOMBRE = "nombre";
	private static final String CAMPO_TELEFONO = "telefono";
	private static final String CAMPO_PROFESION = "profesion";
	private static final String CAMPO_EDAD = "edad";

	public Set<PersonaVO> select(int id) throws PersonaDAOException {

		Set<PersonaVO> personas = null;
		personas = new TreeSet<>();
		String query;
		if (id > 0) {
			query = "SELECT * FROM PERSONA WHERE id = '" + id + "';";
		} else {
			query = "SELECT * FROM PERSONA;";
			try (ResultSet cursor = (ResultSet) execute(query, Type.EXECUTE_QUERY)) {
				while (cursor.next()) {
					PersonaVO p = new PersonaVO();
					p.setId(cursor.getInt(CAMPO_ID));
					p.setEdad(cursor.getInt(CAMPO_EDAD));
					p.setNombre(cursor.getString(CAMPO_NOMBRE));
					p.setProfesion(cursor.getString(CAMPO_PROFESION));
					p.setTelefono(cursor.getString(CAMPO_TELEFONO));

					personas.add(p);
				}
			} catch (SQLException e) {
				throw new PersonaDAOException(e.getMessage());
			}
		}
		return personas;
	}

	private Object execute(String query, Type type) throws PersonaDAOException {
		Object value = null;
		ConnectionBD conn = ConnectionBD.getInstance();
		Statement terminal = conn.getTerminal();
		try {
			if (type == Type.EXECUTE_QUERY) {

				value = terminal.executeQuery(query);

			} else if (type == Type.EXECUTE_UPDATE) {
				value = terminal.executeUpdate(query);

			} else {
				throw new PersonaDAOException(type.name() + " No se contempla");
			}
		} catch (SQLException e) {
			throw new PersonaDAOException(e);
		}
		return value;
	}

	public int deleteByPK(int id) throws PersonaDAOException {
		int result = 0;
		String query = "DELETE FROM PERSONA WHERE id = '" + id + "';";

		try {
			result = (int) execute(query, Type.EXECUTE_UPDATE);
		} catch (PersonaDAOException e) {
			throw new PersonaDAOException(e);
		}
		return result;
	}

	public int updateByPK(int actualID, PersonaVO newPersona) throws PersonaDAOException {

		int result = 0;
		StringBuilder query = new StringBuilder();
		query.append("UPDATE PERSONA SET id = " + newPersona.getId());
		query.append(", SET nombre = " + newPersona.getNombre());
		query.append(", profesion = " + newPersona.getProfesion());
		query.append(", telefono = " + newPersona.getTelefono());
		query.append(", edad = " + newPersona.getEdad());
		query.append(", edad = " + newPersona.getEdad());
		query.append("WHERE id = '" + actualID + "';");

		execute(query.toString(), Type.EXECUTE_UPDATE);
		return result;
	}

	public int registry(PersonaVO persona) throws PersonaDAOException {

		int result = 0;
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO PERSONA VALUES (");
		query.append(persona.getId());
		query.append("," + persona.getNombre());
		query.append("," + persona.getEdad());
		query.append("," + persona.getProfesion());
		query.append("," + persona.getTelefono());
		query.append(");");
		execute(query.toString(), Type.EXECUTE_UPDATE);

		return result;

	}
}
