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

package it.mbcraft.fileplaza.data.serialization.managers.config;

import it.mbcraft.fileplaza.data.serialization.storages.StorageHelper;
import it.mbcraft.fileplaza.data.serialization.managers.AbstractModelManager;
import it.mbcraft.fileplaza.data.models.config.Settings;
import it.mbcraft.fileplaza.data.serialization.storages.DirObjectStorage;
import it.mbcraft.fileplaza.data.serialization.engines.ISerializer;
import it.mbcraft.fileplaza.data.serialization.engines.XMLSerializer;
import java.io.File;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class SettingsManager extends AbstractModelManager<Settings> {

    public SettingsManager(String prefix) {
        super(new DirObjectStorage(new File(prefix+StorageHelper.DEFAULT_CONFIG_PATH)));
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public String getModelKey(Settings obj) {
        return "settings.xml";
    }

    @Override
    protected String getRootName() {
        return "settings";
    }

    @Override
    public Class getDataClass() {
        return Settings.class;
    }

    @Override
    public ISerializer getSerializer() {
        XMLSerializer xs = new XMLSerializer();
        xs.alias("settings", Settings.class);
        return xs;
    }
    
}
