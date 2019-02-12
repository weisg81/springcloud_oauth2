package pers.weisg.cloud.common.core.util;

import java.util.Date;
import java.util.UUID;

public class RandomUtils {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().toUpperCase();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}

	public static long getDateTime() {
		return new Date().getTime();
	}

}
