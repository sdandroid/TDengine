package com.taosdata.jdbc.utils;

import java.io.IOException;

public class OSUtils {

  private static final String OS = System.getProperty("os.name").toLowerCase();

  public static boolean isWindows() {
	return (OS.contains("win"));
  }

  public static boolean isMac() {
	return (OS.contains("mac"));
  }

  public static boolean isLinux() {
	return (OS.contains("nux"));
  }

  public static void load() {
	String filenames = null;
	if (OSUtils.isWindows()) {
	  filenames = "/native/win/taos.dll";
	} else if (OSUtils.isLinux()) {
	  filenames = "/native/linux/taos.so";
	}
	try {
	  NativeUtils.loadLibraryFromJar(filenames); // during runtime. .DLL within .JAR
	} catch (IOException e1) {
	  throw new RuntimeException(e1);
	}

  }
}
