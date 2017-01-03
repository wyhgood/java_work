package com.travel.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.Inflater;

public class ZipTools {

	public static String decompress(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		byte[] inputBytes = bytes;

		byte[] outputBytes = new byte[0];

		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(inputBytes);

		ByteArrayOutputStream o = new ByteArrayOutputStream(inputBytes.length);
		try {
			byte[] buf = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			outputBytes = o.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		decompresser.end();
		return new String(outputBytes);
	}

	public static String decompress(String data, String charsetName) {
		if (data == null) {
			return null;
		}
		try {
			byte[] inputBytes = data.getBytes(charsetName);

			byte[] outputBytes = new byte[0];

			Inflater decompresser = new Inflater();
			decompresser.reset();
			decompresser.setInput(inputBytes);

			ByteArrayOutputStream o = new ByteArrayOutputStream(inputBytes.length);
			try {
				byte[] buf = new byte[1024];
				while (!decompresser.finished()) {
					int i = decompresser.inflate(buf);
					o.write(buf, 0, i);
				}
				outputBytes = o.toByteArray();
			} catch (Exception e) {
				// output = inputBytes;
				e.printStackTrace();
				return data;
			} finally {
				try {
					o.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			decompresser.end();
			return new String(outputBytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
