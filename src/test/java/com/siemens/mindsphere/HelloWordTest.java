package com.siemens.mindsphere;

import static org.junit.Assert.assertEquals;

import com.siemens.mindsphere.jmokit.JmokitDemo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import mockit.*;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

/**
 * @author Zhang Xiao
 * @date 9/3/2018 15:37
 */

@RunWith(JMockit.class)
public class HelloWordTest {

    @Mocked JmokitDemo obj;//用@Mocked标注的对象，不需要赋值，jmockit自动mock

    private ExecutorService executor;

//    @Before
//    public void initThread() {
//        executor = new MockUp<ThreadPoolExecutor>() {
//            @Mock
//            public void execute(Runnable command) {
//                command.run();
//            }
//        }.getMockInstance();
//    }

    @Test
    public void testHello() {
        new Expectations() {//录制预期模拟行为
            {
                obj.hello("Zhangsan");
                result = "Hello Zhangsan";
                //也可以使用：result = "Hello Zhangsan";
            }
        };
        assertEquals("Hello Zhangsan", obj.hello("Zhangsan"));//调用测试方法
        new Verifications() {//验证预期Mock行为被调用
            {
                obj.hello("Hello Zhangsan");
                times = 1;
            }
        };
    }
}
