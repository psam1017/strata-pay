## 프로젝트 간단 소개

오늘 갑자기 전략 패턴을 가미한 Spring Boot 프로젝트가 만들어보고 싶어서 바로 만들어봤습니다.

Strategy 패턴(전략 패턴)은 어떤 작업을 수행하는 여러 알고리즘(또는 행위)을 각기 별도의 클래스로 캡슐화하고, 상황에 따라 쉽게 교체하여 사용할 수 있도록 하는 디자인 패턴입니다. 이를 위해 유사한 행위들을 캡슐화하는 인터페이스를 정의하고, 다형성을 활용하여 여러 전략을 확장할 수 있게 됩니다.

![image](https://github.com/user-attachments/assets/48466966-d6f4-41ca-8239-fb062e9ec7eb)

UseCase 클래스는 StrategySelector, Strategy, Service 를 호출합니다.
  - StrategySelector 는 결제수단을 해석하고 적절한 Strategy 를 찾아줍니다.
  - Strategy 는 결제수단에 따라 적절한 Payment 엔티티의 상속 엔티티를 반환합니다.
  - Service 를 이 엔티티를 Repository 로 저장하고 있습니다.
    - 반환되는 Payment 의 상속 엔티티는 Payment 와 상속 관계이므로 PaymentRepository 하나만 있어도 JPA 가 알아서 저장해줍니다.

---

PR 에 리뷰포인트를 남겨두었으니 참고해주세요.

- [PR 바로가기](https://github.com/psam1017/strata-pay/pull/1)
