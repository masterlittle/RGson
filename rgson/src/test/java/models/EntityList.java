package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shitij on 18/10/16.
 */
public class EntityList {

    @SerializedName("entity_list")
    @Expose
    private List<Entity> entityList;

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    @Override
    public String toString() {
        return "EntityList{" +
                "entityList=" + entityList +
                '}';
    }
}
