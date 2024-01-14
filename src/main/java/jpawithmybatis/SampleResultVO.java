package jpawithmybatis;

public class SampleResultVO {

	private static int resultCode = 0;
	
	// 1번
    private static final SampleResultVO sampleResultVO = new SampleResultVO();
    // 2번
    public static SampleResultVO getSampleResultVO() {
        return sampleResultVO;
    }
    
	public static int getResultcode() {
		return resultCode;
	}
	
	public static void setResultcode(int res) {
		resultCode = res;
	}
}
