package jpawithmybatis.jpasrc;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service("MemberService")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	

	private final MemberRepository memberRepository; 
	
	/**
     * Member 생성
     *
     * @param member
     * @return
     */
    public MemberEntity createMember(MemberEntity member) {
    	MemberEntity savedMember = memberRepository.save(member);  // JpaRepository에서 제공하는 save() 함수
        return savedMember;
    }
    
    
    /**
     * Member List 조회
     * 
     * @return List<MemberEntity>
     */
    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();  // JpaRepository에서 제공하는 findAll() 함수
    }
	
}
