/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package notenrechner;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author marian
 */
public class DocumentCreator {

 public static Document createProgrammatically(ArrayList<Mark> data) {
      Document doc = null;
      try {
         // DocumentBuilder instanzieren
         DocumentBuilder docBuilder =
            DocumentBuilderFactory.newInstance().newDocumentBuilder();

         // Document-Instanz erzeugen
         doc = docBuilder.newDocument();
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      }

      if(null != doc) {
         // Root-Element erzeugen
         Element marks = doc.createElement("marks");
         // Element anfügen
         doc.appendChild(marks);


         for (Iterator<Mark> it = data.iterator(); it.hasNext();) {
           Mark mark1 = it.next();

           // Noten-Element erzeugen
           Element mark = doc.createElement("mark");
           // Fach-Element erzeugen
           Element subject = doc.createElement("prNr");
           // Fach-Note erzeugen
           Element note = doc.createElement("note");

           // Fach
           subject.setTextContent(mark1.getPrNr());
           // Note
           note.setTextContent(Integer.toString(mark1.getMark()));

           // Noten-Element hinzufügen
           marks.appendChild(mark);
           // Fach-Element hinzufügen
           mark.appendChild(subject);
           // Fach-Note hinzufügen
           mark.appendChild(note);
         }
      }

      // Document-Instanz zurückgeben
      return doc;
   }
}//end of class
