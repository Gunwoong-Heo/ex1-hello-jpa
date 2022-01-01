package hellojpa;

public class ValueMain {

    public static void main(String[] args) {

/*
        int a = 10;
        int b = a;  // a의 값이 b로 복사가 됨

        a = 20;  // a에 20을 할당해도, 이미 b는 기존의 a의 값이 복사가 되어버렸기 때문에 b값의 변화는 없다.

        System.out.println("a = " + a);  // 출력결과 : a = 20
        System.out.println("b = " + b);  // 출력결과 : b = 10
*/

/*
        Integer a = new Integer(10);
        Integer b = a;  // a의 참조 값이 복사가 됨, 하지만 변경할 방법은 없다.(그래서 안전)
*/

        int a = 10;
        int b = 10;

        System.out.println("a == b : " + (a == b));

        Address address1 = new Address("city", "street", "100");
        Address address2 = new Address("city", "street", "100");

        System.out.println("address1 == address2 : " + (address1 == address2));
        System.out.println("address1 equals address2 : " + (address1.equals(address2))); // override 하기전에는 false가 반환 equals를 override해줘야 true 반환

    }
}