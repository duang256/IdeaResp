package Webserver;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Text {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Handler handler=new Handler();
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();
        parser.parse(Thread.currentThread().getContextClassLoader().
                getResourceAsStream("Webserver/p.xml"),handler);
        List<Person> persons=handler.getPersons();
        for (Person person:persons
             ) {
            System.out.println(person.getName()+"-->"+person.getAge());
        }

    }


}


class Handler extends DefaultHandler {
    private List<Person> persons=null;
    String tag;
    Person person=null;
    @Override
    public void startDocument() throws SAXException {
        persons=new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equals("person")){
            person=new Person();
        }
        tag=qName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents=new String(ch,start,length).trim();
        if(tag!=null){
            if(tag.equals("name")){
                person.setName(contents);
            }else if(tag.equals("age")){
                person.setAge(contents);
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equals("person")){
            persons.add(person);
        };
        tag=null;
    }


    @Override
    public void endDocument() throws SAXException {

    }

    public List<Person> getPersons() {
        return persons;
    }
}



