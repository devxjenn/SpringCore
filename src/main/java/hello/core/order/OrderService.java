package hello.core.order;

public interface OrderService {
    // return 으로 주문 결과(Order)를 반환한다.
    Order createOrder(Long memberId, String item, int itemPrice);

}
