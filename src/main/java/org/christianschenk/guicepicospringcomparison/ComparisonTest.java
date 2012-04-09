/*
 * SpringGuiceComparison - Comparing Guice, Pico and Spring
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package org.christianschenk.guicepicospringcomparison;

import org.christianschenk.guicepicospringcomparison.managers.ComputationManager;
import org.christianschenk.guicepicospringcomparison.managers.OutputManager1;
import org.christianschenk.guicepicospringcomparison.managers.OutputManager2;
import org.christianschenk.guicepicospringcomparison.managers.SuperManager;
import org.christianschenk.guicepicospringcomparison.util.ComputationHelper;
import org.christianschenk.guicepicospringcomparison.util.OutputHelper;
import org.christianschenk.guicepicospringcomparison.util.output.LoggerOutput;
import org.christianschenk.guicepicospringcomparison.util.output.SystemOutOutput;
import org.junit.Test;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ComparisonTest {

	/*
	 * Guice
	 */
	@Test
	public void guice() {
		final Injector injector = Guice.createInjector(new GuiceBinderModule());
		final SuperManager mgr = injector.getInstance(SuperManager.class);
		mgr.manage1();
		mgr.manage2();
	}

	private final class GuiceBinderModule implements Module {
		public void configure(final Binder binder) {
			binder.bind(OutputManager1.class).toInstance(new OutputManager1(new OutputHelper(new SystemOutOutput())));
			binder.bind(OutputManager2.class).toInstance(new OutputManager2(new OutputHelper(new LoggerOutput())));
		}
	}

	/*
	 * PicoContainer
	 */
	@Test
	public void picocontainer() {
		final MutablePicoContainer pico = new DefaultPicoContainer();
		pico.registerComponentImplementation(SuperManager.class);
		pico.registerComponentInstance(new OutputManager1(new OutputHelper(new SystemOutOutput())));
		pico.registerComponentInstance(new OutputManager2(new OutputHelper(new LoggerOutput())));
		pico.registerComponentImplementation(ComputationManager.class);
		pico.registerComponentImplementation(ComputationHelper.class);

		final SuperManager mgr = (SuperManager) pico.getComponentInstance(SuperManager.class);
		mgr.manage1();
		mgr.manage2();
	}

	/*
	 * Spring
	 */
	@Test
	public void spring() {
		final BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		final SuperManager mgr = (SuperManager) factory.getBean("SuperManager");
		mgr.manage1();
		mgr.manage2();
	}
}