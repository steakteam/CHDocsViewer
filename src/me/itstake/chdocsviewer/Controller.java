package me.itstake.chdocsviewer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.event.button.SearchButton;
import me.itstake.chdocsviewer.event.menu.LoadJsonItem;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	private MenuBar menuBar;
	@FXML
	private MenuItem loadJson;
	@FXML
	private Button searchBtn;
	@FXML
	private TableView<FunctionData> funcList;
	@FXML
	private TableView<EventData> eventList;

	private void menuBarInit() {
		menuBar.setUseSystemMenuBar(true);
	}

	private void menuItemInit() {
		loadJson.setOnAction(
				new LoadJsonItem(funcList, eventList)
		);
	}

	private void buttonInit() {
		searchBtn.setOnAction(new SearchButton());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuBarInit();
		menuItemInit();
		buttonInit();
		funcList.setItems(FXCollections.observableArrayList(
				new FunctionData("a", "b", "c", "d")
		));
	}

}
