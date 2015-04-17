package com.googlecode.jmeter.plugins.webdriver.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJsDriverConfig extends WebDriverConfig<PhantomJSDriver> {
	private static final long serialVersionUID = 100L;

	Capabilities createCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, createProxy());
		capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, getPhantomJsCliArgs());
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhantomJsPath());

		return capabilities;
	}

	public String getPhantomJsCliArgs() {
		return getPropertyAsString(PhantomJSDriverService.PHANTOMJS_CLI_ARGS);
	}

	public void setPhantomJsCliArgs(String arguments) {
		setProperty(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, arguments);
	}

	public String getPhantomJsPath() {
		return getPropertyAsString(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY);
	}

	public void setPhantomJsPath(String path) {
		setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, path);
	}

	@Override
	protected PhantomJSDriver createBrowser() {
		return new PhantomJSDriver(createCapabilities());
	}
}
