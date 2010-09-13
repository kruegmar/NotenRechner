/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package notenrechner;

import javax.swing.JComboBox;

/**
 *
 * @author marian
 */
public class Mark {

    public Mark(String prNr, int mark, JComboBox cb) {
      this.prNr = prNr;
      this.mark = mark;
      this.cb = cb;
    }

    private String prNr;
    private int mark;
    private JComboBox cb;

    public int getMark() {
      return mark;
    }

    public String getPrNr() {
      return prNr;
    }

    public JComboBox getCb() {
        return cb;
    }
}