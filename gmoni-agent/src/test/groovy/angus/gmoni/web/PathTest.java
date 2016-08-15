package angus.gmoni.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathTest {

		public static void main(String[] args) {
			Path path = Paths.get("");
			System.out.println(Files.exists(path));
			System.out.println(path.getFileName().toString());
		}
}
