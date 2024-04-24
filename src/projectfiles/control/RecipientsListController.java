package projectfiles.control;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import projectfiles.model.Recipient;

import java.util.ArrayList;

public class RecipientsListController {

    @FXML
    private ListView<Recipient> recipientsListView;

    public void initialize() {
        // Sample data for demonstration
        ArrayList<Recipient> recipients = new ArrayList<>();
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("email@example.com", "John", "Doe", "1234567890"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        recipients.add(new Recipient("another@example.com", "Jane", "Roe", "0987654321"));
        

        recipientsListView.getItems().addAll(recipients);
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
