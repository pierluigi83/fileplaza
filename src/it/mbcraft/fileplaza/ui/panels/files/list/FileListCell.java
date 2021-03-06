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

package it.mbcraft.fileplaza.ui.panels.files.list;

import it.mbcraft.fileplaza.ui.common.components.listview.ImprovedListCell;
import it.mbcraft.fileplaza.ui.common.IconReference;
import java.io.File;
import javafx.beans.property.IntegerProperty;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class FileListCell extends ImprovedListCell<File> {

    public FileListCell(IntegerProperty zoomLevelProp) {
        super(zoomLevelProp);
    }
       
    @Override
    public void updateItem(File data,boolean empty) {
        
        super.updateItem(data, empty);
        if (empty) {
            setLabelText(null);
            setMainIcon(null);
        } else {
            setLabelText(data.getName());
            if (data.isDirectory())
                pushFolderIcon();
            else
                pushFileIcon(data.getName());
        }
    }
    
    private void pushFolderIcon() {
        setMainIcon(new IconReference(IconReference.IconCategory.FILE,"folder"));
    }
    
    private void pushFileIcon(String filename) {
        String extension = filename.substring(filename.lastIndexOf(".")+1);
        
        setMainIcon(new IconReference(IconReference.IconCategory.FILE,extension));   
    }
    
}
