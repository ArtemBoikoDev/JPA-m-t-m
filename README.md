не делать сущность User, это в базах зарезервированное слово



под аннотацией RestController
@RequestMapping("/api/users")



под сервисом
@Transactional



сущность implements Serializable



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)



важно убрать
@Column(name = "id", nullable = false)



JpaRepository<User, Integer>



@Table(name = "user")



@ManyToOne
@JoinColumn(name = "user_id")



@OneToMany(mappedBy = "user")


@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinTable(name = "account_tariff",
joinColumns = @JoinColumn(name = "parent_id"),
inverseJoinColumns = @JoinColumn(name = "child_id"))



везде
fetch = FetchType.LAZY



spring.datasource.url=jdbc:h2:mem:ums;
spring.datasource.driver-class-name=org.h2.Driver

spring.datasource.username=sa
spring.datasource.password=

spring.datasource.url=jdbc:mysql://localhost:3306/quick
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create



maven repository h2
<scope>runtime</scope>

maven repository mysql



@PathVariable("userId") int userId



в методе контроллера create
@RequestBody



приколы с сериализацией
-----------------------------------
spring.jackson.serialization.fail-on-empty-beans=false

над классом, в котором есть список, либо над GenericEntity
@JsonIgnoreProperties({"hibernateLazyInitializer"})

над этим списком
@JsonIgnoreProperties("childEntities")
-----------------------------------
