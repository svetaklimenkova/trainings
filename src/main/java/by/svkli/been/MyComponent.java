package by.svkli.been;

@Component
public class MyComponent {

    @Autowired
    private MyRepository repository;

    public void showAppInfo() {
        System.out.println("Now is: "+ repository.getSystemDateTime());
        System.out.println("App Name: "+ repository.getAppName());
    }

}