package me.itstake.chdocsviewer.data.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.itstake.chdocsviewer.data.EventData;
import me.itstake.chdocsviewer.data.FunctionData;
import me.itstake.chdocsviewer.util.FileUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by deide on 2016-10-27.
 */
public class CHJsonDeserializer {
	private File jsonFile;
	private Map<String, ArrayList<LinkedTreeMap<String, String>>> map;

	public CHJsonDeserializer(File file) {
		this.jsonFile = file;
		this.map = getMap();
	}

	private Map<String, ArrayList<LinkedTreeMap<String, String>>> getMap() {
		Map<String, ArrayList<LinkedTreeMap<String, String>>> map = null;
		if (jsonFile != null) {
			String fileContents = FileUtils.readText(jsonFile);
			Type type = new TypeToken<Map<String, ArrayList<LinkedTreeMap<String, String>>>>() {
			}.getType();
			try {
				map = new Gson().fromJson(fileContents, type);
			} catch (JsonSyntaxException ex) {
				//ignore
			}
		}
		return map;
	}

	public boolean isMapEmpty() {
		return map == null;
	}

	public ObservableList<FunctionData> getFuncList() {
		ObservableList<FunctionData> list = FXCollections.observableArrayList();
		List<LinkedTreeMap<String, String>> funcList = map.get("functions");

		list.addAll(funcList.stream().map(func -> new FunctionData(
				func.get("name") + "()",
				func.get("ret").replace("&lt;", "<").replace("&gt;", ">"),
				func.get("args").replace("&lt;", "<").replace("&gt;", ">"),
				func.get("desc").replace("&lt;", "<").replace("&gt;", ">")
		)).collect(Collectors.toList()));

		return list;
	}

	public ObservableList<EventData> getEventList() {
		ObservableList<EventData> list = FXCollections.observableArrayList();
		List<LinkedTreeMap<String, String>> eventList = map.get("events");

		list.addAll(eventList.stream().map(event -> new EventData(
				event.get("name").replace("&lt;", "<").replace("&gt;", ">"),
				event.get("desc").replace("&lt;", "<").replace("&gt;", ">"),
				event.get("prefilter").replace("&lt;", "<").replace("&gt;", ">"),
				event.get("eventData").replace("&lt;", "<").replace("&gt;", ">"),
				event.get("mutability").replace("&lt;", "<").replace("&gt;", ">")
		)).collect(Collectors.toList()));

		return list;
	}

	private String replaceXmlChars(String item) {
		return item.replace("&lt;", "<").replace("&gt;", ">");
	}
}
