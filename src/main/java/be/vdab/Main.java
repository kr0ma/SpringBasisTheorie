package be.vdab;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.vdab.gaming.Spelletje;
import be.vdab.restclient.CreateRestClientBeans;
import be.vdab.services.CreateServiceBeans;
import be.vdab.services.EuroService;

public class Main {
	public static void main(String[] args) throws IOException {
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("container.xml")) {
				System.out.println(context.getBean(Spelletje.class).getAantalVijanden());
		}
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CreateRestClientBeans.class, CreateServiceBeans.class)){
			System.out.println(context.getBean(EuroService.class).naarDollar(BigDecimal.valueOf(2)));
		}

		/*try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml")) {			
			System.out.println(context.getBean(EuroService.class).naarDollar(BigDecimal.valueOf(2)));
		}*/
		
		/*System.out.println(context.getBean(ClassA.class).getTelefoonNrHelpDesk());

		ClassA objectA = context.getBean(ClassA.class);
		System.out.println(objectA.getKoersenURL());
		System.out.println(objectA.getDefaultTaalEnLand().getDisplayName());
		System.out.println("Bestand bestaat: " + objectA.getImportData().exists());
		System.out.println(objectA.getDefaultBladRichting());
		System.out.println(objectA.getWebMasterEMailAdres());
		System.out.println(objectA.getWebsiteGestart());

		ClassB objectB = context.getBean(ClassB.class);
		System.out.println(objectB.getTelefoonNrHelpDesk());
		System.out.println(objectB.getAantalPogingenUpdateKlant());

		context.getBean("teller1", Teller.class).verhoog();
		context.getBean("teller1", Teller.class).verhoog();
		Teller teller2 = context.getBean("teller2", Teller.class);
		teller2.verhoog();
		context.getBean("teller2", Teller.class).verhoog();*/

	}
}
