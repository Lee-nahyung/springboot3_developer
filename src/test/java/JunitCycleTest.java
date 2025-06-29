import org.junit.jupiter.api.*;

public class JunitCycleTest {
    @BeforeAll
    static void beforeAll() { //전체 테스트를 시작하기 전 한 번만 실행. 그리고 테스트 클래스의 인스턴스가 만들어지기 전에 호출되어야 하므로 static으로 선언
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll
    static void afterAll() { //전체 테스트를 마치기 전 1회만 실행
        System.out.println("@AfterAll");
    }

    @AfterEach
    public void afterEach(){ //테스트 케이스를 종료하기 전마다 실행
        System.out.println("@AfterEach");
    }
}
