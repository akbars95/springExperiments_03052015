package com.mtsmda.springCore.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by MTSMDA on 15.05.2015.
 */
@Configuration
@Import(value = {ConfigurationJava.class, ConfigurationJavaPerson.class})
public class AppJavaConfig {
}
