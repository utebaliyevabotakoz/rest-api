package lombok;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserDto {

    private Integer id;
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String avatar;

}
