/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package notenrechner;

import javax.swing.filechooser.FileFilter;
import java.io.File;
/**
 *
 * @author marian
 */
public class ConfigurableFileFilter extends FileFilter  {

   private String description;
   private String[] extensions;


   /**
    * Filter mit Beschreibung und Liste von Dateierweiterungen erzeugen
    */
   public ConfigurableFileFilter(String desc, String... ext) {
      this.description = desc;
      this.extensions = ext;
   }

   /**
    * Prüfen, ob die gegebene Datei zu einer der registrierten Datei-
    * erweiterungen gehört. Nur File-Objekte, für die true zurück-
    * geliefert wird, werden im Datei-Dialog angezeigt.
    */
   public boolean accept(File f)  {

      // Verzeichnisse alle anzeigen
      if(f.isDirectory() == true)
         return true;

      else if (f.isFile()) {
         for( String s : extensions)
            if(f.getName().endsWith(s))
               return true;
      }

      return false;
   }

   public String getDescription() {
      return description;
   }

}
