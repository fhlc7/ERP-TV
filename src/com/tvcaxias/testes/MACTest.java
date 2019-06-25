package com.tvcaxias.testes;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MACTest {

	public static void main(String[] args) {
		
		try {

			InetAddress ia = InetAddress.getLoopbackAddress();
			System.out.println(ia.getHostAddress());

			for (InetAddress string : InetAddress.getAllByName("DESKTOP-55DUIF2")) {
				System.out.println(string);
			}
			
			System.out.println(obterMac());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static StringBuffer obterMac() throws Exception {
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		StringBuffer sb = new StringBuffer();
		while (en.hasMoreElements()) {
			NetworkInterface ni = en.nextElement();
			byte bs[] = ni.getHardwareAddress();
			if (ni.isUp() && bs != null && ni.getName().indexOf("eth") > -1) {
				boolean doispontos = false;
				for (byte parte : bs) {
					if (doispontos) sb.append(":");
					doispontos = true;
					sb.append(byteToHexadecimal(parte));
				}
				break;
			}
		}
		return sb;
	}
	
	private static StringBuilder byteToHexadecimal(byte b) {
		StringBuilder sb = new StringBuilder();
		return sb.append(String.format("%02X", b));
	}
	
}
