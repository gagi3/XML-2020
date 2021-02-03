package rs.pijz.server.sluzbenik.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
	
	@Bean(name = "zahtev-soap")
	public DefaultWsdl11Definition defaultWsdl11DefinitionZahtev(XsdSchema zahtevSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ZahtevPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.pijz.rs/zahtev");
		wsdl11Definition.setSchema(zahtevSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "zalba-cutanje-soap")
	public DefaultWsdl11Definition defaultWsdl11DefinitionZalbaCutanje(XsdSchema zalbaCutanjeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ZalbaCutanjePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.pijz.rs/zalba-cutanje");
		wsdl11Definition.setSchema(zalbaCutanjeSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "zalba-odluka-soap")
	public DefaultWsdl11Definition defaultWsdl11DefinitionZalbaOdluka(XsdSchema zalbaOdlukaSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ZalbaOdlukaPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.pijz.rs/zalba-odluka");
		wsdl11Definition.setSchema(zalbaOdlukaSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema zahtevSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap/zahtev-soap.xsd"));
	}
	
	@Bean
	public XsdSchema zalbaCutanjeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap/zalba-cutanje-soap.xsd"));
	}
	
	@Bean
	public XsdSchema zalbaOdlukaSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap/zalba-odluka-soap.xsd"));
	}

}
