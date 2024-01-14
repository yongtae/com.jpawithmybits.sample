package jpawithmybatis.jpasrc;

import java.util.List;

public interface MemberService {

	/**
     * Member 생성
     *
     * @param member
     * @return
     */
    public MemberEntity createMember(MemberEntity member) throws Exception;
    
    /**
     * Member List 조회
     * 
     * @return List<MemberEntity>
     */
    public List<MemberEntity> getMembers() throws Exception;

}
