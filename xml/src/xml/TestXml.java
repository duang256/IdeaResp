package xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class TestXml {
    public static void main(String[] args) throws Exception {
        SAXReader reader=new SAXReader();
        Document doc=reader.read(new File("src/xml/scores.xml"));

        //获取根元素
        Element root=doc.getRootElement();
        System.out.println(root.getName()+"\n");
        //获取根元素下所有子元素  迭代器
        Iterator<Element> it=root.elementIterator();
        while(it.hasNext()){
            //取出元素
            Element e=  (Element)it.next();
            System.out.print(e.getName()+"\t");
            Attribute id=e.attribute("id");
            System.out.println(id.getName()+"="+id.getValue());
            Element name=e.element("name");
            Element lessons=e.element("lessons");
            Element score=e.element("score");
            System.out.println(name.getName()+"="+name.getStringValue());
            System.out.println(lessons.getName()+"="+lessons.getStringValue());
            System.out.println(score.getName()+"="+score.getText());
            System.out.println("-----------------------------------------");
        }


    }

}
