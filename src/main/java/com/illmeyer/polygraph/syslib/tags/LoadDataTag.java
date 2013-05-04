/*
This file is part of the Polygraph bulk messaging framework
Copyright (C) 2013 Wolfgang Illmeyer

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

package com.illmeyer.polygraph.syslib.tags;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import lombok.Getter;

import com.illmeyer.polygraph.template.BodyExistence;
import com.illmeyer.polygraph.template.PolygraphEnvironment;
import com.illmeyer.polygraph.template.PolygraphTag;
import com.illmeyer.polygraph.template.PolygraphTemplateException;
import com.illmeyer.polygraph.template.TagInfo;
import com.illmeyer.polygraph.template.TagParameter;

@TagInfo(name="loaddata",nestable=false,body=BodyExistence.FORBIDDEN)
public class LoadDataTag implements PolygraphTag {
	
	@TagParameter(optional=true) @Getter
	private String url;

	@TagParameter(optional=true) @Getter
	private String vfs;

	@Override
	public void execute(PolygraphEnvironment env) throws IOException {
		// TODO: Check if IOException comes from URL stream or not
		if ((url==null && vfs==null) || (url!=null && vfs != null))
			throw new PolygraphTemplateException("Exactly one of the parameters 'url' and 'vfs' must be specified");
		
		BinaryPartTag bp = env.requireParentTag(BinaryPartTag.class);

		if (url!=null) {
			URL u = new URL(url);
			InputStream is = u.openStream();
			bp.getPart().setMessage(IOUtils.toByteArray(is));
			is.close();
		}
		
		if (vfs!=null) {
			// TODO
		}
	}

}
