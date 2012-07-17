/*
This file is part of the Polygraph bulk messaging framework
Copyright (C) 2012 Wolfgang Illmeyer

The Polygraph framework is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package com.illmeyer.polygraph.syslib;

import java.util.HashMap;
import java.util.Map;

import com.illmeyer.polygraph.core.interfaces.Module;
import com.illmeyer.polygraph.syslib.directives.BinaryPartDirective;
import com.illmeyer.polygraph.syslib.directives.TextPartDirective;

public class Syslib implements Module {

	@Override
	public void initialize() {
		System.out.println("Initializing Syslib");
	}

	@Override
	public Map<String, Object> createContext() {
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("binarypart", new BinaryPartDirective());
		result.put("textpart", new TextPartDirective());
		return result;
	}

	@Override
	public void destroy() {
	}

}
