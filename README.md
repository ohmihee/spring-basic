# spring boot
: 스프링 부트는 웹서버를 손쉽게 구축할 수 있도록 여러 편리한 기능을 제공해주는 프레임워크이다.

# 스프링 빈을 등록하는 두 가지 방법
## Q) 빈(Bean)이란?
1. 컴포넌트 스캔을 통한 자동 의존관계 설정 방식
위의 방식은 어노테이션 등을 사용하는 방식을 의미한다.
ex) 
@Controller
public class MemberController {
    private MemberService memberService;
}
2. 자바 코드를 통해 직접 스프링 빈을 등록하는 방식



## gradle
: gradle은 Groovy를 기반으로 한 빌드 도구로 빌드, 테스트, 배포 등을 자동화하였다.
- Projects
: gradle에서 빌드되는 것을 의미한다. 프로젝트는 root directory에 위치한 build.gradle이라는 이름을 가진 build scripts를 통해 프로젝트의 빌드가 이루어진다.
- Build 단계

- tasks
## 파일 정보
* init.gradle
: 빌드시에 가장 먼저 실행되는 파일로, 프로젝트 실행 환경 설정과 사용자 정보의 내용을 담고 있다.
* settings.gradle
: gradle은 한 프로젝트에 하위의 여러개의 프로젝트를 둘 수 있는데, 이때 settings.gradle은 root프로젝트와 하위 프로젝트에 대해 설정할 수 있도록 해주는 파일이다.
때문에 한 디렉토리에서 여러 프로젝트를 빌드하는 경우에는 반드시 settings.gradle파일을 root 디렉토리 경로에 위치하고 있어야 한다.이 때 settings.gradle 파일은 반드시 root project에 위치하여야 한다. ( settings.gradle 파일이 존재하지 않는 경우에 gradle은 자동으로 single project로 인식하고 빌드한다. )
ex) sttings.gradle 파일
rootProject.name = 'rootProject'
include 'subProject'

* application.properties(or application.yml)
: 파일은 데이터베이스 설정 등 프로젝트 환경 관련 설정을 담당하는 파일이다.
* build.gradle 
: 라이브러리 파일 등 빌드 관련 설정을 해주는 파일이다. 해당 파일은 plugins, dependencies, repository 등에 대한 정보를 담고 있다.
allprojects{}
configurations.all{}
resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
def 
: 선언하는 것인 듯 한다.
subprojects{}
mavenCentral()
compileJava.options.encoding = ''

# Q) 서비스를 별도로 구분하여 두는 이유?
: 반복적으로 사용되는 기능에 대하여 컨트롤러가 아닌 별도의 서비스 파일을 생성하여 로직을 작성함으로써 반복적인 코드를 줄이기 위함이다.
예를 들어 사용자 정보를 가져오는 기능이 게시판 컨트롤러와 구매 컨트롤러 모두에 존재한다고 했을 때 각각 컨트롤러 파일에 반복적인 코드를 작성하는 것보다, 서비스 파일에 작성 후 각 컨트롤러에서 해당 서비스를 호출하여 사용하는 것이 더욱 효율적이다.
또한 보안적인 측면에서도 컨트롤러에서 데이터베이스에 직접 접근하도록 하는 것보다 서비스를 통해 접근하도록 하는 것이 더욱 안전하다.

# Q) 자바 타입에서 소문자와 대문자의 차이?
기본형 문자 타입은 소문자로 시작하며, 참조형 문자 타입은 클래스로써 대문자로 시작한다.

# JPA(= Java Persistence API )
: 자바에서 데이터베이스로의 접근을 편리하게 도와주는 인터페이스 모음이다. 
~ repository 파일은 데이터베이스 접속시 이용되는 메서드들을 정의한 인터페이스 파일이다.
~ Hibernate(하이버네이트)sms JPA를 구현한 실제 클래스의 하나이다.

# Entity
: 프로젝트에서 데이터베이스에 접근 시 테이블과 매핑을 위해 사용되는 자바 클래스 파일이다. entity 클래스의 경우에는 @Setter 어노테이션을 설정해주기보다는 @Builder를 사용할 것이 권장된다.

# annonation
- @Controller
- @ResponseBody
: 해당 경로에 요청시 String 형태로 결과값을 반환할 수 있도록 해주는 어노테이션이다.
해당 어노테이션 없이 문자열을 반환하는 경우, 해당 문자열과 일치하는 파일명의 템플릿 파일을 찾아 반환하는데, 해당 문자열과 동일한 이름의 텟플림 파일이 존재하지 않는 경우 에러가 발생한다.
- @Autowired
: final이 붙은 필드에 해당 어노테이션 사용자 스프링이 자동으로 의존성 주입을 하여 준다.
- @RequiredArgsConstructor
: 클래스에 사용하며, final이 붙은 필드의 경우에 자동으로 생성자를 만들어준다.
- @Bean
- @Document
: 어노테이션 정보가 javadoc으로 작성된 문서에 포함되도록 해준다.
- @Value()
: property 값을 읽을 수 있다.(application.properties 또는 application.yml 파일에 설정해 둔 내용을 읽을 수 있다.)
@Value로 가져온 값은 변수에 할당하여 사용할 수 있다.
ex) 
@Value("${spring.database.url}")
private String dbUrl;
- @Service 
: 해당 클래스가 서비스 클래스임을 알리는 어노테이션이다.
- @Configuration
: 해당 파일이 스프링의 환경설정 파일임을 알리는 어노테이션이다.
- @EnableWebSecurity
ex)
@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests().requestMatchers(
        new AntPathRequestMatcher("/**")).permitAll()
        ;
      return http.build();
   }
}

# dependency
- BCryptPasswordEncoder
: Bcrypt 해싱 함수를 이용하여 암호화하여 준다.

## config 파일을 통한 bean 설정
ex)
@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests().requestMatchers(
        new AntPathRequestMatcher("/**")).permitAll()
        ;
      return http.build();
   }

   @Bean
   PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
   }
}

## @JsonInclude()
- @JsonInclude(JsonInclude.Include.NON_NULL) :  null인 데이터를 제외하고 json 데이터를 생성하여 준다.
- @JsonInclude(JsonInclude.Include.Always) : 기본값으로 모든 데이터를 json데이터로 변환하여 준다.
- @JsonInclude(JsonInclude.Include.NON_EMPTY) : null 제외, map의 isEmpty가 true이면 제외, 배열이 비어있으면 제외, 빈 문자열 ""이면 제외
- @JsonPeroperty : key를 매핑시켜줄 때 사용된다.

# memory area
- heap
: 참조형(reference type) 데이터 타입으로 선언한 변수는 heap 메모리 공간에 할당되고, heap 영역의 메모리 주소값은 stack에 저장된다.(기본형은 stack area에 값 자체가 저장된다.)
heap영역은 가비지 컬렉터를 통해 참조되지 않는 필드의 경우에는 해당 공간에 할당된 메모리가 해제된다.
- static
: 전역변수와 static이 붙은 필드나 메서드가 할당되는 영역이다. static은 프로그램의 시작부터 프로그램의 종료 시점까지 메모리에 유지되며, 프로그램 종료 시에 메모리에서 해제된다.
static 메모리가 차지하는 공간은 프로그램 로드시에 결정되며, 프로그램 컴파일 시간에 많은 영양을 주는 것은 static 메모리이다.
- stack
: 지역변수와 일반 메서드가 stack area에 할당되고, 참조형 타입의 경우에는 값은 heap에 저장하고, 주소값은 stack에 저장한다.
stack area는 LIFO의 구조이다.
# etc
- static
: static으로 선언된 필드나 메서드는 static 영역에 데이터가 올라가서 프로젝트 전역에서 해당 데이터가 공유된다. 때문에 static이 붙은 경우 인스턴스 생성없이 클래스명을 통해 접근한다.
- String...
[타입]... 해당 인자가 몇 개오 오는지 모르는 경우에 사용된다. 즉, String...은 해당 매개변수를 1개로 받을 수 도 있고, 2개 이상으로 받을 수도 있음을 의미한다.
- BeanUtils.copyProperties(Object [원본객체], [복사할 객체])
- JsonUtil.fromJson(json, 클래스명.class ) : json형식을 자바 객체로 만들어 준다.
- String.format("%s, %s",error1, error2) : 문자열에 인자로 준 변수를 차례대로 넣어 새로운 문자열로 생성하여 준다. 에러 메시지 등을 만들 때 유용하다.
- Excel 파일의 Content-Type 은 application/vnd.md-excel
## Assert
- .hasText([검증할 필드명],"[해당 필드가 text를 가지고 있지 않을 경우 표시할 메시지]")
- .notEmpty([검증할 필드명], "[검증할 필드가 빈 값일 경우 표시할 메시지]")

### Q) static / final / static final  (https://gobae.tistory.com/3)
- static으로 선언한 필드나 메서드는 this를 사용하지 않고, 해당 필드명 자체로 접근한다.
- final은 더 이상의 값 변경이 없는 경우에 사용된다. 즉 final은 사용하여 선언된 필드는 수정이 불가능하다.
final 필드의 경우, 선언과 동시에 값을 할당하여 줄 수 도 있고, 객체 생성시 생성자 함수를 통해 값을 할당하여 줄 수 있다.
- static final의 경우 상수 선언 시 사용되어, 프로그램 전역에서 고정된 값으로 사용된다. 

# ThreadLocal
ThreadLocal 타입의 static으로 선언된 필드를 갖는 클래스를 생성한다.
public class Test

# 서블릿(=Servlet)
기본적으로 서블릿은 javax.servlet.http.HttpServlet을 상속한다.
MyServlet extends HttpServletService() -> javax.servlet.http.HttpServlet -> javas.servlet.GenericServlet

# .classpath 파일 (https://effectivesquid.tistory.com/entry/자바-클래스패스classpath란)
: 클래스를 찾기 위한 경로를 설정해두는 파일이다. 즉 JVM이 프로그램을 실행할 때 클래스파일을 찾는데 기준이 되는 파일 경로를 의미한다. :를 기준으로 나뉘게 된다.
클래스 경로는 프로젝트에서 자바 빌더가 고려한 자바 소스 파일 및 자원 파일을 지정하고, 프로젝트 외부에서 유형을 찾는 방법을 지정한다.
.classpath는 환경변수를 통해 설정하는 방식과, java runtime에 -clsspath 플래그를 사용하는 방식이 있다.

https:/jjjwodls.github.io/etc/2020/01/07/01-kafka-setup.html
hzttps://bada744.tistory.com/59

# ERROR
- DataIntegrityViolationException e
: unique로 설정된 이미 존재하는 데이터를 넣으려 하는 경우.

# 사용자 권한 설정
* enum으로 user role 작성
@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER)
    ;

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}


## 웹사이트 공격방법
- SQL injection
- XSS(cross-site-scripting)
- CSRF(cross-site-requre-forgery)
: 웹 사이트 취약점 공격을 방지하기 위해 사용되는 기술이다.
- 클릭재킹(clickjacking)


윈도우 명령어 (help [명령어])
- cd : 위치 변경 
- dir 하위 파일 목록 보여줌
- ipconfig 네트워크 설정상태 보기 / inconfig -all
- mkdir / md : 폴더 생성
- rd / rmdir : 폴더 삭제
- path : 환경변수 설정 보여줌
- cls :  현재 명령 프롬프트 창 초기화
- del : 파일 삭제
- copy [복사할 파일명] [복사할 경로]
- xcopy [복사할 파일명] [복사할 경로]  copy와의 차이점을 xcopy는 숨김파일도 복사 가능
- move [파일명] [이동할 위치 경로]
- rename [현재파일명] [변경후파일명]
- date : 현재 날짜 보여줌 
- tasklist : 현재 실행중인 프로세스를 모두 보여준다.
- exit : 현재 명령 프롬프트 창 종료
- echo %cd% : 현재 경로 보여줌

.tgz 압축풀기
tar -zxvf [압축풀기하는파일명] -C [압축풀려는위치]

# kafka

## zookeeper 실행 ----------------------------
C:\tool\kafka_2.13-3.2.0\bin\windows\zookeeper-server-start.bat C:\tool\kafka_2.13-3.2.0\config\zookeeper.properties
[경로]bin/windows/zookeeper-server-start.bat [경로]config/zookeeper.properties
- 2181 port


## kafka 실행------------------------------
C:\tool\kafka_2.13-3.2.0\bin\windows\kafka-server-start.bat C:\tool\kafka_2.13-3.2.0\config\server.properties
[경로]bin/windows/kafka-server-start.bat [경로]/config/server.properties
- 9092 port


> [ 경로 ] / kafka_2.13.7-2.7.0/bin/windows에서
### 토픽 생성 ------------------------------------------------------------
kafka-topics.bat --create --bootstrap-server localhost:9092 --topic oing
kafka-topics.bat --create --bootstrap-server localhost:9092 --topic [생성할토픽명]

### 토픽 메세지 보내기 -----------------------------------------------------------
kafka-console-producer.bat --broker-list localhost:9092 --topic oing
kafka-console-producer.bat --broker-list localhost:9092 --topic [어떤토픽에서메세지보낼지해당토픽명]

### 토픽 구독 ------------------------------------------------------------
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic oing --from-beginning
kafka-console-consumer.bat --bootstarp-server localhost:9092 --topic [구독할 토픽명] --fron-beginning

### 토픽 정보 ---------------------------------------------------------
kafka-topics.bat --list --bootstrap-server localhost:9092
kafka-topics.bat --list --bootatrap-server localhost:[port]

### 토픽삭제 ------------------------------------------------------------
kafka-topics.bat --delete-topic ingdaddy --bootstrap-server localhost:9092


# 프로그램 설치 경로 관련
인텔리제이 경로-------------
C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.3

삼성 net-------------------------
http://kr3.samsung.net/portal/desktop/main.do

kafka--------------------------
kafka 경로 : C:\tool\kafka_2.13-3.2.0\bin\windows
kafka 설명 : https://ifuwanna.tistory.com/487?category=931933
kafka log-dirs 위치 : C:\tool\kafka_2.13-3.2.0\config
