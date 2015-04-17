package com.googlecode.jmeter.plugins.webdriver.config.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kg.apc.jmeter.JMeterPluginsUtils;

import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.testelement.TestElement;

import com.googlecode.jmeter.plugins.webdriver.config.PhantomJsDriverConfig;

public class PhantomJsConfigGui extends WebDriverConfigGui implements ItemListener, FocusListener {

	private static final long serialVersionUID = 100L;
	JTextField phantomJsPath;
	JTextField phantomJsArguments;

	@Override
	public String getStaticLabel() {
		return JMeterPluginsUtils.prefixLabel("PhantomJS Driver Config");
	}

	@Override
	public String getLabelResource() {
		return getClass().getCanonicalName();
	}

	@Override
	protected JPanel createBrowserPanel() {
		final JPanel browserPanel = new VerticalPanel();
		final JPanel phantomJsPathPanel = new HorizontalPanel();

		final JLabel phantomJsPathLabel = new JLabel();
		phantomJsPathLabel.setText("PhantomJs path");
		phantomJsPathLabel.add(phantomJsPath);

		phantomJsPath = new JTextField();
		phantomJsPath.setEnabled(true);
		phantomJsPath.addFocusListener(this);
		phantomJsPathPanel.add(phantomJsPath);

		final JLabel phantomJsArgumentsLabel = new JLabel();
		phantomJsArgumentsLabel.setText("PhantomJs CLI arguments");
		phantomJsArgumentsLabel.add(phantomJsPath);

		phantomJsArguments = new JTextField();
		phantomJsArguments.setEnabled(true);
		phantomJsArguments.addFocusListener(this);
		phantomJsPathPanel.add(phantomJsArguments);

		browserPanel.add(phantomJsPathPanel);
		return browserPanel;
	}

	@Override
	protected String browserName() {
		return "PhantomJS";
	}

	@Override
	protected String getWikiPage() {
		return "PhantomJsDriverConfig";
	}

	@Override
	public TestElement createTestElement() {
		PhantomJsDriverConfig element = new PhantomJsDriverConfig();
		modifyTestElement(element);
		return element;
	}

	@Override
	public void modifyTestElement(TestElement element) {
		super.modifyTestElement(element);
		if (element instanceof PhantomJsDriverConfig) {
			PhantomJsDriverConfig config = (PhantomJsDriverConfig) element;
			config.setPhantomJsPath(phantomJsPath.getText());
			config.setPhantomJsCliArgs(phantomJsArguments.getText());
		}
	}

	@Override
	public void configure(TestElement element) {
		super.configure(element);
		if (element instanceof PhantomJsDriverConfig) {
			PhantomJsDriverConfig config = (PhantomJsDriverConfig) element;
			phantomJsPath.setText(config.getPhantomJsPath());
			phantomJsArguments.setText(config.getPhantomJsCliArgs());
		}
	}

	@Override
	protected boolean isProxyEnabled() {
		return true;
	}

	@Override
	protected boolean isExperimentalEnabled() {
		return true;
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}
