package control;

import model.Logic;
import view.MainWindow;
import view.RegistryWindow;
import view.SearchWindow;

public class Main {

	public Logic logic;
	public MainWindow mainWindow;
	public SearchWindow searchWindow;
	public RegistryWindow registryWindow;
	public Coordinator coordinator;

	public void start() {
		logic = new Logic();
		mainWindow = new MainWindow();
		searchWindow = new SearchWindow();
		registryWindow = new RegistryWindow();
		coordinator = new Coordinator();

		mainWindow.setCoordinator(coordinator);
		searchWindow.setCoordinator(coordinator);
		registryWindow.setCoordinator(coordinator);
		
		coordinator.setMainWindow(mainWindow);
		coordinator.setRegistryWindow(registryWindow);
		coordinator.setSearchWindow(searchWindow);
		coordinator.setLogic(logic);
		
		mainWindow.setVisible(true);
	}

	public static void main(String[] ags) {
		Main m = new Main();
		m.start();
	}
}
