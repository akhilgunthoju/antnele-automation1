package automation;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

	private int retryCount = 0;
    private final int maxRetryCount = 2; // Number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + " (Attempt " + retryCount + ")");
            return true;
        }
        return false;
    }
}
