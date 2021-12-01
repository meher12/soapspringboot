package guru.springmk.service;

import com.myschemasoap.spring_boot_soap.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
  public static final Map<String, User> users = new HashMap<>();

  @PostConstruct
  public void initData(){

      User peter = new User();
      peter.setName("Peter");
      peter.setEmpId(1111);
      peter.setSalary(12000);
      users.put(peter.getName(), peter);

      User sam = new User();
      sam.setName("Sam");
      sam.setEmpId(1112);
      sam.setSalary(32000);
      users.put(sam.getName(), sam);

      User ryan = new User();
      ryan.setName("Ryan");
      ryan.setEmpId(1113);
      ryan.setSalary(16000);
      users.put(ryan.getName(), ryan);
  }

  public User getUsers(String name){
      return users.get(name);
  }
}
