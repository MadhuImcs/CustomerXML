package trmg.imcs.xml.CustomerXML.app;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import trmg.imcs.xml.CustomerXML.Customer;

public class CustomerApp {

	public static void main(String[] args) {
	unMarshall();
	marshall();
	}

	static void marshall() {
		try {
			Customer customer = unMarshall();
			File file = new File("C:\\Users\\\\User\\\\Videos\\\\IMCS Training\\\\CustomerXML\\\\src\\\\main\\\\java\\\\resources\\\\CustomerFile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	static Customer unMarshall() {
		try {

			File file = new File("C:\\Users\\User\\Videos\\IMCS Training\\CustomerXML\\src\\main\\java\\resources\\CustomerSchema.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.toString());
			return customer;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
