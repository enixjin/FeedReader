/**
 * @version $Id$
 * Create date: Oct 28, 2013
 * Create by: enixjin
 */
package com.feedReader.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class description goes here
 * 
 * @author enixjin
 * 
 */
public class Feed {
    // variables
    private String URL;
    private List<Channel> channels = new ArrayList<>();

    // methods
    /**
     * 
     */
    public Feed(String url) {
        setURL(url);
    }

    public void parse() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document feedDom = builder.parse(getURL());
        NodeList channelList = feedDom.getElementsByTagName(Channel.tagName);
        for (int i = 0; i < channelList.getLength(); i++) {
            Node channelNode = channelList.item(i);
            Channel channel = new Channel(channelNode);
            channels.add(channel);
        }
    }

    // setter and getter
    /**
     * @return the uRL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param uRL
     *            the uRL to set
     */
    public void setURL(String uRL) {
        URL = uRL;
    }

    /**
     * @return the channels
     */
    public List<Channel> getChannels() {
        return channels;
    }

    /**
     * @param channels
     *            the channels to set
     */
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

}
