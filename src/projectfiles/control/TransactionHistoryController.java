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
import projectfiles.Dao.RemittanceDAOImpl;
import projectfiles.Dao.RemittanceListDAOImpl;

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
        	remittanceList = remittanceListDAO.getRemittanceList("CSR100");
        }catch (SQLException e) {
    	}
    
        recipientsListView.getItems().addAll(remittanceList.getRemittanceList());
          		
        recipientsListView.setCellFactory(listView -> new RecipientCell());
      

    }		
        		


    static class RecipientCell extends ListCell<Remittance> {
        HBox hbox = new HBox();
        Text TransactionId = new Text();
        Text Amount = new Text();
        Text Date = new Text();
        Text Status = new Text();
        Text Recipient = new Text();

        //delimter for adress
        Text delimiter = new Text(" - ");
        Text delimiter2 = new Text(" - ");
        Text delimiter3 = new Text(" - ");
        Text delimiter4 = new Text(" - ");
        
        
        Button sendAgainButton = new Button("Send Again");
        Button updateButton = new Button("Cancel"); // Declare and initialize the updateButton variable
        Pane pane = new Pane();

        public RecipientCell() {
            super();
            hbox.getChildren().addAll(TransactionId, delimiter, Recipient ,delimiter2, Amount, delimiter3, Date, delimiter4, Status, pane, sendAgainButton, updateButton);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        @Override
        protected void updateItem(Remittance remittance, boolean empty) {
            if (empty || remittance == null) {
            setText(null);
            setGraphic(null);
            }else {
            
            TransactionId.setText("RE" + remittance.getTransactionId());
            Recipient.setText(remittance.getRecipientID().getFirstName() + " " + remittance.getRecipientID().getLastName());
            Amount.setText("$" + remittance.getAmountSent());
            Date.setText(remittance.getCreatedAt().toString()); // Convert LocalDateTime to string
            Status.setText(remittance.getStatus());
            updateButton.setOnAction(event -> CancelRemittance(event, remittance));
            if (!remittance.getStatus().equals("Pending")) {
            	hbox.getChildren().remove(updateButton);
            } 
                
         
            sendAgainButton.setOnAction(event -> remittance.sendEmailUpdate("Sending Again!"));
            setGraphic(hbox);
            }
        }

        private void CancelRemittance(ActionEvent event, Remittance remittance) {
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



    }}
    

