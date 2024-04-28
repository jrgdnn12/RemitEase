package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import projectfiles.model.Recipient;
import projectfiles.model.RecipientList;
import projectfiles.model.RemittanceList;
import projectfiles.Dao.RemittanceDAOImpl;
import projectfiles.Dao.RemittanceListDAOImpl;

import java.util.ArrayList;

public class RecipientsListController {

    @FXML
    private ListView<Recipient> recipientsListView;
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) {
        openWelcomePage();
    }

    
    private void openWelcomePage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openWelcomePage'");
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
        
        remittanceList = remittanceListDAO.getRemittanceList("CSR100"); 
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
                updateButton.setOnAction(event -> updateRecipient(recipient));
                setGraphic(hbox);
            }
        }

        private void updateRecipient(Recipient recipient) {
            // Implementation for updating recipient
            System.out.println("Update requested for: " + recipient.getEmail());
        }
    }
    
}
