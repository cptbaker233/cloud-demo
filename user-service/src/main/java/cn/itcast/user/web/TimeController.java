package cn.itcast.user.web;

import cn.itcast.user.config.PatternConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
//@RefreshScope
public class TimeController {

//    @Value("${pattern.dateformat}")
//    private String pattern;
    @Autowired
    PatternConfig patternConfig;

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public String now() {
        System.out.println(patternConfig.getDateformat());
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternConfig.getDateformat()));
    }

}
