package lk.ijse.pos.config;

import lk.ijse.pos.api.CustomerController;
import lk.ijse.pos.exception.GlobalExceptionHandler;
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
@ComponentScan(basePackageClasses = {CustomerController.class, GlobalExceptionHandler.class})
public class WebAppConfig {
}
