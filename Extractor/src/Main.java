
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException {

        ArrayList<String> al = new ArrayList<String>();
        /*
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-aspects-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-beans-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-context-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-core-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-expression-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-instrument-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-instrument-tomcat-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-jdbc-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-jms-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-messaging-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-orm-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-oxm-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-test-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-tx-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-web-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-webmvc-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-webmvc-portlet-4.2.5.RELEASE.jar");
        al.add("/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/spring-framework/libs/spring-websocket-4.2.5.RELEASE.jar");
        */

        String root = "/Users/markusspringer/Hagenberg/SWE Programmierung/UE5/";
        for(String argumument : args) {
            al.add(root+"root");
        }

        Analyzer a = new Analyzer();

        TreeMap tm = a.analyze(al);

        PackageMetrics pm = new PackageMetrics();
        pm.setTreeFrom(tm, "org");


        pm.analyzePackage();

        pm.printMetrics();

    }

}