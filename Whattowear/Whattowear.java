import java.util.Date;
class Whattowear {
  public int currentDay() {
    Date curr = new Date();
    int dayint = curr.getDay();
    return dayint;
  }
  public String[] whattowear() {
    int hi = this.currentDay();
    Getdata data = new Getdata();
    float[] weather = new float[3];
    if (hi != 0 && hi != 6) {
      weather = data.parseWeekday(data.call());
    } else {
      weather = data.parseWeekend(data.call());
    }
    String[] pants = {"Shorts", "Pants"};
    String[] shirts = {"T-shirt", "Shirt", "Long-Sleeved Shirt"};
    String[] jackets = {"No Jacket" , "Light Jacket", "Thick Jacket","Rain Jacket"};
    String[] retval = new String[4];
    System.out.println("Temperature: " + weather[0]);
    //weather[0] = temperature
    if(weather[0] > 60) {
      retval[0] = pants[(int)Math.round(Math.random())];
      retval[1] = shirts[(int)Math.round(Math.random()) * 2];
      if(weather[0] < 70) {
        retval[2] = jackets[(int)Math.round(Math.random())];
      } else {
        retval[0] = pants[0];
      }
    } else {
      retval[1] = shirts[(int)Math.round(Math.random()) * 2];
      retval[2] = jackets[(int)Math.round(Math.random()) + 1];
      retval[0] = pants[1];
      if (weather[0] <= 45) {
        retval[2] = jackets[2];
      }
    }
    System.out.println("Precipitation Intensity: " + weather[1]);
    System.out.println("Precipitation Probability: " + weather[2]);
    // weather[1] = Precipitation Intensity 0-1, and weather[2] = Precipitation Probability 0-1
    if (weather[1] > 0.07 || weather[2] > 0.5) {
      retval[2] = jackets[3];
      retval[0] = pants[1];
    }
    return retval;
  }
  public static void main(String[] args) {
    Whattowear test = new Whattowear();
    String [] test2 = test.whattowear();
    System.out.println("You should wear " + test2[0]);
    System.out.println("You should wear a " + test2[1]);
    System.out.println("You should wear " + test2[2]);
  }
}
