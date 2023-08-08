package bstorm.models.properties;

import java.util.HashMap;
import java.util.Map;

public class BaseProperty<Tkey,TValue>{
    protected final Map<Tkey,TValue> properties;

    public BaseProperty() {
        this.properties = new HashMap<>();
    }

    public TValue getProperty(Tkey key) {
        if (!properties.containsKey(key))
            throw new RuntimeException();
        return properties.get(key);
    }
    public void setProperty(Tkey key, TValue value){
        properties.put(key,value);
    }
}
