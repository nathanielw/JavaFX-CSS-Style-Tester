/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package styletester;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.css.CSSStyleSheet;

/**
 *
 * @author nathaniel
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Parent root;
    
    private Scene scene;
    
    private File stylesheet;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSS Stylesheet");

        fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("CSS Stylesheets", "*.css"),
            new ExtensionFilter("All Files", "*.*")
        );
        
        File selectedFile = fileChooser.showOpenDialog((Stage)this.root.getScene().getWindow());
        
        if (selectedFile != null) {
        }
    }
    
    @FXML
    private void handleLoadAction(ActionEvent event) {
                    
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose stylesheet");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSS Stylesheets", "*.css"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*"));
        
        File styleFile = fileChooser.showOpenDialog((Stage) root.getScene().getWindow());
        
        if(styleFile != null) {
            this.stylesheet = styleFile;

            this.scene.getStylesheets().clear();
            this.scene.getStylesheets().add("file:///" + this.stylesheet.getAbsolutePath().replace("\\", "/"));
        }
    }
    
    @FXML
    private void handleReloadAction(ActionEvent event) {        
        if(this.stylesheet != null) {
            System.out.println("Loading");
            this.scene.getStylesheets().clear();
            this.scene.getStylesheets().add("file:///" + this.stylesheet.getAbsolutePath().replace("\\", "/"));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void setup(Scene scene) {
        this.scene = scene;
    }
    
}
