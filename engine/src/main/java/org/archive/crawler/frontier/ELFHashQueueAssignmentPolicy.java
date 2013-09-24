package org.archive.crawler.frontier;

import java.util.logging.Logger;

import org.archive.crawler.framework.CrawlController;
import org.archive.modules.CrawlURI;


public class ELFHashQueueAssignmentPolicy extends 
QueueAssignmentPolicy{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ELFHashQueueAssignmentPolicy.class.getName());
    /**
     * 
     */


    @Override
    public String getClassKey(CrawlURI cauri) {
        // TODO Auto-generated method stub
        String uri = cauri.getUURI().toString();
        long hash = ELFHash(uri);
        String a = Long.toString(hash%100);
        return a;
    }
    public long ELFHash(String str)
    {
        long hash=0;
        long x=0;
        for(int i=0;i<str.length();i++)
        {
            hash=(hash<<4)+str.charAt(i);
            if((x=hash&0xF0000000L)!=0)
            {
                hash ^=(x>>24);
                hash &=~x;
            }
        }
        return (hash&0x7FFFFFFF);
    }
    }
