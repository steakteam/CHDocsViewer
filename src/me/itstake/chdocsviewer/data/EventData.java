package me.itstake.chdocsviewer.data;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by deide on 2016-10-27.
 */
public class EventData {
	private SimpleStringProperty name;
	private SimpleStringProperty desc;
	private SimpleStringProperty prefilter;
	private SimpleStringProperty eventData;
	private SimpleStringProperty mutability;

	public EventData(String name, String desc, String prefilter, String eventData, String mutability) {
		this.name = new SimpleStringProperty(name);
		this.desc = new SimpleStringProperty(desc);
		this.prefilter = new SimpleStringProperty(prefilter);
		this.eventData = new SimpleStringProperty(eventData);
		this.mutability = new SimpleStringProperty(mutability);
	}

	public String getName() {
		return name.get();
	}

	public String getDesc() {
		return desc.get();
	}

	public String getPrefilter() {
		return prefilter.get();
	}

	public String getEventData() {
		return eventData.get();
	}

	public String getMutability() {
		return mutability.get();
	}
}
