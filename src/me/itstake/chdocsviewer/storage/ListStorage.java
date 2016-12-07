package me.itstake.chdocsviewer.storage;

import javafx.collections.ObservableList;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;

/**
 * Created by deide on 2016-12-08.
 */
public class ListStorage {
    private static ObservableList<FunctionData> funcMasterList;
    private static ObservableList<EventData> eventMasterList;

    public static ObservableList<FunctionData> getFuncMasterList() {
        return funcMasterList;
    }

    public static ObservableList<EventData> getEventMasterList() {
        return eventMasterList;
    }

    public static ObservableList<FunctionData> setFuncMasterList(ObservableList<FunctionData> funcMasterList) {
        ListStorage.funcMasterList = funcMasterList;
        return funcMasterList;
    }

    public static ObservableList<EventData> setEventMasterList(ObservableList<EventData> eventMasterList) {
        ListStorage.eventMasterList = eventMasterList;
        return eventMasterList;
    }
}
