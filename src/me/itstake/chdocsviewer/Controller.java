package me.itstake.chdocsviewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.event.button.SearchButtonEvent;
import me.itstake.chdocsviewer.event.menu.item.LoadJsonItemEvent;

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
    private TableView<FunctionData> funcView;
    @FXML
    private TableView<EventData> eventView;
    @FXML
    private TextField searchField;

    private void menuBarInit() {
        menuBar.setUseSystemMenuBar(true);
    }

    private void menuItemInit() {
        loadJson.setOnAction(new LoadJsonItemEvent(funcView, eventView));
    }

    private void searchInit() {
        SearchButtonEvent event = new SearchButtonEvent(funcView, eventView, searchField);
        searchBtn.setOnAction(event);
        searchField.setOnAction(event);
    }

    private void tableInit() {
        for (TableColumn column : funcView.getColumns()) {
            column.setCellFactory(param -> {
                TableCell<FunctionData, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(column.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
        }

        for (TableColumn ecolumn : eventView.getColumns()) {
            ecolumn.setCellFactory(param -> {
                TableCell<EventData, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(ecolumn.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBarInit();
        menuItemInit();
        searchInit();
        tableInit();
    }
}
