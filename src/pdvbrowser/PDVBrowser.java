package pdvbrowser;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/**
 *
 * @author T23579
 */

public class PDVBrowser extends Application {
      public static void main(String[] args) {
        Application.launch(args);
    }
    
   @Override public void start(Stage stage) {
     
      WebView view = new WebView();
      WebEngine engine = view.getEngine();
      engine.load("https://bobbeer.fun/pdv1/login");
      
      StackPane root = new StackPane();
      root.getChildren().addAll(view);
     
      
      int width = (int) Screen.getPrimary().getBounds().getWidth();
      int height = (int) Screen.getPrimary().getBounds().getHeight();
      
        Scene scene = new Scene(root,width,height);
        stage.setTitle("PDV System"); 
        stage.setScene(scene); 
        stage.setMaximized(true); 
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show(); 
         
       
    root.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {  
     boolean contem  =  engine.getLocation().contains("/pos/view/");
    if ( e.getCode() == KeyCode.P && contem) {
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                engine.print(job);
                job.endJob();
            }
    }
});
        
 
}
   
  
}
