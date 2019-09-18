import Entity.Group;
import Entity.People;
import Entity.Person;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class runMain {
    public static void main(String[] args) throws Exception {
        // String name, int age, long income, String incomeType
        People p1 = new People("Alex", 29, 100, "weekly");
        People p2 = new People("Bob", 24, 300, "Annually");
        GroupUpImpl group1 = new GroupUpImpl();
        List<People> l1 = new LinkedList<>();
        l1.add(p1);
        l1.add(p2);
        Group buddy = group1.mergeGroupMembers(l1, "Buddy");
        System.out.println(buddy.getGroupSize());
        System.out.println(group1.getAllowedOrigins().size());
        group1.modifyAllowedOrigins("www.google.com,www.cisco.com,www.webex.cisco.com");
        System.out.println(group1.getAllowedOrigins().size());
        group1.modifyAllowedOrigins("*");
        System.out.println(group1.getAllowedOrigins().size());
        GroupUpImpl group2 = new GroupUpImpl();
        Group test = group2.mergeGroupMembers("test");
        System.out.println(test.getGroupSize());

        Person person = XMLtoPersonExample("person.xml");
        personToXMLExample("person-output.xml", person);

        // use Quartz to have a job scheduled periodically to read newest allowedOrigins from database.
        // And it will save into cache.
        // Another method to call updateAllowedOrigins in CORSFilter to update the allowedOrigin with new cache
        // this will be put in main of xmlproxy.



        //
    }

    private static Person XMLtoPersonExample(String filename) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Person) jaxbUnmarshaller.unmarshal(file);
    }

    private static void personToXMLExample(String filename, Person person) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(person, file);
        jaxbMarshaller.marshal(person, System.out);
    }
}
