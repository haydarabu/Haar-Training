package old;

import java.io.File;
import java.util.Formatter;

import org.opencv.core.Rect;

public class FileManagerOld {

	private File negInfo, posInfo;
	private Formatter negFormatter, posFormatter;
	
	public FileManagerOld() {
		try {
			negInfo = new File("images/negative_info.dat");
			posInfo = new File("images/positive_info.dat");
			negFormatter = new Formatter(negInfo);
			posFormatter = new Formatter(posInfo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeNegImagePath(String path) {
		try {
			negFormatter.format("%s" + System.lineSeparator(), path);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("File \"" + negInfo.getAbsolutePath() + "\" could not be written to.");
		}
	}
	
	public void writePosImagePath(String path, int objects, Rect rect) {
		try {
			posFormatter.format("%s %s %s %s %s %s" + System.lineSeparator(), path, objects, rect.x, rect.y, rect.width, rect.height);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("File \"" + posInfo.getAbsolutePath() + "\" could not be written to.");
		}
	}
	
	public void closeFiles() {		
		negFormatter.close();
		posFormatter.close();
	}
}
