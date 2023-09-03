package lk.ijse.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 11:32 PM
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.pos.api")
public class WebAppConfig {
}
