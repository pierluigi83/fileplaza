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

package it.mbcraft.fileplaza.ui.main.menu.file.dictionaries;

import it.mbcraft.fileplaza.data.models.Dictionary;
import it.mbcraft.fileplaza.ui.common.components.listview.ImprovedListCell;
import it.mbcraft.fileplaza.ui.common.IconReference;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class DictionaryListCell extends ImprovedListCell<Dictionary> {    
    
    public DictionaryListCell() {
        super(new SimpleIntegerProperty(1));
    }
    
    @Override
    public void updateItem(Dictionary data,boolean empty) {
        super.updateItem(data, empty);
        if (empty) {
            setLabelText(null);
            clearStatusIcons();
        } else {
            setLabelText(data.getShortTitle());
            if (data.isEnabled()) {
                clearStatusIcons();
                pushStatusIcon(new IconReference(IconReference.IconCategory.MISC,"Tick_Circle")); 
            } else {
                clearStatusIcons();
            }
            
        }
        setUserData(data);
    }

}
