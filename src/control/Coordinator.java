package control;

import org.apache.log4j.Logger;

import exception.PersonaDAOException;
import model.Logic;
import model.PersonaVO;
import view.MainWindow;
import view.RegistryWindow;
import view.SearchWindow;

public class Coordinator {

	private Logic logic;
	private MainWindow mainWindow;
	private RegistryWindow registryWindow;
	private SearchWindow searchWindow;

	public static final Logger LOG = Logger.getLogger(Coordinator.class);

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public RegistryWindow getRegistryWindow() {
		return registryWindow;
	}

	public void setRegistryWindow(RegistryWindow registryWindow) {
		this.registryWindow = registryWindow;
	}

	public SearchWindow getSearchWindow() {
		return searchWindow;
	}

	public void setSearchWindow(SearchWindow searchWindow) {
		this.searchWindow = searchWindow;
	}

	public void showRegistryWindow() {
		this.registryWindow.setVisible(true);
	}

	public void showSearchWindow() {
		this.searchWindow.setVisible(true);
	}

	public void registry(PersonaVO persona) throws PersonaDAOException {
		logic.checkRegistry(persona);
	}

	public void search() {
		
	}

	public void modify() {

	}

	public void delete() {

	}
}
