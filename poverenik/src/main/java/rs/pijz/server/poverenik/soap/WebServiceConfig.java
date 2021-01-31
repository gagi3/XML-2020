package rs.pijz.server.poverenik.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
	
	@Bean(name = "obavestenje-soap")
	public DefaultWsdl11Definition defaultWsdl11DefinitionObavestenje(XsdSchema obavestenjeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ObavestenjePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.pijz.rs/obavestenje");
		wsdl11Definition.setSchema(obavestenjeSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "resenje-soap")
	public DefaultWsdl11Definition defaultWsdl11DefinitionResenje(XsdSchema resenjeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ResenjePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.pijz.rs/resenje");
		wsdl11Definition.setSchema(resenjeSchema);
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
	public XsdSchema obavestenjeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap/obavestenje-soap.xsd"));
	}
	
	@Bean
	public XsdSchema resenjeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap/resenje-soap.xsd"));
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
