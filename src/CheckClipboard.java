
import bijoytounicode.BijoyToUnicodeConverter;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hrido
 */
public class CheckClipboard {
    static String copiedPreData="";
    static String convertedPreData="";
    static boolean proceed=true;
    public static void main(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                while(proceed){
        try{
            Thread.sleep(1000);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String data=(String)clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
       
        if(!data.equals(convertedPreData)){
        String newConvertedData=BijoyToUnicodeConverter.convert(data);
        convertedPreData=newConvertedData;
        StringSelection stringSelection = new StringSelection(newConvertedData);
        clipboard.setContents(stringSelection, null);
        }
       
        }catch(Exception e){
            System.out.println("Error encountered. But its okey");
        }
        }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        t.start();
    }
    
}
