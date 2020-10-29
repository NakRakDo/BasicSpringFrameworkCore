package kr.co.fastcampus.web;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

// ������Ĺ�� ��� ������ �ڿ� jar ������Ʈ �̸��� �ٰ� �׵ڿ� ��Ʈ ��ΰ� ����Ǵµ�
// ������Ĺ�� ��� /�� ���� ��Ʈ�̴�. �򰥸���
public class Main {
	public static void main(String[] args) throws LifecycleException {
		String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");

        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
        
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work -> ����  3.0 �̻���ʹ� web.xml�� �ʿ����.
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
        
        tomcat.getConnector(); // tomcat 9 �̻���ʹ� default �� ������ �ȵǾ��մ� �κ��̶� ���� ���ش�.
        tomcat.start();
        tomcat.getServer().await();
	}
}
