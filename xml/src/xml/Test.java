package xml;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) throws Exception {
        Writer writer = new BufferedWriter(new FileWriter(new File("src/xml/a.txt")));
        writer.write("m");
//        writer.flush();
        writer.close();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date date=dateFormat.parse("2020-5-24 5-0-0");
        System.out.println(date);
        Calendar calendar=new GregorianCalendar();

    }
}
