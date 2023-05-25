import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class WriteXml {

    public static void main(String[] args) {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        String filename = "data.xml";

        try {
            XMLStreamWriter xmlStreamWriter =
                    xmlOutputFactory.createXMLStreamWriter(
                            new FileOutputStream(filename), "UTF-8");

            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("data");
            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeStartElement("firstName");
            xmlStreamWriter.writeCharacters("John");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeStartElement("lastName");
            xmlStreamWriter.writeCharacters("Smith");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeStartElement("phone");
            xmlStreamWriter.writeCharacters("916-555-4418");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeEndDocument();

            xmlStreamWriter.flush();
            xmlStreamWriter.close();
        } catch(XMLStreamException | FileNotFoundException e){
            e.printStackTrace();
        }
    }
}