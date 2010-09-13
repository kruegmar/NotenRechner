package notenrechner;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class DOMReader {

   private DocumentBuilder parser = null;
   private ArrayList<Mark> marks;

   public DOMReader() throws ParserConfigurationException {
      DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
      marks = new ArrayList<Mark>();
      parser = fac.newDocumentBuilder();
   }

   /**
    * Parsen einer XML-Datei
    * @param              Einzulesende Datei
    */
   public ArrayList<Mark> read(File f) {
      try {
         // Dokument einlesen
         Document doc = parser.parse(f);

         // Dokument verarbeiten
         analyze(doc);

      } catch(SAXException e) {
         e.printStackTrace();
      } catch(Exception e) {
         e.printStackTrace();
      }

      return this.marks;
   }

   /**
    * Parsen eines XML-Strings
    * @param              String mit XML-Dokument
    */
   public ArrayList<Mark> read(String str) {
      try {
         // aus dem String ein InputSource-Objekt erstellen
         InputSource input = new InputSource(new StringReader(str));

         // Dokument einlesen
         Document doc = parser.parse(input);

         // Dokument verarbeiten
         analyze(doc);

      } catch(SAXException e) {
         e.printStackTrace();
      } catch(Exception e) {
         e.printStackTrace();
      }
      return this.marks;
   }



   /**
    * Analysiert den übergebenen Knoten
    * @param node         Zu analysierender Knoten
    */
   private void analyze(Node node) {

      // Wenn es sich um einen Text-Knoten handelt, Inhalt ausgeben
      if(node != null && node.getNodeType() == Node.TEXT_NODE) {

         // Wert lokal zwischenspeichern
         String value = node.getNodeValue().trim();

         // Wenn Textinhalt vorhanden, dann ausgeben
         if(value.length() > 0) {
            //System.out.printf("               Wert: %s\n", value);
         }

      } else {
         // Name des Knotens ausgeben
         //System.out.printf("Gefundendes Element: %s\n",
         //                        node.getNodeName());
         if (node.getNodeName().equals("mark")) {
           //TODO Invalid format Exception
                this.marks.add(
                        new Mark(node.getChildNodes().item(1).getChildNodes().item(0)
                        .getNodeValue().trim()
                        ,Integer.parseInt(node.getChildNodes().item(3).getChildNodes().item(0)
                        .getNodeValue().trim())
                        ,null));
         }

         // Überprüfen, ob untergeordnete Knoten existieren
         if(node.hasChildNodes()) {
            // Alle untergeordneten Knoten durchlaufen
            int num = node.getChildNodes().getLength();

            for(int i=0; i < num; i++) {
               // Aktuellen Knoten analysieren
               analyze(node.getChildNodes().item(i));
            }
         }
      }
   }
}