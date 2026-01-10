package jpawithmybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import jpawithmybatis.jpasrc.IdsEntity;
import jpawithmybatis.jpasrc.IdsService;
import jpawithmybatis.jpasrc.MemberEntity;
import jpawithmybatis.jpasrc.MemberService;

@Controller
@SessionAttributes(types = ComDefaultVO.class)
public class SampleTestSrcControllerAPI {

	/**
	 * SampleService
	 */
	@Resource(name = "SampleService")
	private SampleService sampleService;

	@Resource(name = "MemberService")
	private MemberService memberService;

	@Resource(name = "IdsService")
	private IdsService idsService;

	/**
	 * jpa 기반, db 조회 확인
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/test_jpa.do")
	@ResponseBody
	public ResultVO get01() throws Exception {

		ResultVO resultVO = new ResultVO();
		HashedMap resultMap = new HashedMap();
		resultMap.put("url", "/sample/test_jpa.do");
		///////////////////////////////////

		MemberEntity memberEntity = MemberEntity.builder()
				.idsid(1)
				.name("이름").email("test@test.com").build();
		
		MemberEntity res = memberService.createMember(memberEntity);
		List<MemberEntity> searchList = memberService.getMembers();

		resultMap.put("createMember", res);
		resultMap.put("getMembers", searchList);

		////////////////////////////////////////////
		// mybatis에서 사용중인 ids 데이터 등록
		// /sample/test_mybatis.do 컨트롤러 메소드에서 ids 조회 확인

		IdsEntity idsEntity = IdsEntity.builder()
				.table_name("JPA에서 등록")
				.next_id(1)
				.build();
		IdsEntity res_ids = idsService.IdsInsert(idsEntity);
		resultMap.put("ids테이블 인서트", res_ids);
		
		///////////////////////////////////
		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}

	/**
	 * mybatis 기반, db 조회 확인
	 */
	@RequestMapping(value = "/sample/test_mybatis.do")
	@ResponseBody
	public ResultVO get02() {
		int cnt2 = 0;
		int cnt3 = 0;

		// 테스트 실행
		try {
			sampleService.sampleLogic();
			cnt2 = SampleResultVO.getSampleResultVO().getResultcode();
			
			sampleService.sampleLogic2();
			cnt3 = SampleResultVO.getSampleResultVO().getResultcode();
		} catch (Exception e) {
			// TODO: handle exception
			// 결과값 확인, 데이터는 롤백됨
			cnt2 = SampleResultVO.getSampleResultVO().getResultcode();
		}

		ResultVO resultVO = new ResultVO();

		HashedMap resultMap = new HashedMap();
		resultMap.put("url", "/sample/test_mybatis.do");
		resultMap.put("selectIdsCnt, IDS 개수", cnt2);
		resultMap.put("selectIdsTestCnt, IDS_TEST 개수", cnt3);

		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}
	
	/**
	 * mybatis 기반, db 조회 확인
	 */
	@RequestMapping(value = "/sample/test_mybatis_postgres.do")
	@ResponseBody
	public ResultVO get03() throws Exception {
		int cnt2 = 0;

		
		sampleService.sampleLogic3();
		cnt2 = SampleResultVO.getSampleResultVO().getResultcode();
	

		ResultVO resultVO = new ResultVO();

		HashedMap resultMap = new HashedMap();
		resultMap.put("url", "/sample/test_mybatis_postgres.do");
		resultMap.put("select test_users", cnt2);

		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}

}