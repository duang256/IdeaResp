package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;


public class TestXml2 {
    public static void main(String[] args) throws Exception {
        Document doc= DocumentHelper.createDocument();
        Element root=doc.addElement("scores");
        Element student=root.addElement("student");
        student.addAttribute("id","s01");
        Element name=student.addElement("name");
        Element lessons=student.addElement("lessons");
        Element score= student.addElement("score");

        name.addText("周某");
        lessons.addText("线代");
        score.addText("88");
//        将doc输出到xml文件中
//        Writer writer=new FileWriter(new File("src/xml/scores2.xml"));
//        doc.write(writer);
//        writer.close();

        //格式良好的输出
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer1=new XMLWriter(new FileWriter(new File("src/xml/scores2.xml")),format);
        writer1.write(doc);
        writer1.flush();
        writer1.close();
    }
}
