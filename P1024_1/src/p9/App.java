package p9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {
    public static void main(String[] args) {
        Class clazz = AAA.class;
    }
}

class AAA {
    int a;
    int b;
    
    @HelloWorld(7)
    public void test1() {}
    @HelloWorld(qwer=3, name="test2", value = 8)
    public void test2() {}
}

// 어노테이션 정의 - 정의 부분은 그다지 신경 안 써도 됨
// @ metadata
// 자바 컴파일러에서 만든 클래스파일에도 메타데이터를 붙인다?
// @Retention 어노테이션은 해당 어노테이션의 정보가 언제까지 유지될 것인지를 지정합니다. 여기서는 runtime까지
// 만약 런타임에 제거하고 싶다면, @Retention(RetentionPolicy.SOURCE)를 사용해야 합니다. RetentionPolicy.CLASS
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) 
@interface HelloWorld {
    int value() default 0;
    int qwer() default 0;
    String name() default "야호";
}