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

package it.mbcraft.fileplaza.ui.main.menu.file.actions;

import it.mbcraft.fileplaza.ui.main.menu.file.dictionaries.DictionariesWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class FileDictionariesAction implements EventHandler<ActionEvent> {

    private final DictionariesWindow window = new DictionariesWindow();
    
    @Override
    public void handle(ActionEvent t) {
        window.showAndWait();
    }
    
}
