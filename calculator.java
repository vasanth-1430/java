import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    private TextField display;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calc");

        display = new TextField();
        display.setEditable(false);
        display.setPrefWidth(200);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(display, 0, 0, 4, 1);

        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "Clear", "=", "/"
        };

        int row = 1;
        int col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setPrefSize(50, 50);
            button.setOnAction(e -> handleButtonClick(label));
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 230, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String label) {
        switch (label) {
            case "Clear":
                display.clear();
                break;
            case "=":
                try {
                    double result = eval(display.getText());
                    display.setText(String.valueOf(result));
                } catch (Exception e) {
                    display.setText("Error");
                }
                break;
            default:
                display.appendText(label);
                break;
        }
    }

    private double eval(String expression) throws Exception {
        javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
        return (double) engine.eval(expression);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
