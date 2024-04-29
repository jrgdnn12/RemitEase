package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projectfiles.model.Recipient;
import projectfiles.model.RecipientList;
import projectfiles.model.RemittanceList;
import projectfiles.Dao.RemittanceDAOImpl;
import projectfiles.Dao.RemittanceListDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class RecipientsListController {
    @FXML
    private Button backButton;

	
    @FXML
    private ListView<Recipient> recipientsListView;
    
    @FXML
    public void handleBackButtonAction(ActionEvent event) {
        openWelcomePage(event);
    }

    
    private void openWelcomePage(ActionEvent event) {
    	 try {
             Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/WelcomePage.fxml"));
             Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }


    public void initialize() {
        
        RecipientList recipients = new RecipientList();
//        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
//        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
    
        
    	//Instantiate a remittance list
        RemittanceList remittanceList = new RemittanceList();

        //Instantiate a DAO for remittance list
        RemittanceListDAOImpl remittanceListDAO = new RemittanceListDAOImpl();
        
        try {
        	remittanceList = remittanceListDAO.getRemittanceList("CSR100");
        }catch (SQLException e) {
    	}
    
        recipients.extractRecipientsFromRemittanceList(remittanceList);

        recipientsListView.getItems().addAll(recipients.getRecipientsList());
          		
        recipientsListView.setCellFactory(listView -> new RecipientCell());
      

    }		
        		


    static class RecipientCell extends ListCell<Recipient> {
        HBox hbox = new HBox();
        Text name = new Text();
        Button sendAgainButton = new Button("Send Again");
        Button updateButton = new Button("Update");
        Pane pane = new Pane();

        public RecipientCell() {
            super();
            hbox.getChildren().addAll(name, pane, sendAgainButton, updateButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        @Override
        protected void updateItem(Recipient recipient, boolean empty) {
            super.updateItem(recipient, empty);
            if (empty || recipient == null) {
                setText(null);
                setGraphic(null);
            } else {
                name.setText(recipient.getFirstName() + " " + recipient.getLastName());
                sendAgainButton.setOnAction(event -> recipient.sendEmailUpdate("Sending Again!"));
                updateButton.setOnAction(event -> updateRecipient( event, recipient));
                setGraphic(hbox);
            }
        }

        private void updateRecipient(ActionEvent event , Recipient recipient) {
        	 try {
                 Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/RecipientUpdate.fxml"));
                 Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                 Scene scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
             } catch (IOException e) {
                 e.printStackTrace();
             }
        }
    }
    
}
