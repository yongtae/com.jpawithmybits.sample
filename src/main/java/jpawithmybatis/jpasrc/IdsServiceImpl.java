package jpawithmybatis.jpasrc;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service("IdsService")
@RequiredArgsConstructor
public class IdsServiceImpl implements IdsService{
	

	private final IdsRepository idsRepository;

	@Override
	public IdsEntity IdsInsert(IdsEntity idsEntity) throws Exception {
		// TODO Auto-generated method stub
		IdsEntity res = idsRepository.save(idsEntity);
		return res;
	} 
	
    
    
}
