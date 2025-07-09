package me.nahyung.springboot3_developer;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
//실패한 코드. 추후 보완 할 예정.
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void initDatabase() {
        // 트랜잭션 롤백이 적용되므로 매 테스트마다 DB가 비어있음
        memberRepository.save(new Member(null, "A"));
        memberRepository.save(new Member(null, "B"));
    }

    @Test
    @DisplayName("단건 조회 테스트")
    void testById() {
        Optional<Member> member = memberRepository.findAll().stream()
                .filter(m -> "A".equals(m.getName()))
                .findFirst();

        assertTrue(member.isPresent(), "멤버 A가 존재해야 한다.");
        assertEquals("A", member.get().getName(), "멤버의 이름은 A여야 한다.");
    }

    @Test
    @DisplayName("전체 조회 테스트")
    void testAll() {
        List<Member> allMembers = memberRepository.findAll();
        assertEquals(2, allMembers.size(), "멤버는 총 2명이어야 한다.");

        List<String> names = allMembers.stream()
                .map(Member::getName)
                .collect(Collectors.toList());

        assertTrue(names.contains("A"), "A 멤버가 포함되어야 한다.");
        assertTrue(names.contains("B"), "B 멤버가 포함되어야 한다.");
    }
}