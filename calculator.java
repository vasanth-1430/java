import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class calculator extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage mystage) {
        // Creating UI components
        Label l1 = new Label("Enter A:");
        TextField t1 = new TextField();
        Label l2 = new Label("Enter B:");
        TextField t2 = new TextField();
        Button b1 = new Button("+");
        Button b2 = new Button("-");
        Button b3 = new Button("*");
        Button b4 = new Button("/");
        Button b5 = new Button("Clear");
        Label l3 = new Label("Answer:");
        TextField t3 = new TextField();
        t3.setEditable(false); // Make the output field read-only

        // Event handler for addition
        b1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                try {
                    int a = Integer.parseInt(t1.getText());
                    int b = Integer.parseInt(t2.getText());
                    int c = a + b;
                    t3.setText(String.valueOf(c));
                } catch (NumberFormatException e) {
                    t3.setText("Invalid Input");
                }
            }
        });

        // Event handler for subtraction
        b2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                try {
                    int a = Integer.parseInt(t1.getText());
                    int b = Integer.parseInt(t2.getText());
                    int c = a - b;
                    t3.setText(String.valueOf(c));
                } catch (NumberFormatException e) {
                    t3.setText("Invalid Input");
                }
            }
        });

        // Event handler for multiplication
        b3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                try {
                    int a = Integer.parseInt(t1.getText());
                    int b = Integer.parseInt(t2.getText());
                    int c = a * b;
                    t3.setText(String.valueOf(c));
                } catch (NumberFormatException e) {
                    t3.setText("Invalid Input");
                }
            }
        });

        // Event handler for division
        b4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                try {
                    int a = Integer.parseInt(t1.getText());
                    int b = Integer.parseInt(t2.getText());
                    if (b != 0) {
                        double c = (double) a / b; // Use double for division result
                        t3.setText(String.format("%.2f", c)); // Format to 2 decimal places
                    } else {
                        t3.setText("Cannot divide by zero");
                    }
                } catch (NumberFormatException e) {
                    t3.setText("Invalid Input");
                }
            }
        });

        // Event handler for clearing inputs and output
        b5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                t1.clear();
                t2.clear();
                t3.clear();
            }
        });

        // Layout configuration
        FlowPane fp = new FlowPane();
        fp.setVgap(10);
        fp.setHgap(10);
        fp.setPrefWrapLength(300);
        fp.getChildren().addAll(l1, t1, l2, t2, l3, t3, b1, b2, b3, b4, b5);

        // Set up scene and stage
        Scene sc = new Scene(fp, 400, 250);
        mystage.setTitle("Basic Calculator");
        mystage.setScene(sc);
        mystage.show();
    }
}