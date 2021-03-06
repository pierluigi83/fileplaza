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
package it.mbcraft.fileplaza.data.models;

import it.mbcraft.fileplaza.data.dao.meta.DictionaryDAO;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
 */
public class Tag {

    public Tag(String key, Object value, TagType type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }
    /**
     * The tag type
     */
    private TagType type;
    /**
     * The key used to differentiate among other tags
     */
    private String key;
    /**
     * The value of this tag
     */
    private Object value;

    /**
     * @return the type
     */
    public TagType getType() {
        return type;
    }

    /**
     * @param tagType the type to set
     */
    public void setType(TagType tagType) {
        this.type = tagType;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the value as a row object
     *
     * @return The value as an object
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the value of this tag and its type.
     *
     * @param value The value of this tag
     * @param tagType The type of this tag
     */
    public void setValue(Object value, TagType tagType) {
        this.value = value;
        this.type = tagType;
    }

    /**
     * @return the value as date
     */
    public Date getValueAsDate() {
        return (Date) getValue();
    }

    /**
     * @param value the value to set as date
     */
    public void setValueAsDate(Date value) {
        setValue(value, TagType.DATE);
    }

    /**
     * @return the value as string
     */
    public String getValueAsString() {
        return (String) getValue().toString();
    }

    /**
     * @param value the value to set as string
     */
    public void setValueAsString(String value) {
        setValue(value, TagType.STRING);
    }

    /**
     * @return the value
     */
    public int getValueAsNumber() {
        return (Integer) getValue();
    }

    /**
     * @param value the value to set
     */
    public void setValueAsNumber(int value) {
        setValue(value, TagType.NUMBER);
    }

    /**
     * Returns the value of this tag as a user defined enum (string)
     *
     * @return The value of an user defined enum as a string
     */
    public String getValueAsUserDefinedEnum() {
        return (String) getValue();
    }

    /**
     * Sets the value of this tag as a user defined enum.
     *
     * @param value The string value of an user defined enum.
     */
    public void setValueAsUserDefinedEnum(String value) {
        setValue(value, TagType.LABEL);
    }

    /**
     * Gets the value as a dictionary string
     *
     * @return The string value
     */
    public String getValueAsDictionary() {
        return (String) getValue();
    }

    /**
     * Sets the value as a dictionary string
     *
     * @param dict The string value of the dictionary
     */
    public void setValueAsDictionary(String dict) {
        setValue(dict, TagType.DICTIONARY);
    }

    /**
     * Checks if this tag is plural of the parameter tag
     * 
     * @param fileTag
     * @return 
     */
    public boolean isPluralOf(Tag fileTag) {
        DictionaryDAO dao = DictionaryDAO.getInstance();
        Entry<String,String> match = dao.findEntryFromEnabledDictionaries(fileTag.getValueAsString());
        if (match==null)
            return false;
        if (fileTag.getValueAsString().equals(match.getKey()))
            return true;
        return false;            
    }

    /**
     *
     * @author Marco Bagnaresi <marco.bagnaresi@gmail.com>
     */
    public static enum TagType {

        DATE, STRING, DICTIONARY, NUMBER, LABEL

    }
    
    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (!(o instanceof Tag)) return false;
        Tag other = (Tag)o;
        return key.equals(other.key) && type.equals(other.type) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + Objects.hashCode(this.key);
        hash = 83 * hash + Objects.hashCode(this.value);
        return hash;
    }
}
