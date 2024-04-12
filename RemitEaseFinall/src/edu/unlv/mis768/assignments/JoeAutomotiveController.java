package edu.unlv.mis768.assignments;

/**
 * Name: Philip Mensah
 * Purpose: To provide a user-friendly interface for managing customer orders at Joe's Automotive shop.
 * This class serves as the controller for the GUI application.
 * Date: 03-31-2024
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class JoeAutomotiveController {

    @FXML
    private Button calculateButton;

    @FXML
    private Label costLabel;

    @FXML
    private Label discountLabel;

    @FXML
    private Label hoursLabel;

    @FXML
    private CheckBox inspectionCheckbox;

    @FXML
    private TextField laborHoursField;

    @FXML
    private CheckBox lubeJobCheckbox;

    @FXML
    private CheckBox mufflerReplacementCheckbox;

    @FXML
    private CheckBox oilChangeCheckbox;

    @FXML
    private TextField partCostField;

    @FXML
    private CheckBox radiatorFlushCheckbox;

    @FXML
    private Label resultLabel;

    @FXML
    private Label selectionLabel;

    @FXML
    private VBox servicesVBox;

    @FXML
    private RadioButton tenPercentDiscountRadioButton;

    @FXML
    private CheckBox tireRotationCheckbox;

    @FXML
    private CheckBox transMissionFlushCheckbox;

    @FXML
    private RadioButton twentyPercentDiscountRadioButton;
    
    // Event handler for radio buttons to get the discount
    @FXML
    void getDiscountFromRadioButtons(ActionEvent event) {
        // Ensure only one discount radio button can be selected
        if (tenPercentDiscountRadioButton.isSelected()) {
            twentyPercentDiscountRadioButton.setSelected(false);
        } else if (twentyPercentDiscountRadioButton.isSelected()) {
            tenPercentDiscountRadioButton.setSelected(false);
        }
        // Recalculate total when a discount radio button is clicked
        calculateTotal();
    }
    
    // Event handler for checkboxes to recalculate total
    @FXML
    void handleCheckboxClicked(ActionEvent event) {
        // Recalculate total when a checkbox is clicked
        calculateTotal();
    }

    /**
     * Event listeners.
     */

    // Method to calculate the total cost
    public void calculateTotal() {
        try {
            double laborHours = 0.0;
            double partsCost = 0.0;

            // Parse labor hours if not empty
            if (!laborHoursField.getText().isEmpty()) {
                laborHours = Double.parseDouble(laborHoursField.getText());
            }

            // Parse parts cost if not empty
            if (!partCostField.getText().isEmpty()) {
                partsCost = Double.parseDouble(partCostField.getText());
            }

            // Create a CustomerOrder object based on user input
            CustomerOrder order = createCustomerOrderFromInput(laborHours, partsCost);

            // Calculate total amount
            double total = order.getTotal();

         // Format total amount to two decimal places
            String formattedTotal = String.format("%.2f", total);

            // Display formatted total amount
            resultLabel.setText(formattedTotal);
        } catch (NumberFormatException e) {
            // Handle input validation errors
            resultLabel.setText("Invalid input");
        }
    }
    
    // Method to create a CustomerOrder object from user input
    public CustomerOrder createCustomerOrderFromInput(double laborHours, double partsCost) {
        // Get input values from UI components
        boolean oilChange = oilChangeCheckbox.isSelected();
        boolean lubeJob = lubeJobCheckbox.isSelected();
        boolean radiatorFlush = radiatorFlushCheckbox.isSelected();
        boolean transmissionFlush = transMissionFlushCheckbox.isSelected();
        boolean inspection = inspectionCheckbox.isSelected();
        boolean mufflerReplacement = mufflerReplacementCheckbox.isSelected();
        boolean tireRotation = tireRotationCheckbox.isSelected();

        // Get discount from RadioButtons
        double discount = getDiscountFromRadioButtons();

        // Create CustomerOrder object with labor hours and parts cost
        CustomerOrder order = new CustomerOrder(oilChange, lubeJob, radiatorFlush, transmissionFlush,
                inspection, mufflerReplacement, tireRotation, partsCost, laborHours, discount);

        return order;
    }

    // Method to get discount from selected radio button
    public double getDiscountFromRadioButtons() {
        if (tenPercentDiscountRadioButton.isSelected()) {
            return 0.10;
        } else if (twentyPercentDiscountRadioButton.isSelected()) {
            return 0.20;
        } else {
            // No discount selected, return 0.0
            return 0.0;
        }
    }
}