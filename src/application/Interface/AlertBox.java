package application.Interface;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AlertBox {
	public static void errorAlert() {
		errorAlert("An Error Occured!");
	}
	
	public static void errorAlert(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void errorAlertNoHeader(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait(); 
	}
	
	public static void infoAlert() {
		infoAlert("Developer Forgot To Parse Message");
	}
	
	public static void infoAlert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void exceptionAlert(Exception e) {
		exceptionAlert(e,"Something Happened");
	}
	
	public static void exceptionAlert(Exception e, String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Error");
		alert.setHeaderText("Oops. We hit a snag!");
		alert.setContentText(msg);


		Label label = new Label("The exception stacktrace was:");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String stackTrace = sw.toString();
		TextArea textArea = new TextArea(stackTrace);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);
		expContent.add(new Label("Blame Jun (He doesnt know xD) "), 0, 2);
		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
}
