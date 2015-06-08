package edu.wfu.inotado.api;

public class WakeUtils {

	private static WakeUtils instance;

	private WakeUtils() {
	}

	public static WakeUtils getInstance() {
		if (instance == null) {
			instance = new WakeUtils();
		}
		return instance;
	}

	/**
	 * Pass in a set of strings that are used to create a URL
	 * 
	 * @param strs
	 * @return
	 */
	public String getUrl(String... strs) {
		StringBuilder sbd = new StringBuilder();
		for (String s : strs) {
			sbd.append(s).append("/");
		}
		return sbd.toString();
	}

}
