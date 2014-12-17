/*
 *  Developed by MBCRAFT. Copyright © 2014-2015. All rights reserved.
 *  This file of source code is property of MBCRAFT (http://www.mbcraft.it). 
 *  Do not sell, do not remove this license note even if you edit this file.
 *  Do not use this source code to develop your own file manager application.
 *  You can reuse part or full files for your own project (eg javafx ui classes)
 *  but keep copyright in files, and please link http://www.mbcraft.it on your
 *  project website.
 *
 *  Thanks
 *
 *  - Marco Bagnaresi
 */

package it.mbcraft.fileplaza.ui.main.menu.help.feedback;

import static it.mbcraft.fileplaza.i18n.Lang.L;
import it.mbcraft.fileplaza.i18n.LangResource;
import it.mbcraft.fileplaza.net.SuggestionReporter;
import it.mbcraft.fileplaza.ui.common.components.INodeProvider;
import it.mbcraft.fileplaza.ui.common.helpers.GridPaneFiller;
import it.mbcraft.fileplaza.ui.dialogs.DialogFactory;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
@LangResource("main.menu.help.feedback.SuggestAFeaturePanel")
public class SuggestAFeaturePanel implements INodeProvider {
    
    private final VBox box = new VBox();
    
    private final GridPane grid = new GridPane();
    
    private final ComboBox featureTypeSelector = new ComboBox();
    private final TextField featureTitle = new TextField();
    private final TextArea featureDescription = new TextArea();
    
    public SuggestAFeaturePanel() {
        initGrid();
        initButtonBar();
    }
    
    @Override
    public Node getNode() {
        return box;
    }

    private void initGrid() {
        GridPaneFiller.reset(2);
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        
        initSelector();
        initFeatureTitle();
        initFeatureDescription();
        
        box.getChildren().add(grid);
    }
    
    private void initSelector() {
        Label l = new Label(L(this,"Selector_Label"));
        grid.add(l, GridPaneFiller.X(), GridPaneFiller.Y());
        
        featureTypeSelector.getItems().addAll(Arrays.asList(L(this,"1feature_Choice"),L(this,"2feature_Choice"),L(this,"3feature_Choice"),L(this,"4feature_Choice"),L(this,"5feature_Choice")));
        
        grid.add(featureTypeSelector, GridPaneFiller.X(), GridPaneFiller.Y());
    }
    
    private void initFeatureTitle() {
        Label l = new Label(L(this,"ShortTitle_Label"));
        grid.add(l,GridPaneFiller.X(), GridPaneFiller.Y());

        featureTitle.setPromptText(L(this,"ShortTitle_PromptText"));
        
        grid.add(featureTitle, GridPaneFiller.X(), GridPaneFiller.Y());
    }
    
    private void initFeatureDescription() {
        Label l = new Label(L(this,"Description_Label"));
        grid.add(l,GridPaneFiller.X(),GridPaneFiller.Y());

        featureDescription.setPromptText(L(this,"Description_PromptText"));
        
        grid.add(featureDescription, GridPaneFiller.X(), GridPaneFiller.Y());
    }

    private void initButtonBar() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        
        Button sendButton = new Button(L(this,"Send_Button"));
        sendButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (validate()) {
                    submitFeature();
                    DialogFactory.showInformationDialog(L(this,"ThankYou_Dialog"), L(this,"ThankYou_Text"));
                    clearFields();
                }
            }
        });
        
        pane.setCenter(sendButton);
        box.getChildren().add(pane);
    }
    
    private boolean validate() {
        if (featureTypeSelector.getSelectionModel().getSelectedIndex()>=0 && !featureTitle.getText().equals("") && !featureDescription.getText().equals(""))
            return true;
        else {
            DialogFactory.showErrorDialog(L(this,"Error_Dialog"), L(this,"Error_Text"));
            return false;
        }
    }
    
    private void clearFields() {
        featureTypeSelector.getSelectionModel().clearSelection();
        featureTitle.setText(null);
        featureDescription.setText(null);
    }
    
    private void submitFeature() {
        SuggestionReporter rep = new SuggestionReporter();
        rep.suggestFeature(featureTypeSelector.getSelectionModel().getSelectedIndex(),featureTitle.getText(),featureDescription.getText());
    }
    
}