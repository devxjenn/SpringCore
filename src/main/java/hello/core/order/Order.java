package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;  // 주문서의 아이템 가격
    private int discountPrice;  // 주문서의 할인된 가격

    // 주문 후 할인까지 모두 완료되고 생성되는 객체
    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    // 비즈니스 계산 로직
    public int calculatePrice(){
        // 최종 계산된 금액
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        // 객체를 출력하면 해당 toString()에서 모두 출력해줌
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
        // 만약 order 라는 객체 자체를 출력하면, 그 객체에 있는 toString이 호출됨
        //System.out.println("order = " + order);
    }
}
