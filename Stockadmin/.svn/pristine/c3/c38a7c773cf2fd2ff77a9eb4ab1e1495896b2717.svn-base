package com.isoft.stock.stockutils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataUtil {

	public final static String md5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];

			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}

	}

	public static Serializable deepCope(Serializable object) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			byte[] bytes = byteArrayOutputStream.toByteArray();
			byteArrayInputStream = new ByteArrayInputStream(bytes);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Serializable cope;
			try {
				cope = (Serializable) objectInputStream.readObject();
				return cope;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("类没有发现异常");
				throw new RuntimeException("类没有发现异常");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MD5：异常");
			throw new RuntimeException("MD5：异常");
		} finally {
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("MD5：byteArrayOutputStream关闭异常");
					throw new RuntimeException("MD5：byteArrayOutputStream关闭异常");
				}
			}
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					System.out.println("MD5：objectOutputStream关闭异常");
					throw new RuntimeException("MD5：objectOutputStream关闭异常");
				}
			}

			if (byteArrayInputStream != null) {
				try {
					byteArrayInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("MD5：byteArrayInputStream关闭异常");
					throw new RuntimeException("MD5：byteArrayInputStream关闭异常");
				}
			}
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("MD5：objectInputStream关闭异常");
					throw new RuntimeException("MD5：objectInputStream关闭异常");
				}
			}
		}

	}

	public static boolean isVludate(String nameSpace) {
		if (nameSpace == null || nameSpace.length() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
