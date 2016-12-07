package me.itstake.chdocsviewer.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by deide on 2016-11-11.
 */
public class SortUtils {
    public static <T> void ascendingFirstColumn(TableView<T> tableView) {
        TableColumn<T, ?> column = tableView.getColumns().get(0);
        column.setSortType(TableColumn.SortType.ASCENDING);
        tableView.getSortOrder().add(column);
        tableView.sort();
    }
}
