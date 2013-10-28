/**
 * @version $Id$
 * Create date: Oct 28, 2013
 * Create by: enixjin
 */
package com.feedReader;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.feedReader.bean.Channel;
import com.feedReader.bean.Feed;
import com.feedReader.bean.Item;

/**
 * Class description goes here
 * 
 * @author enixjin
 * 
 */
public class Main {

    /**
     * method description goes here
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Feed feed = new Feed("http://services.explorecalifornia.org/rss/tours.php");
        Feed feed = new Feed("http://feed.google.org.cn/");
        try {
            feed.parse();
            for (Channel channel : feed.getChannels()) {
                System.out.println(channel.toString());
                for (Item item : channel.getItems()) {
                    System.out.println("|- " + item.toString());
                }
                System.out.println("**************************************");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
