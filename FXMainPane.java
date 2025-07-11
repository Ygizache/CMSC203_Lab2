
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
  private Button helloButton, howdyButton,chineseButton, clearButton, exitButton;
  private Label feedbackLabel;
  private TextField feedbackTextField;
  private HBox buttonBox, textBox;
  private DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		
		feedbackLabel = new Label("Feedback:");
		feedbackTextField = new TextField();
		//  instantiate the HBoxes
		buttonBox = new HBox();
		textBox = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		textBox.getChildren().addAll(feedbackLabel, feedbackTextField);
		//  add the buttons to the other HBox
		buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(textBox, buttonBox);
		 
		ButtonHandler handler = new ButtonHandler();
		helloButton.setOnAction(handler);
		howdyButton.setOnAction(handler);
		chineseButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		exitButton.setOnAction(handler);
		
		buttonBox.setAlignment(Pos.CENTER);
		textBox.setAlignment(Pos.CENTER);
		
		HBox.setMargin(helloButton, new Insets(10));
		HBox.setMargin(howdyButton, new Insets(10));
		HBox.setMargin(chineseButton, new Insets(10));
		HBox.setMargin(clearButton, new Insets(10));
		HBox.setMargin(exitButton, new Insets(10));
		HBox.setMargin(feedbackLabel, new Insets(10));
		HBox.setMargin(feedbackTextField, new Insets(10));
		
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if (source == helloButton) {
				feedbackTextField.setText(dataManager.getHello());
			} else if (source == howdyButton) {
				feedbackTextField.setText(dataManager.getHowdy());
			}else if (source == chineseButton) {
				feedbackTextField.setText(dataManager.getChinese());
			} else if (source == clearButton) {
				feedbackTextField.setText("");
			} else if (source == exitButton) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
