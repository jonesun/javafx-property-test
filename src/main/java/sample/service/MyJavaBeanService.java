package sample.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author jone.sun
 * @date 2020-11-23 13:59
 */
@Service
public class MyJavaBeanService {

    public String getVersion() {
        return System.getProperty("java.version");
    }

}
