package hust.soict.itep.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "opera.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
//		Path x = Paths.get(filename);
//		System.out.println(x.toAbsolutePath());
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
//		StringBuilder outputStringBuilder = new StringBuilder();
		for(byte b: inputBytes) {
			outputString += (char) b;
//			outputStringBuilder.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
