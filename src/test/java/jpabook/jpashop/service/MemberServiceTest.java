package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Autowired EntityManager em;
	
	@Test
	@Rollback(false)
	void 회원가입() throws Exception {
		// given
		Member member = new Member();
		member.setName("kim");
		System.out.println(member.getName());

		// when
		Long savedId = memberService.join(member);
		
		// then
		em.flush();
		assertEquals(member, memberRepository.fineOne(savedId));
	}

	@Test
	public void 중복_회원_예외() throws Exception {
		// given
		Member member1 = new Member();
		member1.setName("kim");
		
		Member member2 = new Member();
		member2.setName("kim");
		
		// when
		
		assertThrows(IllegalStateException.class, () -> {
			memberService.join(member1);
			memberService.join(member2);			
		});
		// then
	}

}
