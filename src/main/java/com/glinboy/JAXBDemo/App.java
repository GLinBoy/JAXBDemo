package com.glinboy.JAXBDemo;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.glinboy.patient.Patient;

public class App 
{
    public static void main( String[] args )
    {
        try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			Patient patient = new Patient();
			patient.setId(230);
			patient.setName("GLinBoy");
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			System.out.println(writer.toString());
			
			Unmarshaller unmurshaller = context.createUnmarshaller();
			Patient patientResult = (Patient) unmurshaller.unmarshal(new StringReader(writer.toString()));
			
			System.out.println("---+> Name: " + patient.getName());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
