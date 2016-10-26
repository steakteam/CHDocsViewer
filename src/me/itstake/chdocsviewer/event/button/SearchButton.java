package me.itstake.chdocsviewer.event.button;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by deide on 2016-10-27.
 */
public class SearchButton implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		System.out.println("clicked");
	}
}
