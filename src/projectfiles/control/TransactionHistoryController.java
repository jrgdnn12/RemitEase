package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.Node;
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
import projectfiles.model.Remittance;
import projectfiles.model.RemittanceList;
import projectfiles.model.User;
import projectfiles.Dao.RemittanceDAOImpl;
import projectfiles.Dao.RemittanceListDAOImpl;
import projectfiles.app.SessionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class TransactionHistoryController {
    @FXML
    private Button backButton;

	
    @FXML
    private ListView<Remittance> recipientsListView;
    
    @FXML
    public void handleBackButtonAction(ActionEvent event) {
        openWelcomePage(event);
    }
    User user = SessionManager.getInstance().getCurrentUser();

    
    private void openWelcomePage(ActionEvent event) {
      
        	 try {
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/MainMenu.fxml"));
                 Parent root = loader.load();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root));
                 stage.setTitle("Main Menu");
                 stage.show();


             } catch (IOException e) {
                 e.printStackTrace();
             }
        }
    
    
    


    public void initialize() {

    	//Instantiate a remittance list
        RemittanceList remittanceList = new RemittanceList();

        //Instantiate a DAO for remittance list
        RemittanceListDAOImpl remittanceListDAO = new RemittanceListDAOImpl();
        
        try {
        	remittanceList = remittanceListDAO.getRemittanceList(user.getId());
        }catch (SQLException e) {
    	}
    
        recipientsListView.getItems().addAll(remittanceList.getRemittanceList());
          		
        recipientsListView.setCellFactory(listView -> new RecipientCell());
      

    }		
        		


    static class RecipientCell extends ListCell<Remittance> {
        HBox hbox = new HBox(10);  // Added spacing
        Text transactionId = new Text();
        Text amount = new Text();
        Text date = new Text();
        Text status = new Text();
        Text recipientName = new Text();
        
        Text delimiter = new Text(" - ");
        
        Button sendAgainButton = new Button("Send Again");
        Button cancelButton = new Button("Cancel");
        Pane spacer = new Pane();
    
        public RecipientCell() {
            super();
            hbox.getChildren().addAll(transactionId, delimiter, recipientName, amount, date, status, spacer, sendAgainButton, cancelButton);
            HBox.setHgrow(spacer, Priority.ALWAYS);
            configureButtons();
        }
    
        private void configureButtons() {
            cancelButton.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
            sendAgainButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        }
    
        @Override
        protected void updateItem(Remittance remittance, boolean empty) {
            super.updateItem(remittance, empty);
            if (empty || remittance == null) {
                setText(null);
                setGraphic(null);
            } else {
                transactionId.setText("RE" + remittance.getTransactionId());
                recipientName.setText(formatName(remittance.getRecipientID()));
                amount.setText(String.format("$%.2f", remittance.getAmountSent()));
                date.setText(remittance.getCreatedAt().toString());
                status.setText(remittance.getStatus());
    
                sendAgainButton.setOnAction(e -> remittance.sendEmailUpdate("Sending Again!"));
                cancelButton.setOnAction(e -> cancelRemittance(e, remittance));
    
                // Enable or disable cancel button based on the status
                cancelButton.setDisable(!"Pending".equals(remittance.getStatus()));
    
                setGraphic(hbox);
            }
        }
    
        private String formatName(Recipient recipient) {
            return recipient != null ? recipient.getFirstName() + " " + recipient.getLastName() : "Unknown";
        }
    
        private void cancelRemittance(ActionEvent event, Remittance remittance) {
            // Placeholder for cancellation logic
        }
    }

//       private void CancelRemittance(ActionEvent event, Remittance remittance) {
//            try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/RecipientUpdate.fxml"));
//            Parent root = loader.load();  // Load the FXML and instantiate the controller
//
//            RecipientUpdateController controller = loader.getController();
//            controller.setRecipient(remittance );  // Set the recipient
//            controller.postInitialize();  // Manually initialize the parts of the controller that need the recipient
//
//            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//            } catch (IOException e) {
//            e.printStackTrace();
//            }
//        
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/RecipientUpdate.fxml"));
//                Parent root = loader.load();  // Load the FXML and instantiate the controller
//
//                RecipientUpdateController controller = loader.getController();
//                controller.setRecipient(remittance );  // Set the recipient
//                controller.postInitialize();  // Manually initialize the parts of the controller that need the recipient
//
//                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        



    }
    

