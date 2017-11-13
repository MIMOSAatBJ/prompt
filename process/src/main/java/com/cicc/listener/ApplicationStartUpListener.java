package com.cicc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 1）实现ApplicationListener重写onApplicationEvent方法
 * 2)实现ServletContextListener
 * @author killer
 *
 */
public class ApplicationStartUpListener implements ServletContextListener {
//    private Logger logger=Logger.getLogger(getClass());

//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		ApplicationContext context = event.getApplicationContext();
//		if (context.getParent() == null) {
//			for (Entry<String, MessageHandle> ez : context.getBeansOfType(MessageHandle.class).entrySet()) {
//				System.out.println(ez.getValue().getClass());
//			}
//		}
//	}

    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        if (context.getParent() == null) {
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
