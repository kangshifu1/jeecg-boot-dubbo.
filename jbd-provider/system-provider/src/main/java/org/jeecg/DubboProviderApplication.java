package org.jeecg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class DubboProviderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   {
        return application.sources(DubboProviderApplication.class);
    }

    public static void main(String[] args) {
        try {

            ConfigurableApplicationContext application = SpringApplication.run(DubboProviderApplication.class, args);
            Environment env = application.getEnvironment();
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path");
            log.info("\n----------------------------------------------------------\n\t" +
                    "Application Jeecg-Boot is running! Access URLs:\n\t" +
                    "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                    "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                    "swagger-ui: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                    "----------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    



    }
}
