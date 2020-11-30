
package tienda.gui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validator {
    private final JTextField txt;
    public Validator(JTextField txt) {
        this.txt = txt;
    }
    private boolean error(String msj){
        txt.requestFocus();
        JOptionPane.showMessageDialog(txt, msj, "error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    public boolean length(int min,int max){
        if(txt.getText().length()>=min && txt.getText().length()<=max) return true;
        return error("El texto debe tener entre "+min+" y "+max+"caracteres!");
    } 
    public boolean length(int min){
        if(txt.getText().length()>min ) return true;
        return error("El texto tiene tener "+ min+" caracteres o mas");
    } 
   
    public boolean isInteger(){
        try {
            Integer.parseInt(txt.getText());
           
            return true;
        } catch (NumberFormatException e) {
           
            return error("El valor debe ser un número entero!");
        }
    }
    public boolean isFloat(){
        try {
            Float.parseFloat(txt.getText());
            return true;
        } catch (NumberFormatException e) {
            return error("El valor debe ser numerico ");
        }
    }
    
    public boolean isInteger(int min,int max){
        if(!isInteger()) return false;
        int valor=Integer.parseInt(txt.getText());
        if(valor>=min && valor<=max) return true;
        return error("El valor debe ser entre "+min+" y "+max);
    }
     public static Boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }    
}
