package com.ailk.tess.util;

import java.sql.Timestamp;


public class TessUtils {

	public static Timestamp getSysTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
