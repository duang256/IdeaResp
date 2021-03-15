package server;




import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class WebApp {


public servlets getServletFromUrl(String url) throws Exception{

    SAXParserFactory factory=SAXParserFactory.newInstance();
    SAXParser parser=factory.newSAXParser();
    WebHandler webHandler=new WebHandler();
    parser.parse(Thread.currentThread().getContextClassLoader().
            getResourceAsStream("web.xml"), webHandler);



    List<Servlet> servlets=webHandler.getServlets();
    List<Mapping>mappings=webHandler.getMappings();
    WebContext context=new WebContext(servlets,mappings);

    url="/"+url;
    String className=context.getClz(url);
    Class clz=Class.forName(className);
    servlets servlet= (server.servlets) clz.getConstructor().newInstance();
    return  servlet;


}



}



class WebHandler extends DefaultHandler {
    private List<Servlet> servlets=null;
    private List<Mapping>mappings=null;
    private boolean isServlet;
    private String tag;
    Mapping mapping=null;
    Servlet servlet=null;
    @Override
    public void startDocument() {
        servlets=new ArrayList<>();
        mappings=new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if(qName.equals("servlet")){
            servlet=new Servlet();
            isServlet=true;
        } else if (qName.equals("servlet-mapping")){
            mapping=new Mapping();
            isServlet=false;
        }
        tag=qName;

    }


    @Override
    public void characters(char[] ch, int start, int length) throws NullPointerException {
        String contents=new String(ch,start,length).trim();
        if(tag!=null) {
            if (isServlet) {
                if (tag.equals("servlet-name")) {
                    servlet.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    servlet.setClz(contents);
                }

            } else {
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }

            }
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if(qName.equals("servlet")){
            servlets.add(servlet);
        }else if(qName.equals("servlet-mapping")){
            mappings.add(mapping);
        }
        tag=null;
    }



    public List<Mapping> getMappings() {
        return mappings;
    }

    public List<Servlet> getServlets() {
        return servlets;
    }
}
