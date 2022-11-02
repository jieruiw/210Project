package model;

import log.Event;
import log.EventLog;
import org.json.JSONObject;

import java.util.LinkedList;

public class Outfit {
    private String name;
    private LinkedList<String> outfit;

    // EFFECTS: creates an empty outfit with the given name
    public Outfit(String name) {
        this.name = name;
        outfit = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds clothing item to the outfit
    public void addClothing(String s) {
        outfit.add(s);
        EventLog.getInstance().logEvent(new Event("Added " + s + " to outfit " + name + "."));
    }

    // REQUIRES: clothing item with given name is already in outfit
    // MODIFIES: this
    // EFFECTS: removes the given clothing item from the outfit
    public void removeClothing(String s) {
        outfit.remove(s);
        EventLog.getInstance().logEvent(new Event("Removed " + s + " from outfit " + name));
    }

    // EFFECTS: returns the clothing items in the outfit
    public String getOutfit() {

        if (outfit.size() == 0) {
            return "This outfit is empty.";
        }

        return "Outfit " + name + " has " + outfit.toString();
    }


    // EFFECTS: returns true if the given clothing item is in the outfit
    public boolean contains(String clothing) {
        for (String item : outfit) {
            if (item.equals(clothing)) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the name of the outfit
    public String getName() {
        return name;
    }

    // EFFECTS: returns how many items are in outfit
    public int getSize() {
        return outfit.size();
    }

    // EFFECTS: stores this outfit to file
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("outfit", outfit);
        return json;
    }
}