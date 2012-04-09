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

public aspect LoggingAspect {

	private pointcut logging() : execution(* ComparisonTest.*());

	before() : logging() {
		System.out.println("Running: " + thisJoinPoint.getSignature().getName() + "\n--------");
	}

	after() : logging() {
		System.out.println();
	}
}