package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //생성자 주입 전 코드
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //생성자 주입(memberrepository 인터페이스만 의존하도록 변경)
    public MemberServiceImpl(MemberRepository memberRepository) {this.memberRepository = memberRepository;}


    public void join(Member member) {memberRepository.save(member);}
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}