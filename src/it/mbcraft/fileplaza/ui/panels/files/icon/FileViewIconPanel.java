/*
 *    FilePlaza - a tag based file manager
 *    Copyright (C) 2015 - Marco Bagnaresi
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.mbcraft.fileplaza.ui.panels.files.icon;

import it.mbcraft.fileplaza.ui.common.components.IItemViewer;
import it.mbcraft.fileplaza.ui.common.components.INodeProvider;
import it.mbcraft.fileplaza.ui.common.components.tileview.ImprovedTileView;
import it.mbcraft.fileplaza.ui.panels.files.IElementActionListener;
import java.io.File;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;

/**
 * This class handles the view of a grid of files in a 'tile' or 'grid'
 * mode.
 * 
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class FileViewIconPanel implements INodeProvider,IItemViewer<File> {
   
    private final IntegerProperty _zoomLevelProperty;
    private final ImprovedTileView<File> _fileIcons;
    
    //final component is a BorderPane
    private final BorderPane _fullPanel;
    
    public FileViewIconPanel(IntegerProperty zoomLevelProperty,IElementActionListener listener) {
        
        _fullPanel = new BorderPane();
        
        _zoomLevelProperty = zoomLevelProperty;
                       
        _fileIcons = new ImprovedTileView<>();
        _fileIcons.selectionModelProperty().get().setSelectionMode(SelectionMode.SINGLE);      
        _fileIcons.cellFactoryProperty().set(new FileIconCellFactory(_zoomLevelProperty,_fileIcons,listener));
    
        _fullPanel.setCenter(_fileIcons);
    }
    
    @Override
    public ObjectProperty<ObservableList<File>> itemsProperty() {
        return _fileIcons.itemsProperty();
    }
    
    @Override
    public ObjectProperty<MultipleSelectionModel<File>> selectionModelProperty() {
        return _fileIcons.selectionModelProperty();
    }

    @Override
    public Node getNode() {
        return _fullPanel;
    }  
            
}
