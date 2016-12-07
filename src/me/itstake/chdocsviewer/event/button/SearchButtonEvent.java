package me.itstake.chdocsviewer.event.button;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.storage.ListStorage;
import me.itstake.chdocsviewer.util.SortUtils;

/**
 * Created by deide on 2016-10-27.
 */
public class SearchButtonEvent implements EventHandler<ActionEvent> {
    private TableView<FunctionData> funcView;
    private TableView<EventData> eventView;
    private TextField searchField;

    public SearchButtonEvent(TableView<FunctionData> funcView, TableView<EventData> eventView, TextField searchField) {
        this.funcView = funcView;
        this.eventView = eventView;
        this.searchField = searchField;
    }

    @Override
    public void handle(ActionEvent event) {
        ensure();
        String keyword = searchField.getText().toLowerCase();
        ObservableList<FunctionData> funcList = ListStorage.getFuncMasterList();
        ObservableList<EventData> eventList = ListStorage.getEventMasterList();
        FilteredList<FunctionData> funcMasterList = new FilteredList<>(funcList);
        FilteredList<EventData> eventMasterList = new FilteredList<>(eventList);

        if (keyword.length() > 0) {
            funcMasterList.setPredicate(s -> s.getName().toLowerCase().contains(keyword));
            eventMasterList.setPredicate(s -> s.getName().toLowerCase().contains(keyword));
            funcView.setItems(funcMasterList);
            eventView.setItems(eventMasterList);
        } else {
            funcView.setItems(funcMasterList);
            eventView.setItems(eventMasterList);
        }
        SortUtils.ascendingFirstColumn(funcView);
        SortUtils.ascendingFirstColumn(eventView);
    }

    private void ensure() {
        if (ListStorage.getFuncMasterList() == null) {
            ListStorage.setFuncMasterList(funcView.getItems());
        }
        if (ListStorage.getEventMasterList() == null) {
            ListStorage.setEventMasterList(eventView.getItems());
        }
    }
}
