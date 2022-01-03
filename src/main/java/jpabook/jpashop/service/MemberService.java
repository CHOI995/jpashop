package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 트랜잭션 안에서 변경하는 데이터는 트랜 잭셔널이 꼭 있어야 한다. javax spring 두가지가 존재한다.
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
		
	// 회원가입
	@Transactional
	public Long join(Member member) {
		
		validateDuplicateMember(member); // 중복 회원 검증
		memberRepository.save(member);
		
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		// EXCEPTION
		List<Member> findMembers = memberRepository.findByName(member.getName());
		
		if (!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
	// 회원 전체 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Member findOne(Long id) {
		return memberRepository.fineOne(id);
	}

}
