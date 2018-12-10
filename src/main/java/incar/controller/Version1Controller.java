package incar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incar.handler.impl.html.HTMLHandler;
import com.incar.handler.impl.json.JSONHandler;
import com.incar.handler.impl.json.JSONReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created on 2018/12/6.
 */
@SuppressWarnings(value = "unchecked")
@RestController
@RequestMapping("/api/version")
public class Version1Controller {

    @RequestMapping(value = "/html", method = RequestMethod.GET)
    public String info(@RequestParam(value = "value",required = false) String value) {
        //调用jar接口
        String res1 = new HTMLHandler().request("小兰");

        return res1;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String infoNext(@RequestParam(value = "value",required = false) String value) {
        //调用jar接口
        ObjectMapper mapper = new ObjectMapper();
        String res2 = new JSONHandler(new JSONReader() {
            @Override
            public String toJson(Object o) {
                String value1 = null;
                try {
                    value1 = mapper.writeValueAsString(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return value1;
            }
        }).request("小兰");

        return res2;
    }

    @RequestMapping(value = "/wowHtml", method = RequestMethod.GET)
    public String infoHtml(@RequestParam(value = "value",required = false) String value) {
        //调用jar接口
        String res1 = new HTMLHandler().requestWow("小兰");

        return res1;
    }

    @RequestMapping(value = "/wowJson", method = RequestMethod.GET)
    public String infoJson(@RequestParam(value = "value",required = false) String value) {
        //调用jar接口
        ObjectMapper mapper = new ObjectMapper();
        String res2 = new JSONHandler(new JSONReader() {
            @Override
            public String toJson(Object o) {
                String value1 = null;
                try {
                    value1 = mapper.writeValueAsString(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return value1;
            }
        }).requestWow("小兰");

        return res2;
    }


}
