package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//싱글톤 패턴은 클라이언트의 요청이 왔을 때마다 객체를 생성하는게 아니라 이미 만들어진 객체를 공유해 사용하기때문에 효율적인 메모리 사용이 가능하다.
//싱글톤 패턴은 클래스의 인스턴스가 딱 1개만 생성되는것을 보장하는 디자인 패턴이다. 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야한다.
public class SingletonService {
    //static 영역에 생성된 유일한 객체
    private static final SingletonService instance = new SingletonService();

    //public으로 두어 객체 인스턴스가 필요하면 이 메소드를 통해서만 조회가 가능하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언 -> 외부에서 new 키워드를 사용한 객체 생성을 하지 못하게 막음.
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
