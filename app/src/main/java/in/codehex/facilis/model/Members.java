package in.codehex.facilis.model;

/**
 * Created by Codehex-Keshav on 05-05-2016.
 */
public class Members {
    private String date, duration, numberOfItems, name;

    public Members(){    }

    public Members(String date, String duration, String numberOfItems, String name){
        this.date = date;
        this.duration = duration;
        this.numberOfItems = numberOfItems;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
