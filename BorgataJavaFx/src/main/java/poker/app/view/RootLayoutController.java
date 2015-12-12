package poker.app.view;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import domain.GameRuleDomainModel;
import enums.eGame;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import poker.app.MainApp;
import pokerBase.Rule;

import logic.GameRuleBLL;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController implements Initializable {

	// Reference to the main application
	private MainApp mainApp;

	@FXML
	private MenuBar mb;

	@FXML
	private Menu mnuGame;

	@FXML
	final private ToggleGroup tglGames = new ToggleGroup();
	
	

	public String getRuleName()
	{	
		String strRuleName = null;
		for (Menu m: mb.getMenus())
		{
			if (m.getText().matches("Main Menu"))
			{
				for (MenuItem mi: m.getItems())
				{
					if (mi.getClass().equals(RadioMenuItem.class))
					{
						RadioMenuItem rmi = (RadioMenuItem)mi;
						if (rmi.isSelected() == true)
						{
							strRuleName = rmi.getText();
							System.out.println(strRuleName + " is selected");
							break;
						}
					}
				}
			}
		}
		System.out.println(strRuleName);
		return strRuleName;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {


		//ToggleGroup tg = new ToggleGroup();
		String k = "";
		
		for (GameRuleDomainModel gr : GameRuleBLL.getRules()) {
			
			RadioMenuItem mi = new RadioMenuItem();
			String strRuleName = gr.getRULENAME();
			mi.setToggleGroup(tglGames);
			mi.setText(strRuleName);
			//System.out.println(mi.getText() + " is a game name");
			
			if (gr.getDEFAULTGAME() == 1)
			{
				mi.setSelected(true);
				k = mi.getText();
				System.out.println(k + " is default");
			}
			mnuGame.getItems().add(0,mi);
		}
        
		mb.getMenus().set(0, mnuGame);	//.add(0, mnuGame);
		
		for (Menu m: mb.getMenus())
		{	
			//System.out.println(m.getText() + " is a menu name");
			if (m.getText().matches("Main Menu"))
			{
				for (MenuItem mi: m.getItems())
				{
					if (mi.getClass().equals(RadioMenuItem.class))
					{
						RadioMenuItem rmi = (RadioMenuItem)mi;
						//System.out.println(rmi.getText() + " was checked");
						
						if (rmi.getText().equals(k))
						{
							//System.out.println(rmi.getText() + " is default now");
							rmi.setSelected(true);			
							break;
						}
					}
				}
			}
		}
		tglGames.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov,
		          Toggle old_toggle, Toggle new_toggle) {
		        if (tglGames.getSelectedToggle() != null) {
		          System.out.println(tglGames.getSelectedToggle().getUserData().toString());
		        }
		      }
		    });


			
		
		// mb.getMenus().add(m);
		// mainApp.rootController.getc
		// root.getChildren().add(menuBar);

		/*
		 * CheckMenuItem item1 = new CheckMenuItem("5 card stud");
		 * item1.selectedProperty().addListener(new ChangeListener(){
		 * 
		 * @Override public void changed(ObservableValue arg0, Object arg1,
		 * Object arg2) { mainApp.setiGameType(1); } });
		 * 
		 * 
		 * mnuGame.getItems().add(item1);
		 * 
		 * 
		 * 
		 * CheckMenuItem item2 = new CheckMenuItem("5 card draw");
		 * item2.selectedProperty().addListener(new ChangeListener(){
		 * 
		 * @Override public void changed(ObservableValue arg0, Object arg1,
		 * Object arg2) { mainApp.setiGameType(2); } });
		 * 
		 * 
		 * mnuGame.getItems().add(item2);
		 */

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
//		Omaha.setToggleGroup(tglGames);
//		Texas.setToggleGroup(tglGames);
//		FCD.setToggleGroup(tglGames);
//		Omaha.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("omaha toggled");
//				PokerTableController.setRle(new Rule(eGame.Omaha));
//			}
//		});
//		Texas.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("texas toggled");
//				PokerTableController.setRle(new Rule(eGame.TexasHoldEm));
//			}
//		});
//
//		FCD.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("fcd toggled");
//				PokerTableController.setRle(new Rule(eGame.FiveStud));
//			}
//		});
//
//		SCD.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("scd toggled");
//				PokerTableController.setRle(new Rule(eGame.SevenDraw));
//			}
//		});
//
//		oneJoker.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("one joker toggled");
//				PokerTableController.setRle(new Rule(eGame.FiveStudOneJoker));
//			}
//		});
//
//		twoJoker.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				System.out.println("two joker toggled");
//				PokerTableController.setRle(new Rule(eGame.FiveStudTwoJoker));
//			}
//		});
		this.mainApp = mainApp;
	}


	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("poker game");
		alert.setHeaderText("About");
		alert.setContentText("Author: Bert Gibbons");

		alert.showAndWait();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}


	public ToggleGroup getTglGames() {
		return tglGames;
	}

	

}