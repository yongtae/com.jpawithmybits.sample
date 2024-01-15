package jpawithmybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.let.cop.com.service.impl.EgovUserInfManageDAO;


@Service("SampleService")
public class SampleServiceImpl implements SampleService {

	@Autowired
    private SqlSessionFactory sqlSessionFactory;
	
	@Resource(name = "EgovUserInfManageDAO")
    private EgovUserInfManageDAO userInfDAO;

	
	@Transactional
	@Override
	public void sampleLogic() throws Exception {
		
		int cnt2 = userInfDAO.selectIdsCnt();
		System.out.println("userInfDAO.selectIdsCnt()---"+ cnt2);
//		값 저장
		SampleResultVO.getSampleResultVO().setResultcode(cnt2);
		
	}
	
	@Transactional
	@Override
	public void sampleLogic2() throws Exception {
		
		int cnt2 = userInfDAO.selectIdsTestCnt();
		System.out.println("userInfDAO.selectIdsTestCnt()---"+ cnt2);
//		값 저장
		SampleResultVO.getSampleResultVO().setResultcode(cnt2);
		
	}


}
