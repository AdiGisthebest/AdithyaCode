import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
class Zillowdata {
  public String [][] zillowPrices(String output) {
    Element root = null;
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder build = factory.newDocumentBuilder();
      Document xml = build.parse(new StringBufferInputStream(output));
      xml.getDocumentElement().normalize();
      root = xml.getDocumentElement();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
    String [][] retval = new String[((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").getLength()][4];
    try {
      String status = ((Element)root.getElementsByTagName("message").item(0)).getElementsByTagName("text").item(0).getTextContent();
      if (status.equals("Request successfully processed")) {
        for (int i = 0; i < ((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").getLength(); i++) {
            retval[i][0] = ((Element)((Element)((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(i)).getElementsByTagName("address").item(0)).getElementsByTagName("street").item(0).getTextContent();
          retval[i][1] = ((Element)((Element)((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(i)).getElementsByTagName("zestimate").item(0)).getElementsByTagName("amount").item(0).getTextContent();
          retval[i][2] = ((Element)((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(i)).getElementsByTagName("zpid").item(0).getTextContent();
          //System.out.println(((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").getLength());
          if (((Element)((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(i)).getElementsByTagName("rentzestimate").getLength() == 1) {
            retval[i][3] = ((Element)((Element)((Element)((Element)root.getElementsByTagName("response").item(0)).getElementsByTagName("results").item(0)).getElementsByTagName("result").item(i)).getElementsByTagName("rentzestimate").item(0)).getElementsByTagName("amount").item(0).getTextContent();
          } else {
            retval[i][3] = "";
          }
        }
      } else {
        return retval;
      }
      return retval;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retval;
  }
  public Boolean forSale(String zpid) {
    Element root = null;
    Getdata hi = new Getdata();
    String data = hi.forSaleCall(zpid);
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder build = factory.newDocumentBuilder();
      Document xml = build.parse(new StringBufferInputStream(data));
      xml.getDocumentElement().normalize();
      root = xml.getDocumentElement();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
    String status = ((Element)root.getElementsByTagName("message").item(0)).getElementsByTagName("text").item(0).getTextContent();
    if (status.equals("Error: protected data is unavailable through API")) {
      return true;
    } else {
      return false;
    }
  }
}
