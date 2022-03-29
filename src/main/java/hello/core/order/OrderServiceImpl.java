package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  // 고정할인, 문제점: Impl이 Fix구현클래스에 의존 -> DIP위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 새로운 할인정책 적용, 문제점: Impl도 수정해야 함 -> OCP위반
    private DiscountPolicy discountPolicy;  // DIP를 지키기 위해 인터페이스에만 의존하도록 설계 변경, 문제점: nullPointException 발생

    /*
    * 클라이언트로부터 주문 요청이 오면
    * 회원 정보 조회
    * 해당 정보에 따라 할인 정책 조회
    * 상품가격 - 할인가격 = 최종 금액
    * 이외 회원 정보 등 최종 생성된 주문을 반환
    * */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return  new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
