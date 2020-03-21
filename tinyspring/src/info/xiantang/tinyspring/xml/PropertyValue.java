package info.xiantang.tinyspring.xml;

public class PropertyValue {

    private final String name;
    private final Object value;

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
