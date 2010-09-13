/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package notenrechner;

/**
 *
 * @author marian
 */
/**
 *
 * @support  Peter Müller (der Originalcode wurde freundlicherweise von Karsten Samaschke zur Verfügung gestellt.)
 */
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.Document;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.OutputStreamWriter;

public class DocWriter {

   /**
    * Schreibt die übergebene Document-Instanz nach System.out
    */
   public static void writeToSystemOut(Document content) {
      // TransformerFactory instanzieren
      TransformerFactory tf =
         TransformerFactory.newInstance();

      // Einrückungstiefe definieren
      tf.setAttribute("indent-number", new Integer(3));
      Transformer t = null;
      try
      {
         // Transformer-Instanz abrufen
         t = tf.newTransformer();

         // Parameter setzen: Einrücken
         t.setOutputProperty(OutputKeys.INDENT, "yes");

         // Ausgabe-Typ: xml
         t.setOutputProperty(OutputKeys.METHOD, "xml");

         // Content-Type
         t.setOutputProperty(
            OutputKeys.MEDIA_TYPE, "text/xml");

         // Transformation durchführen und Ergebnis in einen Stream speichern
         t.transform(new DOMSource(content),
            new StreamResult(
               new OutputStreamWriter(System.out)));

      } catch (TransformerConfigurationException e) {
         e.printStackTrace();
      } catch (TransformerException e) {
         e.printStackTrace();
      }
   }

      /**
    * Schreibt die übergebene Document-Instanz nach System.out
    */
   public static void writeToFile(Document content, String fileName) {
      // TransformerFactory instanzieren
      TransformerFactory tf = TransformerFactory.newInstance();

      // Einrückungstiefe definieren
      tf.setAttribute("indent-number", new Integer(3));
      Transformer t = null;
      try {
         // Transformer-Instanz abrufen
         t = tf.newTransformer();

         // Parameter setzen: Einrücken
         t.setOutputProperty(OutputKeys.INDENT, "yes");

         // Ausgabe-Typ: xml
         t.setOutputProperty(OutputKeys.METHOD, "xml");

         // Content-Type
         t.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");

         // Encoding setzen
         t.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");

         // FileWriter erzeugen
         FileWriter fw = new FileWriter(fileName);

         // Transformation durchführen und Ergebnis in einen Stream speichern
         t.transform(new DOMSource(content),
            new StreamResult(fw));

      } catch (TransformerConfigurationException e) {
         e.printStackTrace();
      } catch (TransformerException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}

