package kr.or.ddit.basic;

import java.io.IOException;
import java.net.InetAddress;

public class T01_InetAddressTest {
	public static void main(String[] args) throws IOException {
		//	InetAddress클래스 =>	IP 주소를 다루기 위한 클래스
		// 000.000.000.000 이게 이렇게 하는거야. 알겠니 앞에 마지막 배열은 호스트 주소, 앞에는 네트워크주소.//
		//	naver사이트의 ip주소 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name => "+ naverIp.getHostName());
		System.out.println("Host Address => "+ naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP 주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => "+localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => "+localIp.getHostAddress());
		System.out.println();
		
		// ip 주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}
}
