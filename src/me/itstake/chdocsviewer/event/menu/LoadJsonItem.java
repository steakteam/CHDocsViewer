package me.itstake.chdocsviewer.event.menu;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.data.deserializer.CHJsonDeserializer;

import java.io.File;

/**
 * Created by deide on 2016-10-27.
 */
public class LoadJsonItem implements EventHandler<ActionEvent> {
	private TableView<FunctionData> funcList;
	private TableView<EventData> eventList;

	public LoadJsonItem(TableView<FunctionData> funcList, TableView<EventData> eventList) {
		this.funcList = funcList;
		this.eventList = eventList;
	}

	@Override
	public void handle(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		File file = chooser.showOpenDialog(new Stage());
		if (file != null) {
			CHJsonDeserializer handler = new CHJsonDeserializer(file);
			if(!handler.isMapEmpty()) {
				ObservableList<FunctionData> funcList = handler.getFuncList();
				ObservableList<EventData> eventList = handler.getEventList();
				this.funcList.setItems(funcList);
				this.eventList.setItems(eventList);
			}
		}
	}
}
