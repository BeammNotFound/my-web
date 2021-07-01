#There's Demo of Code
Autho : BeamStark<br>
##集成技术：
``SpringBoot,MyBatis-Plus,Redis,Swagger2,SpringBootAOP,Maven,lombok,Validated,雪花算法,乐观锁，悲观锁，自定义日志审计,自定义MD5加密算法, 
代码自动生成器等``


``controller:``
````java
@RestController
@Api(tags = "testController")
public class UserController{

    @Autowired
    private UserService service;

    @GetMapping("testGet")
//    @Action(description = "testGet")
    @ApiOperation("testGet")
    private CommonResult testGet(){
        return CommonResult.success(service.list());
    }
}
````