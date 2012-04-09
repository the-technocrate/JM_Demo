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

import org.christianschenk.guicepicospringcomparison.util.ComputationHelper;

import com.google.inject.Inject;

public class ComputationManager {

	private final ComputationHelper computationHelper;

	@Inject
	public ComputationManager(final ComputationHelper computationHelper) {
		this.computationHelper = computationHelper;
	}

	public void doComputation() {
		// do something...
		this.computationHelper.performWeirdComputation();
		// do something else...
	}
}