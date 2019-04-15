

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultLocation {
    private ArrayList coordinates = new ArrayList<Double>();
    private  String type;
    private String countryCode;

//    private Object location = {type: "Point", coordinates: [53.90453979999999, 27.561524400000053], countryCode: "by"};

    public ArrayList<Double> getCoordinates() {
        coordinates.add(53.90453979999999);
        coordinates.add(27.561524400000053);
        return coordinates;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public DefaultLocation(String type, String countryCode, ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
        this.type = type;
        this.countryCode = countryCode;
    }


    public DefaultLocation() {

    }
    public  void  addCoordinates(Double number1, Double number2) {
        coordinates.add(number1);
        coordinates.add(number2);
    }

  /*  public ArrayList<Double> coordinates() {
        coordinates.add(0, 53.90453979999999);
        coordinates.add(1, 27.561524400000053);
        return coordinates;
    }*/
}
