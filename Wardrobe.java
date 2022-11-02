package model;

import log.Event;
import log.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Wardrobe {
    private LinkedList<Outfit> wardrobe;

    // EFFECTS: creates a new empty wardrobe with no outfits
    public Wardrobe() {
        wardrobe = new LinkedList<>();
    }


    // EFFECTS: returns the names of the outfits in the wardrobe
    public String getOutfits() {

        if (wardrobe.size() > 0) {

            ArrayList<String> names = new ArrayList<>();
            for (Outfit outfit : wardrobe) {
                names.add(outfit.getName());
            }
            return names.toString();
        } else {
            return "The wardrobe is empty!";
        }
    }


    // EFFECTS: returns the outfit with the given name, if not found return null
    public Outfit findOutfit(String name) {
        for (Outfit outfit : wardrobe) {
            if (outfit.getName().equals(name)) {
                return outfit;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: creates new outfit with given name and adds to wardrobe
    public Outfit createOutfit(String name) {
        Outfit temp = new Outfit(name);
        wardrobe.add(temp);
        EventLog.getInstance().logEvent(new Event("Added new outfit " + name + " to wardrobe."));
        return temp;
    }

    // REQUIRES: outfit is in wardrobe
    // MODIFIES: this
    // EFFECTS: removes the given outfit from the wardrobe
    public void removeOutfit(Outfit outfit) {
        wardrobe.remove(outfit);
        EventLog.getInstance().logEvent(
                new Event("Removed the outfit " + outfit.getName() + " from wardrobe."));
    }

    public int getSize() {
        return wardrobe.size();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Outfits", outfitsToJson());
        return json;
    }


    // EFFECTS: Each outfit in wardrobe gets stored to file
    private JSONArray outfitsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Outfit o : wardrobe) {
            jsonArray.put(o.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns true if the name of outfit matches given name
    public boolean contains(String outfitName) {
        for (Outfit o : wardrobe) {
            if (o.getName().equals(outfitName)) {
                return true;
            }
        }
        return false;
    }

    public String printLog(EventLog eventLog) {
        String ret = "";
        for (Event next : eventLog) {
            ret = ret + next.toString() + "\n\n";
        }
        return ret;
    }
}


