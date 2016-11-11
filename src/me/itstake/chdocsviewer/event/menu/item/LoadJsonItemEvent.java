package me.itstake.chdocsviewer.event.menu.item;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.data.deserializer.CHJsonDeserializer;
import me.itstake.chdocsviewer.util.SortUtils;

import java.io.File;

/**
 * Created by deide on 2016-10-27.
 */
public class LoadJsonItemEvent implements EventHandler<ActionEvent> {
	private TableView<FunctionData> funcView;
	private TableView<EventData> eventView;

	public LoadJsonItemEvent(TableView<FunctionData> funcView, TableView<EventData> eventView) {
		this.funcView = funcView;
		this.eventView = eventView;
	}

	@Override
	public void handle(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("JSON", "*.json"));
		File file = chooser.showOpenDialog(new Stage());
		if (file != null) {
			if (file.getName().endsWith(".json")) {
				CHJsonDeserializer handler = new CHJsonDeserializer(file);
				if (!handler.isMapEmpty()) {
					ObservableList<FunctionData> funcList = handler.getFuncList();
					ObservableList<EventData> eventList = handler.getEventList();
					funcView.setItems(funcList);
					eventView.setItems(eventList);

					SortUtils.ascendingFirstColumn(funcView);
					SortUtils.ascendingFirstColumn(eventView);
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("올바르지 않은 형식");
				alert.setContentText(".json 확장자인 올바른 형식의 파일이여야 합니다.");
				alert.show();
			}
		}
	}
}
