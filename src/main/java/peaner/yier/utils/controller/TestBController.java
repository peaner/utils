package peaner.yier.utils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import peaner.yier.utils.TestAService;

/**
 * @author: Peaner
 * @time: 2020/12/13
 * @description:
 */
@Controller
public class TestBController {

    public static String HOST_URL = "DomainUtil.H5ProtocolDomain";

    @Autowired
    private TestAService testAService;

    @GetMapping("/test/b")
    public void testB() {
        for (int i = 0; i < 100000; i++) {
            testAService.testA();
        }
    }


}
