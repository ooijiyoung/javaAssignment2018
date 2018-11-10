package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Database.ResultDB;
import application.Model.Comms;
import application.Model.Result;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ResultController implements Initializable {

	int c = 0;
	int r = 1;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private GridPane gpResults;

	@FXML
	private ImageView imgHome;

	@FXML
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

//    public void 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int count = 1;
		
		int stdID = Comms.getInstance().shareVar().getID();
		ResultDB result = new ResultDB();
		ArrayList<Result> resultlist;
		resultlist = result.selectResultWhereStdID(stdID);
		for (int x = 0; x < resultlist.size(); x++) {
			
			String newcount = new Integer(count).toString();
			Label numLbl = new Label(newcount);
			Label resultLbl = new Label(resultlist.get(x).getResult());
			Label diffLbl = new Label(resultlist.get(x).getDiff());
			Label gradeLbl = new Label(resultlist.get(x).getGrade());
			gpResults.add(numLbl, 0, count);
			gpResults.add(resultLbl, 1, count);
			gpResults.add(diffLbl, 2, count);
			gpResults.add(gradeLbl, 3, count);

		
			count++;

		}

	}

}
