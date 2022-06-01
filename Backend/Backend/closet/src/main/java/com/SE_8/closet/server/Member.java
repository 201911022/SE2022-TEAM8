import javax.persistence.*;

@Entity
public class Member {
    @Id
    private String id;
    private Integer pw;
    private String name;


}