package org.test.task;

public class BusSelectionService {
    static final String posh = "Posh";

    public Bus preferredBus(Bus first, Bus second){
        if (first.getDepartureTime().equals(second.getDepartureTime())){
            if (first.getDuration() == second.getDuration()){
                if(first.getCompanyName().equalsIgnoreCase(posh)){
                    return first;
                } else {
                    return second;
                }
            } else if(first.getDuration() > second.getDuration()) {
                return second;
            } else {
                return first;
            }
        }
        return first;
    }
}
