package me.itstake.chdocsviewer.event.button;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.util.SortUtils;

/**
 * Created by deide on 2016-10-27.
 */
public class SearchButtonEvent implements EventHandler<ActionEvent> {
	private TableView<FunctionData> funcView;
	private TableView<EventData> eventView;
	private TextField searchField;
	private ObservableList<FunctionData> funcMasterList;
	private ObservableList<EventData> eventMasterList;

	public SearchButtonEvent(TableView<FunctionData> funcView, TableView<EventData> eventView, TextField searchField) {
		this.funcView = funcView;
		this.eventView = eventView;
		this.searchField = searchField;
	}

	@Override
	public void handle(ActionEvent event) {
		masterInit();
		String keyword = searchField.getText().toLowerCase();
		FilteredList<FunctionData> funcFilter = new FilteredList<>(funcMasterList);
		FilteredList<EventData> eventFilter = new FilteredList<>(eventMasterList);

		if (keyword.length() > 0) {
			funcFilter.setPredicate(s -> s.getName().toLowerCase().contains(keyword));
			eventFilter.setPredicate(s -> s.getName().toLowerCase().contains(keyword));
			funcView.setItems(funcFilter);
			eventView.setItems(eventFilter);
		} else {
			funcView.setItems(funcMasterList);
			eventView.setItems(eventMasterList);
		}
		SortUtils.ascendingFirstColumn(funcView);
		SortUtils.ascendingFirstColumn(eventView);
	}

	private void masterInit() {
		if (funcMasterList == null) {
			funcMasterList = funcView.getItems();
		}
		if (eventMasterList == null) {
			eventMasterList = eventView.getItems();
		}
	}
}
