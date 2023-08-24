package app.connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		DBConnect dbconnect = new DBConnect();
	}
}
