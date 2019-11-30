import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author John·Louis
 * @date create in 2019/11/9
 * description:
 */
public class PassWord {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));

    }
}
