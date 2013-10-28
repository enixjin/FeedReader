/**
 * @version $Id$
 * Create date: Oct 28, 2013
 * Create by: enixjin
 */
package com.feedReader.dom.bean;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class description goes here
 * 
 * @author enixjin
 * 
 */
public class Channel {

    public static String tagName = "channel";

    private String title = "";
    private String link = "";
    private String description = "";
    private List<Item> items = new ArrayList<>();

    /**
     * 
     */
    public Channel(Node channalNode) {
        NodeList childNodes = channalNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node current = childNodes.item(i);
            switch (current.getNodeName().toString()) {
            case "title":
                setTitle(current.getTextContent());
                break;

            case "description":
                setDescription(current.getTextContent());
                break;

            case "link":
                setLink(current.getTextContent());
                break;

            case "item":
                Item item = new Item(current);
                getItems().add(item);
                break;
            default:
                // do nothing.
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Channel{title:" + getTitle() + ", link:" + getLink() + ", description:" + getDescription() + "}";
    }

    /**
     * @return the tagName
     */
    public static String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     *            the tagName to set
     */
    public static void setTagName(String tagName) {
        Channel.tagName = tagName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     *            the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
