/**
 * @version $Id$
 * Create date: Oct 28, 2013
 * Create by: enixjin
 */
package com.feedReader.dom.bean;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class description goes here
 * 
 * @author enixjin
 * 
 */
public class Item {

    private String title = "";
    private String link = "";
    private String description = "";
    private String pubDate = "";

    /**
     * @param current
     */
    public Item(Node currentItem) {
        NodeList childNodes = currentItem.getChildNodes();
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

            case "pubDate":
                setPubDate(current.getTextContent());
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
        return "Item{title:" + getTitle() + ", link:" + getLink() + ", description:" + getDescription() + ", pubDate:"
                + getPubDate() + "}";
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
     * @return the pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * @param pubDate
     *            the pubDate to set
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

}
