package peaner.yier.utils.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Peaner
 * @time: 2021/3/4
 * @description:
 */
public class TestProperties {

    @Test
    public void testProperties() {
        ApplicationContext context = new ClassPathXmlApplicationContext("properties.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }

}
