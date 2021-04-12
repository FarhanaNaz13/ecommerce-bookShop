package com.bookstore.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USConstants {

    public final static String US = "US";

    public final static Map<String, String> mapOfUSStates = new HashMap<String, String>() {
        {
            put("Al", "Alaska");
            put("Ar", "Arizona");
            put("CO", "Colorado");
            put("De", "Delaware");
            put("Ge", "Georgia");
            put("Ha", "Hawaii");
            put("Fl", "Florida");
            
            
            
            
            
            
            
            
            
            
            
            
          
        }
    };

    public final static List<String> listOfUSStatesCode = new ArrayList<>(mapOfUSStates.keySet());
    public final static List<String> listOfUSStatesName = new ArrayList<>(mapOfUSStates.values());
}
