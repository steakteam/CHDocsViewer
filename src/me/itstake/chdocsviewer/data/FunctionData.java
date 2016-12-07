package me.itstake.chdocsviewer.data;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by deide on 2016-10-27.
 */
public class FunctionData {
    private SimpleStringProperty name;
    private SimpleStringProperty ret;
    private SimpleStringProperty args;
    private SimpleStringProperty desc;

    public FunctionData(String name, String ret, String args, String desc) {
        this.name = new SimpleStringProperty(name);
        this.ret = new SimpleStringProperty(ret);
        this.args = new SimpleStringProperty(args);
        this.desc = new SimpleStringProperty(desc);
    }

    public String getName() {
        return name.get();
    }

    public String getRet() {
        return ret.get();
    }

    public String getArgs() {
        return args.get();
    }

    public String getDesc() {
        return desc.get();
    }
}
