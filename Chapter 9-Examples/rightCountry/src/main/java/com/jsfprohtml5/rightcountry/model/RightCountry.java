package com.jsfprohtml5.rightcountry.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.richfaces.event.DropEvent;

public class RightCountry implements Serializable {
    private List<Place> places;
    private List<Place> egyptPlaces;
    private List<Place> germanyPlaces;    
    private List<Place> brazilPlaces;   
    
    public RightCountry() {
        initialize();
    }    
    
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
    
    public List<Place> getEgyptPlaces() {
        return egyptPlaces;
    }

    public void setEgyptPlaces(List<Place> egyptPlaces) {
        this.egyptPlaces = egyptPlaces;
    }

    public List<Place> getGermanyPlaces() {
        return germanyPlaces;
    }

    public void setGermanyPlaces(List<Place> germanyPlaces) {
        this.germanyPlaces = germanyPlaces;
    }

    public List<Place> getBrazilPlaces() {
        return brazilPlaces;
    }

    public void setBrazilPlaces(List<Place> brazilPlaces) {
        this.brazilPlaces = brazilPlaces;
    }
    
    public void processDrop(DropEvent event) {
        Place place = (Place) event.getDragValue();
        String dropValue = (String) event.getDropValue();
        
        switch (dropValue) {
            case "Egypt":
                egyptPlaces.add(place);
                places.remove(place);
                break;
            case "Germany":
                germanyPlaces.add(place);
                places.remove(place);
                break;     
            case "Brazil":
                brazilPlaces.add(place);
                places.remove(place);
                break;                 
        }
        
        if (places.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage("Congratulations! You are done."));
            
            initialize();
        }
    }    
    
    private void initialize () {
        egyptPlaces = new ArrayList<>();
        germanyPlaces = new ArrayList<>();
        brazilPlaces = new ArrayList<>();
        places = new ArrayList<>();
        
        places.add(new Place("The Great Pyramids of Giza", "Egypt"));
        places.add(new Place("Western Pomerania Lagoon Area National Park", "Germany"));
        places.add(new Place("Catete Palace", "Brazil"));
        places.add(new Place("Saxon Switzerland National Park", "Germany"));
        places.add(new Place("Luxor Temple", "Egypt"));
        places.add(new Place("Mariano Procópio Museum", "Brazil"));
        places.add(new Place("Bavarian Forest National Park", "Germany"));
        places.add(new Place("Museu do Índio", "Brazil"));            
        places.add(new Place("Cairo Tower", "Egypt"));          
    }
}
    