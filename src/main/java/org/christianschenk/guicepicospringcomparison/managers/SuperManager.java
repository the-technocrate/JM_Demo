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
package org.christianschenk.guicepicospringcomparison.managers;

import com.google.inject.Inject;

public class SuperManager {

	private final ComputationManager computationHelper;
	private final OutputManager1 manager1;
	private final OutputManager2 manager2;

	@Inject
	public SuperManager(final OutputManager1 manager1, final OutputManager2 manager2, final ComputationManager computationHelper) {
		this.computationHelper = computationHelper;
		this.manager1 = manager1;
		this.manager2 = manager2;
	}

	public void manage1() {
		this.computationHelper.doComputation();
		this.manager1.printAnswer();
	}

	public void manage2() {
		this.computationHelper.doComputation();
		this.manager2.printAnswer();
	}
}