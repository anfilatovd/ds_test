package common;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {
	public ExtendedFieldDecorator(ElementLocatorFactory factory) {
		super(factory);
	}

	@Override
	public Object decorate(ClassLoader loader, Field field) {
			ElementLocator locator = factory.createLocator(field);
			if (locator == null) {
				return null;
			}
			try {
				Constructor<?>[] constructors = field.getType().getConstructors();
				return constructors[0].newInstance(proxyForLocator(loader, locator));
			}
			catch (Exception e) {
				//ignored
			} 
		return super.decorate(loader, field);
	}
}