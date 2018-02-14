/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystemapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author norriswise
 */
public class HotelManagementSystemApp extends Application 
{
    
    @Override
    public void start(Stage stage) throws IOException 
    {
        
       
        Parent root = FXMLLoader.load(getClass().getResource("ReservationSystemUI.fxml"));
        
        
        
        Scene scene = new Scene(root,463,544);
        
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinWidth(scene.widthProperty().doubleValue());
        stage.setMinHeight(scene.heightProperty().doubleValue());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


