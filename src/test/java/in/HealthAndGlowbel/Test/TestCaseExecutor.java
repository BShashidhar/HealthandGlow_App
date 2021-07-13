package in.HealthAndGlowbel.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import in.HealthAndGlowbel.TestController.TestHealthAndGlowbleController;
import in.HealthAndGlowbel.TestDao.TestDAOLayer;
import in.HealthAndGlowbel.TestModel.TestModelValidation;
import in.HealthAndGlowbel.TestService.TestServiceLayer;
/**
 * @author B Shashidhar
 *
 * 
 */
public class TestCaseExecutor {
	@Test
	public void test() {
		//fail("Not yet implemented");
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		Result result = junit.run(TestHealthAndGlowbleController.class);
		try {
			resultControllerReport(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result = junit.run(TestDAOLayer.class);
		try {
			resultDAOLayerReport(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result = junit.run(TestModelValidation.class);
		try {
			resultModelValidationReport(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result = junit.run(TestServiceLayer.class);
		try {
			resultServiceLayerReport(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void resultControllerReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("Result_controller.txt"), res, "ISO-8859-1");
	}
	public static void resultDAOLayerReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("Result_dao.txt"), res, "ISO-8859-1");
	}
	public static void resultModelValidationReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("Result_entity.txt"), res, "ISO-8859-1");
	}
	public static void resultServiceLayerReport(Result result) throws IOException {
		System.out.println("Finished... Result: Failures: " +
				result.getFailureCount() + ". Ignored: " +
				result.getIgnoreCount() + ". Tests run: " +
				result.getRunCount() + ". Time: " +
				result.getRunTime() + "ms." );
		String res = "";
		res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
		FileUtils.writeStringToFile(new File("Result_service.txt"), res, "ISO-8859-1");
	}
}
